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

        source.listUpper_1 = item.get連番();
        source.listUpper_2 = item.get郵便番号();
        source.listUpper_3 = item.get住所();
        source.listUpper_4 = item.get行政区名称();
        source.atena_gyoseikuCode = item.get行政区コード();
        source.listUpper_5 = item.get性別();
        source.listUpper_6 = item.get生年月日();
        source.listUpper_7 = item.get変更前特徴額_１期();
        source.listUpper_8 = item.get変更前特徴額_２期();
        source.listUpper_9 = item.get変更前特徴額_３期();
        source.listLower_1 = item.get通知書番号();
        source.listLower_2 = item.get世帯コード();
        source.listLower_3 = item.get被保険者氏名();
        source.listLower_4 = item.get特別徴収義務者();
        source.listLower_5 = item.get特別徴対象年金();
        source.listLower_6 = item.get変更後特徴額_１期();
        source.listLower_7 = item.get変更後特徴額_２期();
        source.listLower_8 = item.get変更後特徴額_３期();

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
        if (entity.get更正後計算後情報() != null && entity.get更正後計算後情報().getFukaShichosonCode() != null) {
            source.shichosonCode = entity.get更正後計算後情報().getFukaShichosonCode().getColumnValue();
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
