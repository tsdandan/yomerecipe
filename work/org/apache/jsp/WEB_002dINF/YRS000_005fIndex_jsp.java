package org.apache.jsp.WEB_002dINF;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class YRS000_005fIndex_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.AnnotationProcessor _jsp_annotationprocessor;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_annotationprocessor = (org.apache.AnnotationProcessor) getServletConfig().getServletContext().getAttribute(org.apache.AnnotationProcessor.class.getName());
  }

  public void _jspDestroy() {
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "CommonHeader.jsp", out, true);
      out.write("\r\n");
      out.write("<title>嫁レシピ</title>\r\n");
      out.write("<meta name=\"keywords\" content=\"結婚, 婚活, レシピ, 花嫁修業, 料理, 美味しい, 簡単\">\r\n");
      out.write("<meta name=\"description\" content=\"あなたの婚活をサポートするレシピレコメンドサイト\">\r\n");
      out.write("<link rel=\"stylesheet\" href=\"public/css/index.css\" type=\"text/css\">\r\n");
      out.write("<link rel=\"stylesheet\" href=\"public/css/login.css\" type=\"text/css\">\r\n");
      out.write("<script type=\"text/javascript\" src=\"public/js/slide.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"public/js/popup.js\"></script>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("<section id=\"shade\" class=\"hidden\">\r\n");
      out.write("</section>\r\n");
      out.write("<header>\r\n");
      out.write("\t<div class=\"header-content\">\r\n");
      out.write("\t\t<div class=\"logo_index\">\r\n");
      out.write("\t\t\t<a href=\"Action/Index\"><img src=\"public/img/logo.png\" height=\"70\" alt=\"嫁レシピ\"/></a>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div class=\"login_area right\">\r\n");
      out.write("\t\t\t<a href=\"javascript:showlogin();\" id=\"btn_login\"></a>\r\n");
      out.write("\t\t\t<a href=\"javascript:showreg();\" id=\"btn_reg\"></a>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("</header>\r\n");
      out.write("<div class=\"headline clear\" >\r\n");
      out.write("</div>\r\n");
      out.write("<section class=\"main\">\r\n");
      out.write("\t");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "Reg.jsp", out, true);
      out.write('\r');
      out.write('\n');
      out.write('	');
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "Login.jsp", out, true);
      out.write("\r\n");
      out.write("\t<section class=\"slide_wrap\">\r\n");
      out.write("\t<section class=\"slide_area text_center  slide_first\"  id=\"slider1\">\r\n");
      out.write("\t\t<article class=\"slider\">\r\n");
      out.write("\t\t\t<img src=\"public/img/banner1.jpg\"/ alt=\"スライダーー嫁レシピ\">\r\n");
      out.write("\t\t</article>\r\n");
      out.write("\t\t<a id=\"btn_slide_reg1\" href=\"javascript:showreg();\"></a>\r\n");
      out.write("\t</section>\r\n");
      out.write("\t<section class=\"slide_area text_center slide_second\"  id=\"sliderhide\">\r\n");
      out.write("\t\t<article class=\"slider\">\r\n");
      out.write("\t\t\t<img src=\"public/img/banner2.jpg\"　alt=\"スライダーー嫁レシピ\"/>\r\n");
      out.write("\t\t</article>\r\n");
      out.write("\t\t<a id=\"btn_slide_reg2\" href=\"javascript:showreg();\"></a>\r\n");
      out.write("\t</section>\r\n");
      out.write("\t<section class=\"slide_area text_center slide_first hidden\"  id=\"slider2\">\r\n");
      out.write("\t\t<article class=\"slider\">\r\n");
      out.write("\t\t\t<img src=\"public/img/banner2.jpg\"　alt=\"スライダーー嫁レシピ\"/>\r\n");
      out.write("\t\t</article>\r\n");
      out.write("\t\t<a id=\"btn_slide_reg2\" href=\"javascript:showreg();\"></a>\r\n");
      out.write("\t</section>\r\n");
      out.write("\t<section class=\"slide_area text_center slide_first hidden\"  id=\"slider3\">\r\n");
      out.write("\t\t<article class=\"slider\">\r\n");
      out.write("\t\t\t<img src=\"public/img/banner3.jpg\"　alt=\"スライダーー嫁レシピ\"/>\r\n");
      out.write("\t\t</article>\r\n");
      out.write("\t\t<a id=\"btn_slide_reg3\" href=\"javascript:showreg();\"></a>\r\n");
      out.write("\t</section>\r\n");
      out.write("\t</section>\r\n");
      out.write("\t<section class=\"intro\">\r\n");
      out.write("\t\t<section class=\"center_wrap\">\r\n");
      out.write("\t\t\t<section class=\"intro_recipe left\">\r\n");
      out.write("\t\t\t\t<img src=\"public/img/banner_recommend.png\" alt=\"レシピのレコメンド\"/>\r\n");
      out.write("\t\t\t</section>\r\n");
      out.write("\t\t\t<section class=\"intro_level left\">\r\n");
      out.write("\t\t\t\t<img src=\"public/img/banner_levelup.png\" alt=\"レベルアップ\"/>\r\n");
      out.write("\t\t\t</section>\r\n");
      out.write("\t\t\t<section class=\"intro_test left\">\r\n");
      out.write("\t\t\t\t<a href=\"Action/CookTest\" id=\"btn_gotest\">\r\n");
      out.write("\t\t\t\t\t<img src=\"public/img/button_test.png\" alt=\"テストから始める\"/>\r\n");
      out.write("\t\t\t\t</a>\r\n");
      out.write("\t\t\t</section>\r\n");
      out.write("\t\t</section>\r\n");
      out.write("\t</section>\r\n");
      out.write("</section>\r\n");
      out.write("<section class=\"clear\">\r\n");
      out.write("</section>\r\n");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "Footer.jsp", out, true);
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else log(t.getMessage(), t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
