/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE2400001;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.iraisho.IraishoIkkatsuHakkoResult;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2400001.IraishoIkkatsuHakkoDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2400001.dgNinteiChosaIraiTaishoIchiran_Row;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2400001.dgShujiiIkenshoSakuseiIraiTaishoIchiran_Row;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBE;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBU;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.GyomuBunrui;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.binding.CheckBoxList;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;

/**
 *
 * 依頼書一括発行の抽象Handlerクラスです。
 *
 * @reamsid_L DBE-0080-010 duanzhanli
 */
public class IraishoIkkatsuHakkoHandler {

    private static final RString STATE_NINTEIO = new RString("1");
    private static final RString STATE_SHUJII = new RString("2");
    private static final RString COMMON_SELECTED = new RString("key0");
    private static final RString CHOHYO_CHECKED = new RString("key1");
    private static final RString SHUTSU_CHECKED = new RString("key2");
    private static final RString 基本調査 = new RString("key0");
    private static final RString 特記事項 = new RString("key1");
    private static final RString 概況調査 = new RString("key2");
    private static final RString 概況特記 = new RString("key3");
    private static final RString 記入用紙 = new RString("key0");
    private static final RString 記入用紙OCR = new RString("key1");
    private static final RString SHINSEI_KASAN = new RString("2");
    private static final RString OCR = new RString("1");
    private final IraishoIkkatsuHakkoDiv div;

    /**
     * コンストラクタです。
     *
     * @param div 依頼書一括発行Div
     */
    public IraishoIkkatsuHakkoHandler(IraishoIkkatsuHakkoDiv div) {
        this.div = div;
    }

    /**
     *
     * 依頼書一括発行初期化の設定します。
     *
     * @param ninteiShinsei 認定調査期限設定方法
     */
    public void load(RString ninteiShinsei) {
        div.getRadTaishoSentaku().setSelectedKey(COMMON_SELECTED);
        div.getDgNinteiChosaIraiTaishoIchiran().init();
        div.getTxtIraibiFrom().clearValue();
        div.getTxtIraibiTo().clearValue();
        div.getTxtChosaDispMax().clearValue();
        div.getNinteiChosaIraiTaishoIchiran().getDgNinteiChosaIraiTaishoIchiran().getDataSource().clear();
        List<RString> selectKeys = new ArrayList<>();
        selectKeys.add(COMMON_SELECTED);
        div.getChkNinteioChosaIraisho().setSelectedItemsByKey(selectKeys);
        div.getCcdNinteiChosaHokensha().loadHokenshaList(GyomuBunrui.介護認定);
        div.getChkNinteiChosahyo().setSelectedItemsByKey(selectKeys);
        initializeNinteiChkShinseiTani();
        setNinteiChkShinseiTani(true);
        div.getChkNinteiChosaIraiChohyo().setSelectedItemsByKey(Collections.<RString>emptyList());
        div.getChkchosairaihakko().setSelectedItemsByKey(Collections.<RString>emptyList());
        setHakkobiAndTeishutsuKigen(ninteiShinsei);
        div.setState(STATE_NINTEIO);
        div.getTxtChosaDispMax().setValue(new Decimal(DbBusinessConfig
                .get(ConfigNameDBU.検索制御_最大取得件数, RDate.getNowDate(), SubGyomuCode.DBU介護統計報告).toString()));
        div.getTxtChosaDispMax().setMaxValue(new Decimal(DbBusinessConfig
                .get(ConfigNameDBU.検索制御_最大取得件数上限, RDate.getNowDate(), SubGyomuCode.DBU介護統計報告).toString()));
        div.getChkchosairaiRireki().setSelectedItemsByKey(Collections.<RString>emptyList());
    }

    /**
     *
     * 主治医意見書Divの設定します。
     *
     * @param ninteiShinsei 認定調査期限設定方法
     */
    public void shuziiiKenshoLoad(RString ninteiShinsei) {
        div.getDgShujiiIkenshoSakuseiIraiTaishoIchiran().init();
        div.getTxtShujiiIkenshoSakuseiIraibiFrom().clearValue();
        div.getTxtShujiiIkenshoSakuseiIraibiTo().clearValue();
        div.getTxtIkenshoDispMax().clearValue();
        div.getShujiiIkenshoSakuseiIraiTaishoIchiran().getDgShujiiIkenshoSakuseiIraiTaishoIchiran().getDataSource().clear();
        List<RString> selectKeys = new ArrayList<>();
        selectKeys.add(COMMON_SELECTED);
        div.getChkShujiiikenshoSakuseiIrai().setSelectedItemsByKey(selectKeys);
        div.getCcdShujiiIkenshoHokensha().loadHokenshaList(GyomuBunrui.介護認定);
        div.getChkShujiiIkensho().setSelectedItemsByKey(selectKeys);
        setShujiiChkShinseiTani(true);
        div.getChkShujiiIkenshoShutsuryoku().setSelectedItemsByKey(Collections.<RString>emptyList());
        div.getChkikenshiiraihakko().setSelectedItemsByKey(Collections.<RString>emptyList());
        setHakkobiAndTeishutsuKigen(ninteiShinsei);
        div.setState(STATE_SHUJII);
        div.getTxtIkenshoDispMax().setValue(new Decimal(DbBusinessConfig
                .get(ConfigNameDBU.検索制御_最大取得件数, RDate.getNowDate(), SubGyomuCode.DBU介護統計報告).toString()));
        div.getTxtIkenshoDispMax().setMaxValue(new Decimal(DbBusinessConfig
                .get(ConfigNameDBU.検索制御_最大取得件数上限, RDate.getNowDate(), SubGyomuCode.DBU介護統計報告).toString()));
        div.getChkikenshiiraiRireki().setSelectedItemsByKey(Collections.<RString>emptyList());
    }

    /**
     * 対象調査員一覧Gridを設定します。
     *
     * @param resultList 対象調査員一覧データ
     */
    public void setDataGrid(List<IraishoIkkatsuHakkoResult> resultList) {
        if (STATE_NINTEIO.equals(div.getState())) {
            List<dgNinteiChosaIraiTaishoIchiran_Row> rowList = new ArrayList<>();
            for (IraishoIkkatsuHakkoResult result : resultList) {
                dgNinteiChosaIraiTaishoIchiran_Row row = new dgNinteiChosaIraiTaishoIchiran_Row();
                row.setNinteiChosaitakusaki(result.get認定調査委託先コード() == null
                        ? RString.EMPTY : result.get認定調査委託先コード().value());
                row.setNinteiChosaItakusakiMeisho(result.get事業者名称());
                row.setNinteiChosainNo(result.get認定調査員コード());
                row.setNinteiChosainShimei(result.get調査員氏名());
                row.getShinseishaNinzu().setValue(new Decimal(result.get申請者人数()));
                row.setShoKisaiHokenshaNo(result.get証記載保険者番号());
                rowList.add(row);
            }
            div.getDgNinteiChosaIraiTaishoIchiran().setDataSource(rowList);
        }
        if (STATE_SHUJII.equals(div.getState())) {
            List<dgShujiiIkenshoSakuseiIraiTaishoIchiran_Row> rowList = new ArrayList<>();
            for (IraishoIkkatsuHakkoResult result : resultList) {
                dgShujiiIkenshoSakuseiIraiTaishoIchiran_Row row = new dgShujiiIkenshoSakuseiIraiTaishoIchiran_Row();
                row.setShujiiIryoKikanCode(result.get主治医医療機関コード());
                row.setShujiiIryoKikanMeisho(result.get医療機関名称());
                row.setIshiNo(result.get主治医コード());
                row.setIshiShimei(result.get主治医氏名() == null ? RString.EMPTY : result.get主治医氏名().value());
                row.getShinseishaNinzu().setValue(new Decimal(result.get申請者人数()));
                row.setShoKisaiHokenshaNo(result.get証記載保険者番号());
                rowList.add(row);
            }
            div.getDgShujiiIkenshoSakuseiIraiTaishoIchiran().setDataSource(rowList);
        }
    }

    /**
     * 申請単位チェックボックス選択の場合、ある他のチェックボックスを設定します。
     */
    public void setChkShinseiTani() {
        if (STATE_NINTEIO.equals(div.getState())) {
            if (div.getChkNinteiChosaIraiChohyo().getSelectedKeys().contains(CHOHYO_CHECKED)) {
                setNinteiChkShinseiTani(false);
            } else {
                setNinteiChkShinseiTani(true);
            }
        }
        if (STATE_SHUJII.equals(div.getState())) {
            if (div.getChkShujiiIkenshoShutsuryoku().getSelectedKeys().contains(SHUTSU_CHECKED)) {
                setShujiiChkShinseiTani(false);
            } else {
                setShujiiChkShinseiTani(true);
            }
        }
    }

    /**
     * 共通日付txtの使用可否などを設定します。
     */
    public void setTxtKyotsuHizuke() {
        boolean is共通日付 = SHUTSU_CHECKED.equals(div.getRadTeishutsuKigen().getSelectedKey());
        if (is共通日付) {
            div.getTxtKyotsuHizuke().setValue(RDate.getNowDate());
        } else {
            div.getTxtKyotsuHizuke().clearValue();
        }
        div.getTxtKyotsuHizuke().setReadOnly(!is共通日付);
    }

    /**
     * 条件をクリアするボタンの押す処理です。
     */
    public void clearJoken() {
        if (STATE_NINTEIO.equals(div.getState())) {
            div.getTxtIraibiFrom().clearValue();
            div.getTxtIraibiTo().clearValue();
            List<RString> selectKeys = new ArrayList<>();
            selectKeys.add(COMMON_SELECTED);
            div.getChkNinteioChosaIraisho().setSelectedItemsByKey(selectKeys);
            div.getCcdNinteiChosaHokensha().loadHokenshaList(GyomuBunrui.介護認定);
            div.getChkNinteiChosahyo().setSelectedItemsByKey(selectKeys);
            div.getTxtChosaDispMax().clearValue();
            div.getTxtChosaDispMax().setValue(new Decimal(DbBusinessConfig
                    .get(ConfigNameDBU.検索制御_最大取得件数, RDate.getNowDate(), SubGyomuCode.DBU介護統計報告).toString()));
        }
        if (STATE_SHUJII.equals(div.getState())) {
            div.getTxtShujiiIkenshoSakuseiIraibiFrom().clearValue();
            div.getTxtShujiiIkenshoSakuseiIraibiTo().clearValue();
            List<RString> selectKeys = new ArrayList<>();
            selectKeys.add(COMMON_SELECTED);
            div.getChkShujiiikenshoSakuseiIrai().setSelectedItemsByKey(selectKeys);
            div.getCcdShujiiIkenshoHokensha().loadHokenshaList(GyomuBunrui.介護認定);
            div.getChkShujiiIkensho().setSelectedItemsByKey(selectKeys);
            div.getTxtIkenshoDispMax().clearValue();
            div.getTxtIkenshoDispMax().setValue(new Decimal(DbBusinessConfig
                    .get(ConfigNameDBU.検索制御_最大取得件数, RDate.getNowDate(), SubGyomuCode.DBU介護統計報告).toString()));
        }
    }

    private void setShujiiChkShinseiTani(boolean flag) {
        div.getChkShujiIkenshoKinyuAndSakuseiryoSeikyu().setDisabled(flag);
        div.getChkShujiiIkenshoSakuseiIraisho().setDisabled(flag);
        div.getChkShindanMeireishoAndTeishutsuIraisho().setDisabled(flag);
        if (!flag) {
            List<RString> shujiiIkenshoDisabledKeys = new ArrayList<>();
            List<RString> ocrDisabledKeys = new ArrayList<>();
            if (OCR.equals(DbBusinessConfig.get(ConfigNameDBE.意見書用紙タイプ, RDate.getNowDate(), SubGyomuCode.DBE認定支援))) {
                shujiiIkenshoDisabledKeys.add(記入用紙);
                div.getChkShujiIkenshoKinyuAndSakuseiryoSeikyu().setDisabledItemsByKey(shujiiIkenshoDisabledKeys);
            } else {
                ocrDisabledKeys.add(記入用紙OCR);
                div.getChkShujiIkenshoKinyuAndSakuseiryoSeikyu().setDisabledItemsByKey(ocrDisabledKeys);
            }
        }
        clear主治医意見書申請単位();
    }

    private void initializeNinteiChkShinseiTani() {
        RDate 基準日 = RDate.getNowDate();
        boolean isデザイン用紙不使用 = is使用ByConfig(ConfigNameDBE.認定調査票_デザイン用紙_出力有無, 基準日);
        boolean is特記デザイン用紙不使用 = is使用ByConfig(ConfigNameDBE.認定調査票_特記事項_デザイン用紙_出力有無, 基準日);
        boolean isOCR不使用 = is使用ByConfig(ConfigNameDBE.認定調査票_OCR_出力有無, 基準日);
        boolean is特記OCR不使用 = is使用ByConfig(ConfigNameDBE.認定調査票_特記事項_OCR_出力有無, 基準日);
        boolean is差異チェック票不使用 = is使用ByConfig(ConfigNameDBE.認定調査差異チェック票_出力有無, 基準日);
        boolean is概要特記不使用 = is使用ByConfig(ConfigNameDBE.認定調査票_概況特記_出力有無, 基準日);
        boolean is特記事項項目有不使用 = is使用ByConfig(ConfigNameDBE.認定調査票_特記事項_項目有り_出力有無, 基準日);
        boolean is特記事項項目無不使用 = is使用ByConfig(ConfigNameDBE.認定調査票_特記事項_項目無し_出力有無, 基準日);
        boolean is特記事項フリー不使用 = is使用ByConfig(ConfigNameDBE.認定調査票_特記事項_フリータイプ_出力有無, 基準日);
        div.getChkChosaDesign().setDisplayNone(isデザイン用紙不使用);
        div.getChkTokkiDesign().setDisplayNone(is特記デザイン用紙不使用);
        div.getChkChosaOcr().setDisplayNone(isOCR不使用);
        div.getChkTokkiOcr().setWrap(isOCR不使用);
        div.getChkTokkiOcr().setDisplayNone(is特記OCR不使用);
        div.getChkSaiCheck().setDisplayNone(is差異チェック票不使用);
        div.getChkGaikyoTokki().setWrap(is差異チェック票不使用);
        div.getChkGaikyoTokki().setDisplayNone(is概要特記不使用);
        div.getChosahyoSelectItemsTwo().setDisplayNone(isデザイン用紙不使用 && is特記デザイン用紙不使用 && is差異チェック票不使用 && is概要特記不使用);
        div.getChkTokkiKomokuAri().setDisplayNone(is特記事項項目有不使用);
        div.getChkTokkiKomokuNashi().setDisplayNone(is特記事項項目無不使用);
        div.getChkTokkiFree().setDisplayNone(is特記事項フリー不使用);
        div.getTokkiChecks().setDisplayNone(is特記事項項目有不使用 && is特記事項項目無不使用 && is特記事項フリー不使用);
        clear認定調査申請単位();
    }

    private void setNinteiChkShinseiTani(boolean flag) {
        div.getChkChosaIrai().setDisabled(flag);
        div.getChkNinteiChosahyoSonota().setDisabled(flag);
        div.getChkChosaDesign().setDisabled(flag);
        div.getChkTokkiDesign().setDisabled(flag);
        div.getChkChosaOcr().setDisabled(flag);
        div.getChkTokkiOcr().setDisabled(flag);
        div.getChkSaiCheck().setDisabled(flag);
        div.getChkGaikyoTokki().setDisabled(flag);
        div.getChkTokkiKomokuAri().setDisabled(flag);
        div.getChkTokkiKomokuNashi().setDisabled(flag);
        div.getChkTokkiFree().setDisabled(flag);
        div.getChkTokkijikoTenyuryoku().setDisabled(flag);
        RDate 基準日 = RDate.getNowDate();
        setChkSelected(div.getChkChosaIrai(), ConfigNameDBE.認定調査依頼_手動_認定調査依頼書, 基準日, flag);
        setChkSelected(div.getChkChosaDesign(), ConfigNameDBE.認定調査依頼_手動_認定調査票, 基準日, flag);
        setChkSelected(div.getChkTokkiDesign(), ConfigNameDBE.認定調査依頼_手動_認定調査票_特記事項, 基準日, flag);
        setChkSelected(div.getChkChosaOcr(), ConfigNameDBE.認定調査依頼_手動_認定調査票OCR, 基準日, flag);
        setChkSelected(div.getChkTokkiOcr(), ConfigNameDBE.認定調査依頼_手動_認定調査票OCR_特記事項, 基準日, flag);
        setChkSelected(div.getChkSaiCheck(), ConfigNameDBE.認定調査依頼_手動_認定調査票差異チェック票, 基準日, flag);
        setChkSelected(div.getChkGaikyoTokki(), ConfigNameDBE.認定調査依頼_手動_調査特記_概況特記, 基準日, flag);
        setChkSelected(div.getChkTokkiKomokuAri(), ConfigNameDBE.認定調査依頼_手動_認定調査票_特記事項_項目有り, 基準日, flag);
        setChkSelected(div.getChkTokkiKomokuNashi(), ConfigNameDBE.認定調査依頼_手動_認定調査票_特記事項_項目無し, 基準日, flag);
        setChkSelected(div.getChkTokkiFree(), ConfigNameDBE.認定調査依頼_手動_認定調査票_特記事項_フリー様式, 基準日, flag);
        clear認定調査申請単位();
    }

    private boolean is使用ByConfig(ConfigNameDBE key, RDate 基準日) {
        return DbBusinessConfig.get(key, 基準日, SubGyomuCode.DBE認定支援).equals(OCR);
    }
    
    private void setChkSelected(CheckBoxList chk, ConfigNameDBE key, RDate 基準日, boolean is外す) {
        boolean is手動 = !is外す && is使用ByConfig(key, 基準日);
        setChkSelected(chk, is手動);
    }

    private void setChkSelected(CheckBoxList chk, boolean isSelected) {
        List<KeyValueDataSource> source = isSelected ? chk.getDataSource() : Collections.EMPTY_LIST;
        chk.setSelectedItems(source);
    }

    private void setHakkobiAndTeishutsuKigen(RString ninteiShinsei) {
        div.getTxtHakkobi().setValue(RDate.getNowDate());
        if (SHINSEI_KASAN.equals(ninteiShinsei)) {
            div.getRadTeishutsuKigen().setDisabled(true);
        }
        div.getTxtKyotsuHizuke().clearValue();
        div.getTxtKyotsuHizuke().setReadOnly(true);
    }

    private void clear認定調査申請単位() {
        div.getChkShujiiIkenshoSakuseiIraisho().setSelectedItemsByKey(Collections.<RString>emptyList());
        div.getChkShujiIkenshoKinyuAndSakuseiryoSeikyu().setSelectedItemsByKey(Collections.<RString>emptyList());
        div.getChkShindanMeireishoAndTeishutsuIraisho().setSelectedItemsByKey(Collections.<RString>emptyList());
    }

    private void clear主治医意見書申請単位() {
        div.getChkShujiiIkenshoSakuseiIraisho().setSelectedItemsByKey(Collections.<RString>emptyList());
        div.getChkShujiIkenshoKinyuAndSakuseiryoSeikyu().setSelectedItemsByKey(Collections.<RString>emptyList());
        div.getChkShindanMeireishoAndTeishutsuIraisho().setSelectedItemsByKey(Collections.<RString>emptyList());
    }
}
