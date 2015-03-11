package org.apache.jsp.WEB_002dINF;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class Reg_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.AnnotationProcessor _jsp_annotationprocessor;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_annotationprocessor = (org.apache.AnnotationProcessor) getServletConfig().getServletContext().getAttribute(org.apache.AnnotationProcessor.class.getName());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.release();
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
      out.write("\t<section id=\"reg_wrap\" class=\"hidden\">\r\n");
      out.write("\t\t<div class=\"reg_content border_pink\">\r\n");
      out.write("\t\t\t<div class=\"title\">\r\n");
      out.write("\t\t\t\t<img src=\"public/img/title_enter.png\">\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<form action=\"Action/Register\" method=\"post\">\r\n");
      out.write("\t\t\t<div class=\"line rline\">\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t<div class=\"pink text_center title_small rtitle\">\r\n");
      out.write("\t\t\t\t基本情報\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<table class=\"info_table\">\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<td>名前:</td>\r\n");
      out.write("\t\t\t\t\t<td><input type=\"text\" name=\"name\" class=\"input_normal radius\" value=\"\"/></td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<td>メールアドレス:</td>\r\n");
      out.write("\t\t\t\t\t<td><input type=\"text\" name=\"email\" class=\"input_normal radius\" value=\"\"/></td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<td>年代:</td>\r\n");
      out.write("\t\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t\t<select name=\"age\" class=\"radius select_normal\">\r\n");
      out.write("\t\t\t\t\t\t\t<option value=\"1\">20~25歳</option>\r\n");
      out.write("\t\t\t\t\t\t\t<option value=\"2\">25~30歳</option>\r\n");
      out.write("\t\t\t\t\t\t\t<option value=\"3\">30~35歳</option>\r\n");
      out.write("\t\t\t\t\t\t\t<option value=\"4\">35歳以上</option>\r\n");
      out.write("\t\t\t\t\t\t</select>\r\n");
      out.write("\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t</table>\r\n");
      out.write("\t\t\t<div class=\"line rline\">\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t<div class=\"pink text_center title_small rtitle\">\r\n");
      out.write("\t\t\t\tセキュリティー情報\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t\t<table class=\"info_table\">\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<td>パスワード:</td>\r\n");
      out.write("\t\t\t\t\t<td><input type=\"password\" name=\"password\" class=\"input_normal radius\" value=\"\"/></td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<td>パスワード確認:</td>\r\n");
      out.write("\t\t\t\t\t<td><input type=\"password\" name=\"passwordConfirm\" class=\"input_normal radius\" value=\"\"/></td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<td colspan=2  class=\"errormessage\">\r\n");
      out.write("\t\t\t\t\t\t<span id=\"errorreg\">");
      if (_jspx_meth_c_005fout_005f0(_jspx_page_context))
        return;
      out.write("</span>\r\n");
      out.write("\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t</table>\r\n");
      out.write("\t\t\t<a href=\"javascript:hidepop()\" id=\"btn_return\">\r\n");
      out.write("\t\t\t\t<img src=\"public/img/popup_cancel.png\"/>\r\n");
      out.write("\t\t\t</a>\r\n");
      out.write("\t\t\t<a href=\"javascript:submit(btn_confirm)\" id=\"btn_confirm\">\r\n");
      out.write("\t\t\t\t<img src=\"public/img/popup_enter.png\"/>\r\n");
      out.write("\t\t\t</a>\r\n");
      out.write("\t\t\t</form>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</section>");
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

  private boolean _jspx_meth_c_005fout_005f0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:out
    org.apache.taglibs.standard.tag.rt.core.OutTag _jspx_th_c_005fout_005f0 = (org.apache.taglibs.standard.tag.rt.core.OutTag) _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.OutTag.class);
    _jspx_th_c_005fout_005f0.setPageContext(_jspx_page_context);
    _jspx_th_c_005fout_005f0.setParent(null);
    // /WEB-INF/Reg.jsp(52,26) name = value type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fout_005f0.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${error }", java.lang.Object.class, (PageContext)_jspx_page_context, null, false));
    int _jspx_eval_c_005fout_005f0 = _jspx_th_c_005fout_005f0.doStartTag();
    if (_jspx_th_c_005fout_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005fout_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005fout_005f0);
    return false;
  }
}
