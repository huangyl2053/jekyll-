package jp.co.ndensan.reams.db.dbe.divcontroller.controller.parentdiv.DBE7010001;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.gogitaijoho.gogitaijoho.GogitaiJoho;
import jp.co.ndensan.reams.db.dbe.definition.batchprm.DBE701001.DBE701001_HokokuShiryoParameter;
import jp.co.ndensan.reams.db.dbe.definition.core.yokaigonintei.shinsei.HihokenshaKubun;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE7010001.HokokuShiryoSakuSeiParameterDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE7010001.HokokuShiryoSakuSeiParameterHandler;
import jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE7010001.HokokuShiryoSakuSeiParameterValidationHandler;
import jp.co.ndensan.reams.db.dbe.service.core.basic.hokokushiryosakusei.HokokuShiryoSakuSeiFinder;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 画面の条件を指定して、報告資料作成バッチ処理を起動し、各種統計資料を作成するクラスです。
 *
 * @reamsid_L DBE-1450-010 wangxiaodong
 */
public class HokokuShiryoSakuSeiParameter {

    private static final RString SELECTKEY_KEY0 = new RString("key0");
    private static final RString SELECTKEY_KEY1 = new RString("key1");
    private static final RString SELECTKEY_KEY2 = new RString("key2");
    private static final RString 全て合議体 = new RString("全て");
    private static final RString KEY_事業状況報告 = new RString("0");
    private static final RString KEY_実施状況報告 = new RString("1");
    private static final RString KEY_審査判定状況 = new RString("2");
    private static final RString KEY_審査判定の変更状況 = new RString("3");
    private static final RString KEY_介護認定審査会集計表_判定別 = new RString("4");
    private static final RString KEY_介護認定審査会集計表_申請区分別 = new RString("5");
    private static final RString KEY_介護認定審査会集計表_現在の状況別 = new RString("6");
    private static final RString KEY_CSV出力 = new RString("0");
    private final HokokuShiryoSakuSeiFinder finder;

    /**
     * コンストラクタです。
     */
    public HokokuShiryoSakuSeiParameter() {
        this.finder = HokokuShiryoSakuSeiFinder.createInstance();
    }

    /**
     * 画面初期化処理です。
     *
     * @param div 報告資料発行画面
     * @return ResponseData<HokokuShiryoSakuSeiParameterDiv>
     */
    public ResponseData<HokokuShiryoSakuSeiParameterDiv> onload(HokokuShiryoSakuSeiParameterDiv div) {
        set合議体番号DLL(div, finder.getGogitaiNo().records());
        getHandler(div).inint_Clear();
        return ResponseData.of(div).respond();
    }
    
    public ResponseData<HokokuShiryoSakuSeiParameterDiv> onChange_radShutsuryokuChohyo(HokokuShiryoSakuSeiParameterDiv div) {
        getHandler(div).セット抽出条件();
        return ResponseData.of(div).respond();
    }
    
    public ResponseData<HokokuShiryoSakuSeiParameterDiv> onChange_radCsvShutsuryoku(HokokuShiryoSakuSeiParameterDiv div) {
        getHandler(div).セット抽出条件_CSV();
        return ResponseData.of(div).respond();
    }

    /**
     * 「資料の出力を実行する」ボタンをチェックする処理です。
     *
     * @param div 報告資料発行画面
     * @return ResponseData<HokokuShiryoSakuSeiParameterDiv>
     */
    public ResponseData<HokokuShiryoSakuSeiParameterDiv> onClick_btnCheck(HokokuShiryoSakuSeiParameterDiv div) {
        ValidationMessageControlPairs message
                = new HokokuShiryoSakuSeiParameterValidationHandler(div).check_btnBatchRegisterHokokuShiryo();
        if (message.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(message).respond();
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 「資料の出力を実行する」ボタンを実行する処理です。
     *
     * @param div 報告資料発行画面
     * @return ResponseData<HokokuShiryoSakuSeiParameterDiv>
     */
    public ResponseData<DBE701001_HokokuShiryoParameter> onClick_btnBatchRegisterHokokuShiryo(HokokuShiryoSakuSeiParameterDiv div) {
        return ResponseData.of(getBatchParameter(div)).respond();
    }

    private void set合議体番号DLL(HokokuShiryoSakuSeiParameterDiv div, List<GogitaiJoho> 合議体番号リスト) {
        List<KeyValueDataSource> 合議体番号DLL = new ArrayList<>();
        合議体番号DLL.add(new KeyValueDataSource(RString.EMPTY, 全て合議体));
        for (GogitaiJoho 合議体番号 : 合議体番号リスト) {
            合議体番号DLL.add(new KeyValueDataSource(
                    new RString(String.valueOf(合議体番号.get合議体番号())), 合議体番号.get合議体名称()));
        }
        div.getDdlGogitaiBango().setDataSource(合議体番号DLL);
        div.getDdlGogitaiBango().setSelectedIndex(0);
    }

    private DBE701001_HokokuShiryoParameter getBatchParameter(HokokuShiryoSakuSeiParameterDiv div) {
        boolean flag_対象年月 = false;
        boolean flag_対象年月日 = false;
        boolean flag_事業状況報告 = false;
        boolean flag_実施状況報告 = false;
        boolean flag_審査判定状況 = false;
        boolean flag_審査判定の変更状況 = false;
        boolean flag_審査会集計表判定別 = false;
        boolean flag_審査会集計表申請区分別 = false;
        boolean flag_審査会集計表現在の状況別 = false;
        boolean flag_CSV出力 = false;
        if (KEY_事業状況報告.equals(div.getRadhutsuryokuChohyo().getSelectedKey())) {
            flag_対象年月 = true;
            flag_対象年月日 = false;
        } else if (KEY_実施状況報告.equals(div.getRadhutsuryokuChohyo().getSelectedKey()) 
                || KEY_審査判定状況.equals(div.getRadhutsuryokuChohyo().getSelectedKey()) 
                || KEY_審査判定の変更状況.equals(div.getRadhutsuryokuChohyo().getSelectedKey()) 
                || KEY_介護認定審査会集計表_判定別.equals(div.getRadhutsuryokuChohyo().getSelectedKey()) 
                || KEY_介護認定審査会集計表_申請区分別.equals(div.getRadhutsuryokuChohyo().getSelectedKey()) 
                || KEY_CSV出力.equals(div.getRadCsvShutsuryoku().getSelectedKey())) {
            flag_対象年月 = false;
            flag_対象年月日 = true;
        } else if (KEY_介護認定審査会集計表_現在の状況別.equals(div.getRadhutsuryokuChohyo().getSelectedKey())) {
            flag_対象年月 = false;
            flag_対象年月日 = false;
        }
        if (KEY_事業状況報告.equals(div.getRadhutsuryokuChohyo().getSelectedKey())) {
            flag_事業状況報告 = true;
        } else if (KEY_実施状況報告.equals(div.getRadhutsuryokuChohyo().getSelectedKey())) {
            flag_実施状況報告 = true;
        } else if (KEY_審査判定状況.equals(div.getRadhutsuryokuChohyo().getSelectedKey())) {
            flag_審査判定状況 = true;
        } else if (KEY_審査判定の変更状況.equals(div.getRadhutsuryokuChohyo().getSelectedKey())) {
            flag_審査判定の変更状況 = true;
        } else if (KEY_介護認定審査会集計表_判定別.equals(div.getRadhutsuryokuChohyo().getSelectedKey())) {
            flag_審査会集計表判定別 = true;
        } else if (KEY_介護認定審査会集計表_申請区分別.equals(div.getRadhutsuryokuChohyo().getSelectedKey())) {
            flag_審査会集計表申請区分別 = true;
        } else if (KEY_介護認定審査会集計表_現在の状況別.equals(div.getRadhutsuryokuChohyo().getSelectedKey())) {
            flag_審査会集計表現在の状況別 = true;
        } else if (KEY_CSV出力.equals(div.getRadCsvShutsuryoku().getSelectedKey())) {
            flag_CSV出力 = true;
        }
        return new DBE701001_HokokuShiryoParameter(
                flag_事業状況報告,
                flag_実施状況報告,
                flag_審査判定状況,
                flag_審査判定の変更状況,
                flag_審査会集計表判定別,
                flag_審査会集計表申請区分別,
                flag_審査会集計表現在の状況別,
                flag_CSV出力,
                div.getTxtShuturyokuSaki().getValue(),
                div.getCcdHokenshaList().getSelectedItem().get証記載保険者番号().value(),
                div.getCcdHokenshaList().getSelectedItem().get市町村コード(),
                div.getCcdHokenshaList().getSelectedItem().get市町村名称(),
                getHiHokensyaKubun(div).getコード(),
                div.getDdlGogitaiBango().getSelectedKey().isEmpty() ? -1 : Integer.parseInt(div.getDdlGogitaiBango().getSelectedKey().toString()),
                div.getDdlGogitaiBango().getSelectedValue(),
                getGogitaiBango(div),
                flag_対象年月,
                div.getTxtNengetsu().getDomain().toDateString(),
                div.getTxtKijyunYMD().getValue(),
                flag_対象年月日,
                div.getTxtTaishoGappi().getFromValue() == null ? RString.EMPTY : div.getTxtTaishoGappi().getFromValue().toDateString(),
                div.getTxtTaishoGappi().getToValue() == null ? RString.EMPTY : div.getTxtTaishoGappi().getToValue().toDateString(),
                div.getChkShukeiTani().getSelectedKeys().contains(SELECTKEY_KEY0),
                div.getChkShukeiTani().getSelectedKeys().contains(SELECTKEY_KEY1)
        );
    }

    private HihokenshaKubun getHiHokensyaKubun(HokokuShiryoSakuSeiParameterDiv div) {
        if (div.getChkHihokenshaKubun().isAllSelected()) {
            return HihokenshaKubun.すべて選択;
        }
        if (div.getChkHihokenshaKubun().getSelectedKeys().contains(SELECTKEY_KEY0)
                && div.getChkHihokenshaKubun().getSelectedKeys().contains(SELECTKEY_KEY1)) {
            return HihokenshaKubun.第１号と第２号;
        }
        if (div.getChkHihokenshaKubun().getSelectedKeys().contains(SELECTKEY_KEY0)
                && div.getChkHihokenshaKubun().getSelectedKeys().contains(SELECTKEY_KEY2)) {
            return HihokenshaKubun.第１号とその他;
        }
        if (div.getChkHihokenshaKubun().getSelectedKeys().contains(SELECTKEY_KEY1)
                && div.getChkHihokenshaKubun().getSelectedKeys().contains(SELECTKEY_KEY2)) {
            return HihokenshaKubun.第２号とその他;
        }
        if (div.getChkHihokenshaKubun().getSelectedKeys().contains(SELECTKEY_KEY0)) {
            return HihokenshaKubun.第１号被保険者;
        }
        if (div.getChkHihokenshaKubun().getSelectedKeys().contains(SELECTKEY_KEY1)) {
            return HihokenshaKubun.第２号被保険者;
        }
        if (div.getChkHihokenshaKubun().getSelectedKeys().contains(SELECTKEY_KEY2)) {
            return HihokenshaKubun.その他;
        }
        return HihokenshaKubun.選択なし;
    }

    private List<Integer> getGogitaiBango(HokokuShiryoSakuSeiParameterDiv div) {
        List<Integer> gogitaiBango = new ArrayList<>();
        for (int i = 1; i < div.getDdlGogitaiBango().getDataSource().size(); i++) {
            gogitaiBango.add(Integer.parseInt(div.getDdlGogitaiBango().getDataSource().get(i).getKey().toString()));
        }
        return gogitaiBango;
    }

    private HokokuShiryoSakuSeiParameterHandler getHandler(HokokuShiryoSakuSeiParameterDiv div) {
        return new HokokuShiryoSakuSeiParameterHandler(div);
    }
}
