/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE2310001;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.shujiiikenshotoroku.ShujiiIkenshoTorokuResult;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2310001.ShujiiIkenshoTorokuTotalDiv;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ikensho.IkenshoSakuseiKaisuKubun;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;

/**
 * 主治医意見書登録の抽象Handlerクラスです。
 *
 * @reamsid_L DBE-0070-010 chengsanyuan
 */
public class ShujiiIkenshoTorokuHandler {

    private static final RString SELECT_KEY0 = new RString("key0");
    private static final RString SELECT_KEY1 = new RString("key1");
    private static final RString SELECT_NAIKA = new RString("key0");
    private static final RString SELECT_SEISHINKA = new RString("key1");
    private static final RString SELECT_GEKA = new RString("key2");
    private static final RString SELECT_SEIKEIGEKA = new RString("key3");
    private static final RString SELECT_NOSHINKEIGEKA = new RString("key4");
    private static final RString SELECT_HIFUKA = new RString("key5");
    private static final RString SELECT_HINYOKIKA = new RString("key6");
    private static final RString SELECT_FUJINKA = new RString("key7");
    private static final RString SELECT_GANKA = new RString("key8");
    private static final RString SELECT_JIBIINKOKA = new RString("key9");
    private static final RString SELECT_REHABIRITATIONKA = new RString("key10");
    private static final RString SELECT_SHIKA = new RString("key11");
    private final ShujiiIkenshoTorokuTotalDiv div;

    /**
     * コンストラクタです。
     *
     * @param div 主治医意見書登録Div
     */
    public ShujiiIkenshoTorokuHandler(ShujiiIkenshoTorokuTotalDiv div) {
        this.div = div;
    }

    /**
     * 主治医意見書登録の設定します。
     *
     * @param result 画面のデータ
     */
    public void load(ShujiiIkenshoTorokuResult result) {
        div.getRadDoi().setSelectedKey(result.is意見書同意フラグ() ? SELECT_KEY0 : SELECT_KEY1);
        div.getTxtShujiiShimei().setValue(isEmptyOrNull(result.get主治医氏名()));
        div.getTxtKinyuYMD().setValue(flexToRdate(result.get主治医意見書記入年月日()));
        div.getTxtIryoKikanMeisho().setValue(isEmptyOrNull(result.get医療機関名称()));
        div.getTxtShujiiIryoKikanShozaichi().setDomain(new AtenaJusho(isEmptyOrNull(result.get住所())));
        div.getTxtShujiiIryoKikanTelNumber().setDomain(result.get電話番号() == null ? TelNo.EMPTY : result.get電話番号());
        div.getTxtShujiiIryoKikanFaxNumber().setDomain(result.getFAX番号() == null ? TelNo.EMPTY : result.getFAX番号());
        div.getTxtSaishuShinryoYMD().setValue(flexToRdate(result.get最終診察日()));
        if (result.get意見書作成回数区分() != null) {
            div.getRadIkenshoSakuseiKaisu().setSelectedKey(
                    IkenshoSakuseiKaisuKubun._2回目以降.getコード().equals(result.get意見書作成回数区分().value())
                    ? SELECT_KEY1 : SELECT_KEY0);
        }
        div.getRadTakaShinryo().setSelectedKey(result.is他科受診の有無() ? SELECT_KEY0 : SELECT_KEY1);
        setChkTakaJushin(result);
        List<RString> selKeysList = new ArrayList<>();
        if (result.isその他受診科の有無()) {
            selKeysList.add(SELECT_KEY0);
        }
        div.getChkSonota().setSelectedItemsByKey(selKeysList);
        div.getTxtSonotaNyuryoku().setValue(isEmptyOrNull(result.getその他受診科名()));
        div.getTxtShujiiMemo().setValue(isEmptyOrNull(result.getメモ()));
        setShujiiJohoDisable(true);
        setChosaTishoJohoDisable(!result.is他科受診の有無());
        setSonotaDisable(!result.isその他受診科の有無());
    }

    /**
     * 編集前のデータを取得します。
     *
     * @return RString 画面のデータ
     */
    public RString getDataRString() {
        RStringBuilder rsb = new RStringBuilder();
        rsb.append(div.getRadDoi().getSelectedValue());
        rsb.append(div.getTxtSaishuShinryoYMD().getValue() == null
                ? RString.EMPTY : div.getTxtSaishuShinryoYMD().getValue().toDateString());
        rsb.append(div.getRadIkenshoSakuseiKaisu().getSelectedKey());
        rsb.append(div.getRadTakaShinryo().getSelectedKey());
        for (RString selKey : div.getChkTakaJushinSelect().getSelectedKeys()) {
            rsb.append(selKey);
        }
        for (RString selKey : div.getChkSonota().getSelectedKeys()) {
            rsb.append(selKey);
        }
        rsb.append(div.getTxtSonotaNyuryoku().getValue());
        rsb.append(div.getTxtKinyuYMD().getValue());
        rsb.append(div.getTxtShujiiMemo().getValue());
        return rsb.toRString();
    }

    /**
     * チェック変更した際の選択項目により、他科診療チェックボックスを変更可能にします。
     *
     * @param takaFlag 他科診療有無フラグ
     */
    public void setChosaTishoJohoDisable(boolean takaFlag) {
        div.getChkTakaJushinSelect().setDisabled(takaFlag);
        div.getChkSonota().setDisabled(takaFlag);
        div.getTxtSonotaNyuryoku().setDisabled(true);
        List<RString> selKeysList = new ArrayList<>();
        div.getChkTakaJushinSelect().setSelectedItemsByKey(selKeysList);
        div.getChkSonota().setSelectedItemsByKey(selKeysList);
        div.getTxtSonotaNyuryoku().clearValue();
    }

    /**
     * チェック変更した際の選択項目により、その他チェックボックスを変更可能にします。
     *
     * @param sonotaFlag その他フラグ
     */
    public void setSonotaDisable(boolean sonotaFlag) {
        div.getTxtSonotaNyuryoku().setDisabled(sonotaFlag);
        if (sonotaFlag) {
            div.getTxtSonotaNyuryoku().clearValue();
        }
    }

    private void setShujiiJohoDisable(boolean flag) {
        div.getTxtIryoKikanMeisho().setDisabled(flag);
        div.getTxtShujiiIryoKikanShozaichi().setDisabled(flag);
        div.getTxtShujiiIryoKikanTelNumber().setDisabled(flag);
        div.getTxtShujiiIryoKikanFaxNumber().setDisabled(flag);
    }

    private void setChkTakaJushin(ShujiiIkenshoTorokuResult result) {
        List<RString> selKeysList = new ArrayList<>();
        if (result.is内科受診の有無()) {
            selKeysList.add(SELECT_NAIKA);
        }
        if (result.is精神科受診の有無()) {
            selKeysList.add(SELECT_SEISHINKA);
        }
        if (result.is外科受診の有無()) {
            selKeysList.add(SELECT_GEKA);
        }
        if (result.is整形外科受診の有無()) {
            selKeysList.add(SELECT_SEIKEIGEKA);
        }
        if (result.is脳神経外科受診の有無()) {
            selKeysList.add(SELECT_NOSHINKEIGEKA);
        }
        if (result.is皮膚科受診の有無()) {
            selKeysList.add(SELECT_HIFUKA);
        }
        if (result.is泌尿器科受診の有無()) {
            selKeysList.add(SELECT_HINYOKIKA);
        }
        if (result.is婦人科受診の有無()) {
            selKeysList.add(SELECT_FUJINKA);
        }
        if (result.is眼科受診の有無()) {
            selKeysList.add(SELECT_GANKA);
        }
        if (result.is耳鼻咽喉科受診の有無()) {
            selKeysList.add(SELECT_JIBIINKOKA);
        }
        if (result.isﾘﾊﾋﾞﾘﾃｰｼｮﾝ科受診の有無()) {
            selKeysList.add(SELECT_REHABIRITATIONKA);
        }
        if (result.is歯科受診の有無()) {
            selKeysList.add(SELECT_SHIKA);
        }
        div.getChkTakaJushinSelect().setSelectedItemsByKey(selKeysList);
    }

    private RString isEmptyOrNull(RString rstr) {
        if (RString.isNullOrEmpty(rstr)) {
            return RString.EMPTY;
        }
        return rstr;
    }

    private RDate flexToRdate(FlexibleDate fromDate) {
        if (fromDate == null || fromDate.isEmpty()) {
            return null;
        }
        return new RDate(fromDate.getYearValue(), fromDate.getMonthValue(), fromDate.getDayValue());
    }
}
