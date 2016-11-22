/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.core.tokuchokarisanteitsuchishohakko;

import java.util.List;
import jp.co.ndensan.reams.db.dbb.business.report.tokubetsuchoshukaishitsuchishokarihakkoichiran.KaishiTsuchishoKariHakkoIchiranProperty;
import jp.co.ndensan.reams.db.dbb.entity.report.tokubetsuchoshukaishitsuchishokarihakkoichiran.TokubetsuChoshuKaishiTsuchishoKariHakkoIchiranSource;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.ReportLineRecord;
import jp.co.ndensan.reams.uz.uza.report.source.breaks.PageBreaker;

/**
 * 特徴開始通知書(仮算定）の発行用引数クラスです。
 *
 * @reamsid_L DBB-0790-040 chenaoqi
 */
public class TokuchoKaishiTsuchishoKarisanteiPageBreak
        extends PageBreaker<TokubetsuChoshuKaishiTsuchishoKariHakkoIchiranSource> {

    private final List<RString> breakKeysList;

    /**
     *
     * @param breakKeys List<RString>
     */
    public TokuchoKaishiTsuchishoKarisanteiPageBreak(List<RString> breakKeys) {
        this.breakKeysList = breakKeys;
    }

    @Override
    public List<RString> breakKeys() {
        return breakKeysList;
    }

    @Override
    public boolean isBreak(ReportLineRecord<TokubetsuChoshuKaishiTsuchishoKariHakkoIchiranSource> currentSource,
            ReportLineRecord<TokubetsuChoshuKaishiTsuchishoKariHakkoIchiranSource> nextSource) {
        boolean flag;
        if (this.breakKeysList.contains(KaishiTsuchishoKariHakkoIchiranProperty.BreakerFieldsEnum.郵便番号.get項目ID())
                && !currentSource.getSource().listUpper_2.equals(nextSource.getSource().listUpper_2)) {
            flag = true;
        } else if (this.breakKeysList.contains(KaishiTsuchishoKariHakkoIchiranProperty.BreakerFieldsEnum.町域コード.get項目ID())
                && !currentSource.getSource().atesaki_choikiCode.equals(nextSource.getSource().atesaki_choikiCode)) {
            flag = true;
        } else if (this.breakKeysList.contains(KaishiTsuchishoKariHakkoIchiranProperty.BreakerFieldsEnum.番地コード.get項目ID())
                && !currentSource.getSource().atesaki_banchiCode.equals(nextSource.getSource().atesaki_banchiCode)) {
            flag = true;
        } else if (this.breakKeysList.contains(KaishiTsuchishoKariHakkoIchiranProperty.BreakerFieldsEnum.行政区コード.get項目ID())
                && !currentSource.getSource().atesaki_gyoseikuCode.equals(nextSource.getSource().atesaki_gyoseikuCode)) {
            flag = true;
        } else if (this.breakKeysList.contains(KaishiTsuchishoKariHakkoIchiranProperty.BreakerFieldsEnum.地区１.get項目ID())
                && !currentSource.getSource().atesaki_chikuCode1.equals(nextSource.getSource().atesaki_chikuCode1)) {
            flag = true;
        } else if (this.breakKeysList.contains(KaishiTsuchishoKariHakkoIchiranProperty.BreakerFieldsEnum.地区２.get項目ID())
                && !currentSource.getSource().atesaki_chikuCode2.equals(nextSource.getSource().atesaki_chikuCode2)) {
            flag = true;
        } else {
            flag = isBreak_1(currentSource, nextSource);
        }
        return flag;
    }

    private boolean isBreak_1(ReportLineRecord<TokubetsuChoshuKaishiTsuchishoKariHakkoIchiranSource> currentSource,
            ReportLineRecord<TokubetsuChoshuKaishiTsuchishoKariHakkoIchiranSource> nextSource) {
        boolean flag;
        if (this.breakKeysList.contains(KaishiTsuchishoKariHakkoIchiranProperty.BreakerFieldsEnum.地区３.get項目ID())
                && !currentSource.getSource().atesaki_chikuCode3.equals(nextSource.getSource().atesaki_chikuCode3)) {
            flag = true;
        } else if (this.breakKeysList.contains(KaishiTsuchishoKariHakkoIchiranProperty.BreakerFieldsEnum.世帯コード.get項目ID())
                && !currentSource.getSource().listLower_2.equals(nextSource.getSource().listLower_2)) {
            flag = true;
        } else if (this.breakKeysList.contains(KaishiTsuchishoKariHakkoIchiranProperty.BreakerFieldsEnum.識別コード.get項目ID())
                && !currentSource.getSource().atena_shikibetsuCode
                .equals(nextSource.getSource().atena_shikibetsuCode)) {
            flag = true;
        } else if (this.breakKeysList.contains(KaishiTsuchishoKariHakkoIchiranProperty.BreakerFieldsEnum.氏名５０音カナ.get項目ID())
                && !currentSource.getSource().atena_kanaMeisho.equals(nextSource.getSource().atena_kanaMeisho)) {
            flag = true;
        } else if (this.breakKeysList.contains(KaishiTsuchishoKariHakkoIchiranProperty.BreakerFieldsEnum.生年月日.get項目ID())
                && !currentSource.getSource().listUpper_5.equals(nextSource.getSource().listUpper_5)) {
            flag = true;
        } else if (this.breakKeysList.contains(KaishiTsuchishoKariHakkoIchiranProperty.BreakerFieldsEnum.性別.get項目ID())
                && !currentSource.getSource().listUpper_6.equals(nextSource.getSource().listUpper_6)) {
            flag = true;
        } else {
            flag = isBreak_2(currentSource, nextSource);
        }
        return flag;
    }

    private boolean isBreak_2(ReportLineRecord<TokubetsuChoshuKaishiTsuchishoKariHakkoIchiranSource> currentSource,
            ReportLineRecord<TokubetsuChoshuKaishiTsuchishoKariHakkoIchiranSource> nextSource) {
        boolean flag = false;
        if (this.breakKeysList.contains(KaishiTsuchishoKariHakkoIchiranProperty.BreakerFieldsEnum.市町村コード.get項目ID())
                && !currentSource.getSource().dbT2015KeisangoJoho_fukaShichosonCode
                .equals(nextSource.getSource().dbT2015KeisangoJoho_fukaShichosonCode)) {
            flag = true;
        } else if (this.breakKeysList.contains(KaishiTsuchishoKariHakkoIchiranProperty.BreakerFieldsEnum.被保険者番号.get項目ID())
                && !currentSource.getSource().hokenshaNo.equals(nextSource.getSource().hokenshaNo)) {
            flag = true;
        } else if (this.breakKeysList.contains(KaishiTsuchishoKariHakkoIchiranProperty.BreakerFieldsEnum.年金コード.get項目ID())
                && !currentSource.getSource().nenkinTokuchoKaifuJoho_nenkinCode
                .equals(nextSource.getSource().nenkinTokuchoKaifuJoho_nenkinCode)) {
            flag = true;
        } else if (this.breakKeysList.contains(KaishiTsuchishoKariHakkoIchiranProperty.BreakerFieldsEnum.生活保護種別.get項目ID())
                && !currentSource.getSource().dbT2015KeisangoJoho_seihofujoShurui
                .equals(nextSource.getSource().dbT2015KeisangoJoho_seihofujoShurui)) {
            flag = true;
        } else if (this.breakKeysList.contains(KaishiTsuchishoKariHakkoIchiranProperty.BreakerFieldsEnum.納組コード.get項目ID())
                && !currentSource.getSource().caT0714SeikyuHoho_nokumiCode
                .equals(nextSource.getSource().caT0714SeikyuHoho_nokumiCode)) {
            flag = true;
        } else if (this.breakKeysList.contains(KaishiTsuchishoKariHakkoIchiranProperty.BreakerFieldsEnum.調定事由.get項目ID())
                && !currentSource.getSource().dbT2015KeisangoJoho_choteiJiyu1
                .equals(nextSource.getSource().dbT2015KeisangoJoho_choteiJiyu1)) {
            flag = true;
        }
        return flag;
    }
}
