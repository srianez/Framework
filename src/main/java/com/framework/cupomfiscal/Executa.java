package com.framework.cupomfiscal;

import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.itextpdf.text.Document;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.Barcode;
import com.itextpdf.text.pdf.Barcode128;
import com.itextpdf.text.pdf.BarcodeQRCode;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfWriter;
import com.framework.core.JpaUtil;
import com.framework.model.*;

public class Executa {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		
		Document document = new Document();
		Integer contadorPedido = 0;
		Integer contadorItemPedido = 0;
		Double  total = (double) 0;
		
		try {

		
			List<Pedido> queryPedido = 
					JpaUtil.getEntityManager().createQuery("SELECT p FROM Pedido p where id = 16").getResultList();
			System.out.println("\n\n\n***********************&&&&&&&&&&&&&&&&&&&&&*******\n\n\n");
			

			
			List<ItemPedido> queryItemPedido = 
					JpaUtil.getEntityManager().createQuery("SELECT p FROM ItemPedido p where id_pedido = 16").getResultList();

			System.out.println("\n\n\n************\n\n\n");
			
			for (Pedido pedido : queryPedido) {
				
				System.out.println("#################################################");
				
				contadorPedido = contadorPedido + 1;
			
				PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("D:\\silas\\PDF_NF_" + contadorPedido + ".pdf"));
				document.open();
				
				document.add(new Paragraph("                       LOJAS PEPEKAS                  "));
				document.add(new Paragraph("                Rua Dr. Mário de Moura                "));
				document.add(new Paragraph("                     SÃO PAULO - SP                   "));
				document.add(new Paragraph("                                                      "));
				document.add(new Paragraph("CNPJ:12.345.678/9999-99                               "));
				document.add(new Paragraph("IE:88.789.678/9999-99                                 "));
				document.add(new Paragraph("IM:45.678/9999-99                                     "));
				document.add(new Paragraph("......................................................"));
				document.add(new Paragraph(pedido.getData() +  "CCF: 01033    COD: 123456"));
				document.add(new Paragraph("CUPOM FISCAL"));
				document.add(new Paragraph(" "));
				document.add(new Paragraph("ITEM     CÓDIGO     DESCRIÇÃO     QTD       VL UNIT(R$)"));
				
				for (ItemPedido itemPedido : queryItemPedido) {
			      contadorItemPedido = contadorItemPedido + 1;
			      document.add(new Paragraph(contadorItemPedido + "             " + itemPedido.getCodigo() +  "                  " + itemPedido.getDescricao() + "           " + itemPedido.getQuantidade() +"               " + itemPedido.getValorUnitario() ));
				  total = total + itemPedido.getValorUnitario();
				}
				contadorItemPedido = 0;
				
				document.add(new Paragraph("                                                       "));
				document.add(new Paragraph("                                                       "));				
				document.add(new Paragraph("TOTAL R$                                       " + total));
				document.add(new Paragraph(pedido.getHash()));
				document.add(new Paragraph("EMPRESA BLA BLA BLA                                    "));
				document.add(new Paragraph("VERSÃO 012.009                                         "));
				document.add(new Paragraph("BLA BLA BLA BLA BLA                                    "));
				
				PdfContentByte cb = writer.getDirectContent();
				//Barcode128 barcode128 = new Barcode128();
				//barcode128.setCode("teste");
				//barcode128.setCodeType(Barcode.CODE128);
				//Image code128Image = barcode128.createImageWithBarcode(cb, null, null);
				//document.add(code128Image);
				
				//BarcodeQRCode barcodeQRCode = new BarcodeQRCode("teste qrcode", 1000, 1000, null);
				//Image codeQrImage = barcodeQRCode.getImage();
				//codeQrImage.scaleAbsolute(100, 100);
				//document.add(codeQrImage);
				
				document.addSubject("Gerando PDF em java");
				document.addKeywords("www.fiap.com");
				document.addCreator("29SCJ");
				document.addAuthor("Dunha");
				document.close();
			
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		document.close();

	}

}
