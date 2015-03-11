package org.apache.jsp.WEB_002dINF;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class YRS017_005fLogout_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<title>ログアウトー嫁レシピ</title>\r\n");
      out.write("<meta name=\"keywords\" content=\"結婚, 婚活, レシピ, 花嫁修業, 料理, 美味しい, 簡単\">\r\n");
      out.write("<meta name=\"description\" content=\"あなたの婚活をサポートするレシピレコメンドサイト\">\r\n");
      out.write("<link rel=\"stylesheet\" href=\"public/css/index.css\" type=\"text/css\">\r\n");
      out.write("<link rel=\"stylesheet\" href=\"public/css/login.css\" type=\"text/css\">\r\n");
      out.write("<script type=\"text/javascript\" src=\"public/js/popup.js\"></script>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("<section id=\"shade\" class=\"hidden\">\r\n");
      out.write("</section>\r\n");
      out.write("<header>\r\n");
      out.write("\t<div class=\"header-content\">\r\n");
      out.write("\t<div class=\"logo_index\">\r\n");
      out.write("\t\t<img src=\"public/img/logo.png\" height=\"70\" alt=\"嫁レシピ\"/>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<div class=\"login_area right\">\r\n");
      out.write("\t\t<a href=\"javascript:showlogin()\" id=\"btn_login\"></a>\r\n");
      out.write("\t\t<a href=\"javascript:showreg()\" id=\"btn_reg\"></a>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<div class=\"line_noalpha clear\" >\r\n");
      out.write("\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("</header>\r\n");
      out.write("<section class=\"logout_main\">\r\n");
      out.write("\t<section class=\"center_wrap\">\r\n");
      out.write("\t");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "Reg.jsp", out, true);
      out.write('\r');
      out.write('\n');
      out.write('	');
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "Login.jsp", out, true);
      out.write("\r\n");
      out.write("\t<div class=\"text_center title_huge pink\">\r\n");
      out.write("\t\tログアウトが成功しました\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<a href=\"Action/Index\" id=\"btn_top\" class=\"btn_gray_large\">トップページに戻る</a>\r\n");
      out.write("\t<a href=\"javascript:showlogin()\" id=\"btn_login_main\" class=\"btn_pink_large\">ログイン</a>\r\n");
      out.write("\t</section>\r\n");
      out.write("<section class=\"clear\">\r\n");
      out.write("</section>\r\n");
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
