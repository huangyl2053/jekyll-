/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.dbbmn35003.dbb200004;

import jp.co.ndensan.reams.db.dbb.entity.db.relate.tokuchoheijunka6tsuchishoikatsuhako.KarisanteiGakuHenkoEntity;
import jp.co.ndensan.reams.db.dbb.entity.report.dbbmn35003.dbb200004.TokuChoHeijunkaKariSanteigakuHakkoIchiranReportSource;
import jp.co.ndensan.reams.uz.uza.biz.AtenaBanchi;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.ChoikiCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;

/**
 * 特別徴収平準化_仮算定額変更通知書_発行一覧表ボディEditorです。
 *
 * @reamsid_L DBB-0820-060 xuyue
 */
class TokuChoHeijunkaKariSanteigakuHakkoIchiranBodyEditor implements ITokuChoHeijunkaKariSanteigakuHakkoIchiranEditor {

    private final KarisanteiGakuHenkoEntity entity;
    private final TokuChoHeijunkaKariSanteigakuHakkoIchiranItem item;

    public TokuChoHeijunkaKariSanteigakuHakkoIchiranBodyEditor(KarisanteiGakuHenkoEntity entity,
            TokuChoHeijunkaKariSanteigakuHakkoIchiranItem item) {
        this.entity = entity;
        this.item = item;
    }

    @Override
    public TokuChoHeijunkaKariSanteigakuHakkoIchiranReportSource edit(TokuChoHeijunkaKariSanteigakuHakkoIchiranReportSource source) {
        return editBody(source);
    }

    private TokuChoHeijunkaKariSanteigakuHakkoIchiranReportSource editBody(TokuChoHeijunkaKariSanteigakuHakkoIchiranReportSource source) {

        source.listUpper_1 = item.getListUpper_1();
        source.listUpper_2 = item.getListUpper_2();
        source.listUpper_3 = item.getListUpper_3();
        source.listUpper_4 = item.getListUpper_4();
        source.listUpper_5 = item.getListUpper_5();
        source.listUpper_6 = item.getListUpper_6();
        source.listUpper_7 = item.getListUpper_7();
        source.listUpper_8 = item.getListUpper_8();
        source.listUpper_9 = item.getListUpper_9();
        source.listLower_1 = item.getListLower_1();
        source.listLower_2 = item.getListLower_2();
        source.listLower_3 = item.getListLower_3();
        source.listLower_4 = item.getListLower_4();
        source.listLower_5 = item.getListLower_5();
        source.listLower_6 = item.getListLower_6();
        source.listLower_7 = item.getListLower_7();
        source.listLower_8 = item.getListLower_8();

        if (entity.get宛名() != null) {
            ChoikiCode 町域コード = entity.get宛名().getChoikiCode();
            if (町域コード != null) {
                source.atena_choikiCode = 町域コード.getColumnValue();
            }
            ShikibetsuCode 識別コード = entity.get宛名().getShikibetsuCode();
            if (識別コード != null) {
                source.atena_shikibetsuCode = 識別コード.getColumnValue();
            }
            AtenaKanaMeisho 氏名５０音カナ = entity.get宛名().getKanaMeisho();
            if (氏名５０音カナ != null) {
                source.atena_kanaMeisho = 氏名５０音カナ.getColumnValue();
            }
        }
        if (entity.get宛先() != null) {
            AtenaBanchi 番地コード = entity.get宛先().getBanchi();
            if (番地コード != null) {
                source.atesaki_banchi = 番地コード.getColumnValue();
            }
            source.atesaki_chiku1 = entity.get宛先().getChiku1();
            source.atesaki_chiku2 = entity.get宛先().getChiku2();
            source.atesaki_chiku3 = entity.get宛先().getChiku3();
        }
        if (entity.get更正後計算後情報() != null && entity.get更正後計算後情報().getHihokenshaNo() != null) {
            source.koseigo_hihokenshaNo = entity.get更正後計算後情報().getHihokenshaNo().getColumnValue();
        }
        if (entity.get対象者_追加含む情報_更正後() != null) {
            source.nenkinTokuchoKaifuJoho_nenkinCode = entity.get対象者_追加含む情報_更正後().getNenkinCode();
        }
        if (entity.get納組() != null && entity.get納組().getNokumi() != null) {
            source.caT0714SeikyuHoho_nokumiCode = entity.get納組().getNokumi().getNokumiCode();
        }
        return source;
    }

}
