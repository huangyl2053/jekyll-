package jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE7010001;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE7010001.HokokuShiryoSakuSeiParameterDiv;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBE;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.GyomuBunrui;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 報告資料発行画面のハンドラークラスです。
 *
 * @reamsid_L DBE-1450-010 wangxiaodong
 */
public class HokokuShiryoSakuSeiParameterHandler {

    private static final List<RString> CHECKなし = new ArrayList<>();
    private static final RString KEY_事業状況報告 = new RString("0");
    private static final RString KEY_実施状況報告 = new RString("1");
    private static final RString KEY_審査判定状況 = new RString("2");
    private static final RString KEY_審査判定の変更状況 = new RString("3");
    private static final RString KEY_介護認定審査会集計表_判定別 = new RString("4");
    private static final RString KEY_介護認定審査会集計表_申請区分別 = new RString("5");
    private static final RString KEY_介護認定審査会集計表_現在の状況別 = new RString("6");
    private static final RString KEY_CSV出力 = new RString("0");

    private final HokokuShiryoSakuSeiParameterDiv div;

    /**
     * コンストラクタです。
     *
     * @param div 画面情報
     */
    public HokokuShiryoSakuSeiParameterHandler(HokokuShiryoSakuSeiParameterDiv div) {
        this.div = div;
    }

    /**
     * 画面初期化処理です。
     */
    public void inint_Clear() {
        div.getCcdHokenshaList().loadHokenshaList(GyomuBunrui.介護認定);
        div.getChkHihokenshaKubun().setSelectedItemsByKey(CHECKなし);
        div.getTxtNengetsu().setDomain(FlexibleDate.getNowDate().getYearMonth());
        div.getTxtKijyunYMD().setValue(RDate.getNowDate());
        div.getTxtTaishoGappi().clearFromValue();
        div.getTxtTaishoGappi().clearToValue();
        div.getChkShukeiTani().setSelectedItemsByKey(CHECKなし);
        セット抽出条件();
    }

    public void セット抽出条件() {
        div.getTxtShuturyokuSaki().clearValue();
        if (KEY_事業状況報告.equals(div.getRadhutsuryokuChohyo().getSelectedKey())) {
            div.getTxtNengetsu().setDisabled(false);
            div.getTxtNengetsu().setDomain(FlexibleDate.getNowDate().getYearMonth());
            div.getTxtTaishoGappi().setDisabled(true);
            div.getTxtTaishoGappi().clearFromValue();
            div.getTxtTaishoGappi().clearToValue();
            div.getChkHihokenshaKubun().setDisabled(true);
            div.getChkHihokenshaKubun().setSelectedItemsByKey(CHECKなし);
            div.getDdlGogitaiBango().setDisabled(true);
            div.getDdlGogitaiBango().setSelectedIndex(0);
            div.getChkShukeiTani().setDisabled(true);
            div.getChkShukeiTani().setSelectedItemsByKey(CHECKなし);
            div.getChkShukeiTani().setRequired(false);
            div.getRadCsvShutsuryoku().clearSelectedItem();
            div.getTxtShuturyokuSaki().setDisabled(true);
        } else if (KEY_実施状況報告.equals(div.getRadhutsuryokuChohyo().getSelectedKey())) {
            div.getTxtNengetsu().setDisabled(true);
            div.getTxtNengetsu().clearDomain();
            div.getTxtTaishoGappi().setDisabled(false);
            div.getChkHihokenshaKubun().setDisabled(false);
            div.getDdlGogitaiBango().setDisabled(true);
            div.getDdlGogitaiBango().setSelectedIndex(0);
            div.getChkShukeiTani().setDisabled(false);
            div.getChkShukeiTani().setRequired(true);
            div.getRadCsvShutsuryoku().clearSelectedItem();
            div.getTxtShuturyokuSaki().setDisabled(true);
        } else if (KEY_審査判定状況.equals(div.getRadhutsuryokuChohyo().getSelectedKey())) {
            div.getTxtNengetsu().setDisabled(true);
            div.getTxtNengetsu().clearDomain();
            div.getTxtTaishoGappi().setDisabled(false);
            div.getChkHihokenshaKubun().setDisabled(false);
            div.getDdlGogitaiBango().setDisabled(false);
            div.getChkShukeiTani().setDisabled(true);
            div.getChkShukeiTani().setSelectedItemsByKey(CHECKなし);
            div.getChkShukeiTani().setRequired(false);
            div.getRadCsvShutsuryoku().clearSelectedItem();
            div.getTxtShuturyokuSaki().setDisabled(true);
        } else if (KEY_審査判定の変更状況.equals(div.getRadhutsuryokuChohyo().getSelectedKey())) {
            div.getTxtNengetsu().setDisabled(true);
            div.getTxtNengetsu().clearDomain();
            div.getTxtTaishoGappi().setDisabled(false);
            div.getChkHihokenshaKubun().setDisabled(false);
            div.getDdlGogitaiBango().setDisabled(false);
            div.getChkShukeiTani().setDisabled(false);
            div.getChkShukeiTani().setRequired(true);
            div.getRadCsvShutsuryoku().clearSelectedItem();
            div.getTxtShuturyokuSaki().setDisabled(true);
        } else if (KEY_介護認定審査会集計表_判定別.equals(div.getRadhutsuryokuChohyo().getSelectedKey())) {
            div.getTxtNengetsu().setDisabled(true);
            div.getTxtNengetsu().clearDomain();
            div.getTxtTaishoGappi().setDisabled(false);
            div.getChkHihokenshaKubun().setDisabled(false);
            div.getDdlGogitaiBango().setDisabled(true);
            div.getDdlGogitaiBango().setSelectedIndex(0);
            div.getChkShukeiTani().setDisabled(true);
            div.getChkShukeiTani().setSelectedItemsByKey(CHECKなし);
            div.getChkShukeiTani().setRequired(false);
            div.getRadCsvShutsuryoku().clearSelectedItem();
            div.getTxtShuturyokuSaki().setDisabled(true);
        } else if (KEY_介護認定審査会集計表_申請区分別.equals(div.getRadhutsuryokuChohyo().getSelectedKey())) {
            div.getTxtNengetsu().setDisabled(true);
            div.getTxtNengetsu().clearDomain();
            div.getTxtTaishoGappi().setDisabled(false);
            div.getChkHihokenshaKubun().setDisabled(false);
            div.getDdlGogitaiBango().setDisabled(true);
            div.getDdlGogitaiBango().setSelectedIndex(0);
            div.getChkShukeiTani().setDisabled(false);
            div.getChkShukeiTani().setRequired(true);
            div.getRadCsvShutsuryoku().clearSelectedItem();
            div.getTxtShuturyokuSaki().setDisabled(true);
        } else if (KEY_介護認定審査会集計表_現在の状況別.equals(div.getRadhutsuryokuChohyo().getSelectedKey())) {
            div.getTxtNengetsu().setDisabled(true);
            div.getTxtNengetsu().clearDomain();
            div.getTxtTaishoGappi().setDisabled(true);
            div.getTxtTaishoGappi().clearFromValue();
            div.getTxtTaishoGappi().clearToValue();
            div.getChkHihokenshaKubun().setDisabled(true);
            div.getChkHihokenshaKubun().setSelectedItemsByKey(CHECKなし);
            div.getDdlGogitaiBango().setDisabled(true);
            div.getDdlGogitaiBango().setSelectedIndex(0);
            div.getChkShukeiTani().setDisabled(false);
            div.getChkShukeiTani().setRequired(true);
            div.getRadCsvShutsuryoku().clearSelectedItem();
            div.getTxtShuturyokuSaki().setDisabled(true);
        }
    }
    
    public void セット抽出条件_CSV() {
        if (KEY_CSV出力.equals(div.getRadCsvShutsuryoku().getSelectedKey())) {
            div.getTxtNengetsu().setDisabled(true);
            div.getTxtNengetsu().clearDomain();
            div.getTxtTaishoGappi().setDisabled(false);
            div.getChkHihokenshaKubun().setDisabled(false);
            div.getDdlGogitaiBango().setDisabled(false);
            div.getChkShukeiTani().setDisabled(true);
            div.getChkShukeiTani().setSelectedItemsByKey(CHECKなし);
            div.getChkShukeiTani().setRequired(false);
            div.getRadhutsuryokuChohyo().clearSelectedItem();
            div.getTxtShuturyokuSaki().setDisabled(false);
            div.getTxtShuturyokuSaki().setValue(
                    DbBusinessConfig.get(ConfigNameDBE.県報告資料ファイル名称, RDate.getNowDate(), SubGyomuCode.DBE認定支援));
        }
    }
}
