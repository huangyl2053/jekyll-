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
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.GyomuBunrui;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

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
        setNinteiChkShinseiTani(true);
        div.getChkNinteiChosaIraiChohyo().setSelectedItemsByKey(Collections.<RString>emptyList());
        div.getChkchosairaihakko().setSelectedItemsByKey(Collections.<RString>emptyList());
        setHakkobiAndTeishutsuKigen(ninteiShinsei);
        div.setState(STATE_NINTEIO);
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
        if (SHUTSU_CHECKED.equals(div.getRadTeishutsuKigen().getSelectedKey())) {
            div.getTxtKyotsuHizuke().setReadOnly(false);
        } else {
            div.getTxtKyotsuHizuke().setReadOnly(true);
        }
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
                shujiiIkenshoDisabledKeys.add(COMMON_SELECTED);
                div.getChkShujiIkenshoKinyuAndSakuseiryoSeikyu().setDisabledItemsByKey(shujiiIkenshoDisabledKeys);
            } else {
                ocrDisabledKeys.add(CHOHYO_CHECKED);
                div.getChkShujiIkenshoKinyuAndSakuseiryoSeikyu().setDisabledItemsByKey(ocrDisabledKeys);
            }
        }
    }

    private void setNinteiChkShinseiTani(boolean flag) {
        div.getChkNinteiChosahyoShurui().setDisabled(flag);
        div.getChkNinteiChosahyoOcrShurui().setDisabled(flag);
        div.getChkNinteiChosaIraisho().setDisabled(flag);
        div.getChkNinteiChosahyoSonota().setDisabled(flag);
        RDate 基準日 = RDate.getNowDate();
        if (!flag) {
            List<RString> ninteiChosahyoDisabledKeys = new ArrayList<>();
            List<RString> ocrDisabledKeys = new ArrayList<>();
            if (OCR.equals(DbBusinessConfig.get(ConfigNameDBE.認定調査票_基本調査_用紙タイプ, 基準日, SubGyomuCode.DBE認定支援))) {
                ninteiChosahyoDisabledKeys.add(COMMON_SELECTED);
            } else {
                ocrDisabledKeys.add(COMMON_SELECTED);
            }
            if (OCR.equals(DbBusinessConfig.get(ConfigNameDBE.認定調査票_特記事項_用紙タイプ, 基準日, SubGyomuCode.DBE認定支援))) {
                ninteiChosahyoDisabledKeys.add(CHOHYO_CHECKED);
            } else {
                ocrDisabledKeys.add(CHOHYO_CHECKED);
            }
            if (OCR.equals(DbBusinessConfig.get(ConfigNameDBE.認定調査票_概況調査_用紙タイプ, 基準日, SubGyomuCode.DBE認定支援))) {
                ninteiChosahyoDisabledKeys.add(SHUTSU_CHECKED);
            } else {
                ocrDisabledKeys.add(SHUTSU_CHECKED);
            }
            div.getChkNinteiChosahyoShurui().setDisabledItemsByKey(ninteiChosahyoDisabledKeys);
            div.getChkNinteiChosahyoOcrShurui().setDisabledItemsByKey(ocrDisabledKeys);
        }
    }

    private void setHakkobiAndTeishutsuKigen(RString ninteiShinsei) {
        div.getTxtHakkobi().setValue(RDate.getNowDate());
        if (SHINSEI_KASAN.equals(ninteiShinsei)) {
            div.getRadTeishutsuKigen().setDisabled(true);
        }
        div.getTxtKyotsuHizuke().setValue(RDate.getNowDate());
    }
}
