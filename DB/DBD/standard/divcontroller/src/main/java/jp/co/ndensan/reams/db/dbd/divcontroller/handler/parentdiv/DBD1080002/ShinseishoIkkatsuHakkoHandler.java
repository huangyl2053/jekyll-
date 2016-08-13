/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.handler.parentdiv.DBD1080002;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import jp.co.ndensan.reams.db.dbd.business.core.basic.KouhoushaJoho;
import jp.co.ndensan.reams.db.dbd.business.core.basic.ShinseishoHakkoTaishoshaHaakuBatch;
import jp.co.ndensan.reams.db.dbd.definition.mybatisprm.kouhoushajoho.KouhoushaJohoParameter;
import jp.co.ndensan.reams.db.dbd.definition.reportid.ReportIdDBD;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD1080002.ShinseishoIkkatsuHakkoDiv;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD1080002.ddlKohoshaList_Row;
import jp.co.ndensan.reams.db.dbd.service.core.kouhoushajoho.KouhoushaJohoService;
import jp.co.ndensan.reams.db.dbd.service.core.shinseishohakkotaishoshahaakubatch.ShinseishoHakkoTaishoshaHaakuBatchManager;
import jp.co.ndensan.reams.db.dbx.definition.core.gemmengengaku.GemmenGengakuShurui;
import jp.co.ndensan.reams.db.dbz.definition.core.KoroshoInterfaceShikibetsuCode;
import jp.co.ndensan.reams.db.dbz.definition.core.YokaigoJotaiKubunSupport;
import jp.co.ndensan.reams.db.dbz.definition.core.shotoku.SetaiKazeiKubun;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogType;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogger;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.ExpandedInformation;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.PersonalData;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;
import jp.co.ndensan.reams.uz.uza.workflow.parameter.FlowParameterAccessor;
import jp.co.ndensan.reams.uz.uza.workflow.parameter.FlowParameters;

/**
 * 減免減額申請書一括発行のHandlerクラスです。
 *
 * @reamsid_L DBD-3530-050 liuyl
 */
public class ShinseishoIkkatsuHakkoHandler {

    private final ShinseishoIkkatsuHakkoDiv div;
    private final ShinseishoHakkoTaishoshaHaakuBatchManager manager;
    private static final RString 負担限度額認定申請書 = new RString("負担限度額認定申請書・勧奨通知書");
    private static final RString 利用者負担額減額の帳票文言 = new RString("利用者負担額減額・免除申請書");
    private static final RString 訪問介護利用者負担額減額申請書 = new RString("訪問介護利用者負担額減額申請書");
    private static final RString 社会福祉法人等利用者負担額減額対象確認申請書 = new RString("社会福祉法人等利用者負担額減額対象確認申請書");

    /**
     * コンストラクタです。
     *
     * @param div ShinseishoIkkatsuHakkoDiv
     */
    public ShinseishoIkkatsuHakkoHandler(ShinseishoIkkatsuHakkoDiv div) {
        this.div = div;
        this.manager = ShinseishoHakkoTaishoshaHaakuBatchManager.createInstance();
    }

    /**
     * 画面初期化処理です。
     */
    public void onLoad() {
        ShinseishoHakkoTaishoshaHaakuBatch 把握情報;
        FlowParameters fp2 = FlowParameterAccessor.get();
        UUID 把握処理ID = fp2.get(new RString("key1"), UUID.class);
        if (把握処理ID == null) {
            把握情報 = manager.select最新の把握情報();
        } else {
            把握情報 = manager.select把握情報(把握処理ID);
        }
        KouhoushaJohoParameter parameter = new KouhoushaJohoParameter(把握情報.get基準日(), 把握情報.getバッチ処理日時(),
                把握情報.get減免減額種類());
        KouhoushaJohoService kouhoushaJohoSerive = KouhoushaJohoService.creatInstence();
        List<KouhoushaJoho> 候補者情報List = kouhoushaJohoSerive.find候補者情報(parameter);
        div.getGenmenShinseiHaakuList().getDdlShoriTimestamp().setDataSource(getDataSource(把握情報.get減免減額種類()));
        div.getGenmenShinseiHaakuList().getDdlShoriTimestamp().setSelectedValue(new RString(把握情報.getバッチ処理日時().toString()));
        div.getGenmenShinseiHaakuList().getTxtKijunYMD().setValue(把握情報.get基準日());
        div.getGenmenShinseiHaakuList().getTxtShotokuNendo().setDomain(把握情報.get所得年度().getNendo());
        set減免減額種類();
        div.getGenmenShinseiHaakuList().getDdlGemmenGengakuShurui().setSelectedValue(GemmenGengakuShurui.
                toValue(把握情報.get減免減額種類()).get名称());
        div.getGenmenShinseiHaakuList().getDdlKohoshaList().setDataSource(get候補者情報(候補者情報List));
        set帳票文言();
        set帳票出力順(div.getGenmenShinseiHaakuList().getDdlGemmenGengakuShurui().getSelectedValue());
        for (KouhoushaJoho kouhoushaJoho : 候補者情報List) {
            ExpandedInformation expandedInfo = new ExpandedInformation(new Code(new RString("0003")), new RString("'被保険者番号"),
                    kouhoushaJoho.get被保険者番号().value());
            AccessLogger.log(AccessLogType.照会, PersonalData.withHojinNo(kouhoushaJoho.get識別コード(), expandedInfo));
        }
    }

    /**
     * 基準日時を取得する。
     *
     * @param 減免減額種類 RString
     * @return List<KeyValueDataSource>
     */
    public List<KeyValueDataSource> getDataSource(RString 減免減額種類) {
        List<YMDHMS> バッチ処理日時リスト = new ArrayList<>();
        List<KeyValueDataSource> result = new ArrayList<>();
        List<ShinseishoHakkoTaishoshaHaakuBatch> 基準日時リスト = manager.select基準日時(減免減額種類);
        for (int i = 0; i < 基準日時リスト.size(); i++) {
            バッチ処理日時リスト.add(基準日時リスト.get(i).getバッチ処理日時());
        }
        for (int i = 0; i < バッチ処理日時リスト.size(); i++) {
            KeyValueDataSource keyValues = new KeyValueDataSource(new RString("key" + i), new RString(バッチ処理日時リスト.get(i).toString()));
            result.add(keyValues);
        }
        return result;
    }

    /**
     * 把握情報を取得する。
     *
     * @return ShinseishoHakkoTaishoshaHaakuBatch
     */
    public ShinseishoHakkoTaishoshaHaakuBatch get把握情報() {
        YMDHMS バッチ処理日時 = new YMDHMS(div.getGenmenShinseiHaakuList().getDdlShoriTimestamp().getSelectedValue());
        return manager.select把握処理ID(バッチ処理日時);
    }

    private void set減免減額種類() {
        KeyValueDataSource keyValue1 = new KeyValueDataSource(GemmenGengakuShurui.負担限度額認定.getコード(),
                GemmenGengakuShurui.負担限度額認定.get名称());
        KeyValueDataSource keyValue2 = new KeyValueDataSource(GemmenGengakuShurui.利用者負担額減額.getコード(),
                GemmenGengakuShurui.利用者負担額減額.get名称());
        KeyValueDataSource keyValue3 = new KeyValueDataSource(GemmenGengakuShurui.訪問介護利用者負担額減額.getコード(),
                GemmenGengakuShurui.訪問介護利用者負担額減額.get名称());
        KeyValueDataSource keyValue4 = new KeyValueDataSource(GemmenGengakuShurui.社会福祉法人等利用者負担軽減.getコード(),
                GemmenGengakuShurui.社会福祉法人等利用者負担軽減.get名称());
        List<KeyValueDataSource> keyValues = new ArrayList<>();
        keyValues.add(keyValue1);
        keyValues.add(keyValue2);
        keyValues.add(keyValue3);
        keyValues.add(keyValue4);
        div.getGenmenShinseiHaakuList().getDdlGemmenGengakuShurui().setDataSource(keyValues);
    }

    /**
     * データグリッドエリアを取得する。
     *
     * @param 候補者情報List (List<KouhoushaJoho>
     * @return List<ddlKohoshaList_Row>
     */
    public List<ddlKohoshaList_Row> get候補者情報(List<KouhoushaJoho> 候補者情報List) {
        List<ddlKohoshaList_Row> dataSources = new ArrayList<>();
        for (KouhoushaJoho kouhoushaJoho : 候補者情報List) {
            ddlKohoshaList_Row ddlKohoshaList = new ddlKohoshaList_Row();
            if (kouhoushaJoho.get更新認定フラグ()) {
                ddlKohoshaList.setShinkiKoshin(new RString("更新"));
            } else {
                ddlKohoshaList.setShinkiKoshin(new RString("新規"));
            }
            ddlKohoshaList.setHihoNo(kouhoushaJoho.get被保険者番号().value());
            ddlKohoshaList.setShikibetsuCode(kouhoushaJoho.get識別コード().value());
            ddlKohoshaList.setShimei(kouhoushaJoho.get宛名識別対象().get名称().value());
            ddlKohoshaList.setKana(kouhoushaJoho.get宛名識別対象().getカナ氏名().value());
            ddlKohoshaList.setNenrei(kouhoushaJoho.get宛名識別対象().get年齢());
            ddlKohoshaList.setJigyoshaNo(kouhoushaJoho.get事業者番号().value());
            if (kouhoushaJoho.get世帯課税().equals(SetaiKazeiKubun.課税.getコード())) {
                ddlKohoshaList.setChkSetaiKazei(true);
            } else {
                ddlKohoshaList.setChkSetaiKazei(false);
            }
            ddlKohoshaList.setJusho(kouhoushaJoho.get宛名識別対象().get住所());
            ddlKohoshaList.setShichosonCode(kouhoushaJoho.get市町村コード().value());
            ddlKohoshaList.setChkRofuku(kouhoushaJoho.get老福());
            ddlKohoshaList.setChkSeiho(kouhoushaJoho.get生保());
            ddlKohoshaList.setChkKyusochi(kouhoushaJoho.get旧措置());
            ddlKohoshaList.setYokaigodo(YokaigoJotaiKubunSupport.toValue(KoroshoInterfaceShikibetsuCode.
                    toValue(kouhoushaJoho.get厚労省IF識別コード().value()), kouhoushaJoho.get要介護認定状態区分コード().value()).getName());
            ddlKohoshaList.getTxtNinteiKaishiYMD().setValue(kouhoushaJoho.get認定開始日());
            ddlKohoshaList.getTxtNinteiShuryoYMD().setValue(kouhoushaJoho.get認定終了日());
            ddlKohoshaList.setRiyoshaFutanDankai(kouhoushaJoho.get利用者負担段階());
            ddlKohoshaList.getGokeiShotokuKingaku().setValue(kouhoushaJoho.get合計所得金額());
            ddlKohoshaList.getNenkinShunyuGaku().setValue(kouhoushaJoho.get年金収入額());
            ddlKohoshaList.getHikazeinenkinKananGaku().setValue(kouhoushaJoho.get非課税年金勘案額());
            ddlKohoshaList.setHaakuShoriID(new RString(kouhoushaJoho.get把握処理ID().toString()));
            dataSources.add(ddlKohoshaList);
        }
        return dataSources;
    }

    /**
     * 設定帳票出力順。
     *
     * @param 減免減額種類 RString
     */
    public void set帳票出力順(RString 減免減額種類) {
        if (減免減額種類.equals(GemmenGengakuShurui.負担限度額認定.get名称())) {
            div.getGenmenShinseiHaakuList().getGenmenShinseiHaakuShinseisho().getCcdChohyoShutsuryokujun().
                    load(SubGyomuCode.DBD介護受給, ReportIdDBD.DBD800001.getReportId());
        }
        if (減免減額種類.equals(GemmenGengakuShurui.利用者負担額減額.get名称())) {
            div.getGenmenShinseiHaakuList().getGenmenShinseiHaakuShinseisho().getCcdChohyoShutsuryokujun().
                    load(SubGyomuCode.DBD介護受給, ReportIdDBD.DBD800002.getReportId());
        }
        if (減免減額種類.equals(GemmenGengakuShurui.訪問介護利用者負担額減額.get名称())) {
            div.getGenmenShinseiHaakuList().getGenmenShinseiHaakuShinseisho().getCcdChohyoShutsuryokujun().
                    load(SubGyomuCode.DBD介護受給, ReportIdDBD.DBD800005.getReportId());
        }
        if (減免減額種類.equals(GemmenGengakuShurui.社会福祉法人等利用者負担軽減.get名称())) {
            div.getGenmenShinseiHaakuList().getGenmenShinseiHaakuShinseisho().getCcdChohyoShutsuryokujun().
                    load(SubGyomuCode.DBD介護受給, ReportIdDBD.DBD800006.getReportId());
        }
    }

    /**
     * 設定帳票文言。
     */
    public void set帳票文言() {
        if (div.getGenmenShinseiHaakuList().getDdlGemmenGengakuShurui().getSelectedValue().
                equals(GemmenGengakuShurui.負担限度額認定.get名称())) {
            div.getGenmenShinseiHaakuList().getGenmenShinseiHaakuShinseisho().
                    setTitle(負担限度額認定申請書);
        }
        if (div.getGenmenShinseiHaakuList().getDdlGemmenGengakuShurui().getSelectedValue().
                equals(GemmenGengakuShurui.利用者負担額減額.get名称())) {
            div.getGenmenShinseiHaakuList().getGenmenShinseiHaakuShinseisho()
                    .setTitle(利用者負担額減額の帳票文言);
        }
        if (div.getGenmenShinseiHaakuList().getDdlGemmenGengakuShurui().getSelectedValue().
                equals(GemmenGengakuShurui.訪問介護利用者負担額減額.get名称())) {
            div.getGenmenShinseiHaakuList().getGenmenShinseiHaakuShinseisho().setTitle(訪問介護利用者負担額減額申請書);
        }
        if (div.getGenmenShinseiHaakuList().getDdlGemmenGengakuShurui().getSelectedValue().
                equals(GemmenGengakuShurui.社会福祉法人等利用者負担軽減.get名称())) {
            div.getGenmenShinseiHaakuList().getGenmenShinseiHaakuShinseisho().
                    setTitle(社会福祉法人等利用者負担額減額対象確認申請書);
        }
    }
}
