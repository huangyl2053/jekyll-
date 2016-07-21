/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.divcontroller.controller.parentdiv.DBB1150001;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbb.business.core.nushijuminjoho.NushiJuminJohoResult;
import jp.co.ndensan.reams.db.dbb.business.core.shotokushokaihyo.ShotokushokaihyoTaishoSetaiin;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB1150001.DBB1150001StateName;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB1150001.NushiJuminJohoDiv;
import jp.co.ndensan.reams.db.dbb.divcontroller.handler.parentdiv.DBB1150001.NushiJuminJohoHandler;
import jp.co.ndensan.reams.db.dbb.divcontroller.handler.parentdiv.DBB1150001.NushiJuminJohoHandlerValidationHandler;
import jp.co.ndensan.reams.db.dbb.service.core.tokuchokarisanteitsuchishohakko.TokuchoKaishiTsuchishoDataHenshu;
import jp.co.ndensan.reams.db.dbb.service.report.shotokushokaihyo.ShotokuShokaihyoPrintSercive;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBB;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.TsuchishoNo;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ChohyoSeigyoHanyo;
import jp.co.ndensan.reams.db.dbz.business.core.searchkey.KaigoFukaKihonSearchKey;
import jp.co.ndensan.reams.db.dbz.definition.message.DbzWarningMessages;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT2008ShotokuKanriEntity;
import jp.co.ndensan.reams.db.dbz.service.FukaTaishoshaKey;
import jp.co.ndensan.reams.ur.urz.definition.core.memo.MemoShikibetsuTaisho;
import jp.co.ndensan.reams.ur.urz.divcontroller.controller.commonchilddiv.memo.MemoNyuryoku.MemoNyuryokuHandler;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogType;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogger;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.ExpandedInformation;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.PersonalData;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.report.SourceDataCollection;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * 所得照会票作成のクラスです。
 *
 * @reamsid_L DBB-1710-010 xuhao
 */
public class NushiJuminJoho {

    private static final FlexibleYear 平成11年度 = new FlexibleYear("1999");
    private static final int 整数_0 = 0;
    private static final int 整数_1 = 1;
    private static final RString 文字列_001 = new RString("001");
    private static final RString メモボタン = new RString("btnMemo");
    private static final RString 文字列_識別対象コード = new RString("txtMemoShikibetsuTaishoCode");
    private static final RString 文字列_0003 = new RString("0003");
    private static final RString 文字列_被保険者番号 = new RString("被保険者番号");
    private static final ReportId 帳票分類ID = new ReportId("DBB100001_ShotokuShokaihyoDaihyo");
    private static final FlexibleYear 管理年度 = new FlexibleYear("0000");
    private static final RString 項目名 = new RString("通知書タイプ");
    private static final RString 項目名_文書タイトル = new RString("文書タイトル");
    private static final RString 項目名_送付先担当課名称 = new RString("送付先担当課名称");
    private static final RString 文字列_TWO = new RString("2");
    private static final RString 文字列_ONE = new RString("1");
    private static final RString 引数 = new RString("選択された住民の住所情報と異なります。所得照会票を発行しても");
    private static final RString 区切 = new RString("、");

    /**
     * 画面初期化のonLoadメソッドです。
     *
     * @param div div
     * @return div
     */
    public ResponseData onLoad(NushiJuminJohoDiv div) {
        FukaTaishoshaKey viewStateData = ViewStateHolder.get(ViewStateKeys.賦課対象者, FukaTaishoshaKey.class);
        TsuchishoNo 通知書番号 = viewStateData.get通知書番号();
        FlexibleYear 賦課年度 = viewStateData.get賦課年度();
        LasdecCode 市町村コード = viewStateData.get市町村コード();
        ShikibetsuCode 識別コード = viewStateData.get識別コード();
        KaigoFukaKihonSearchKey searchKey = new KaigoFukaKihonSearchKey.Builder(通知書番号, 賦課年度, 市町村コード, 識別コード).build();
        HihokenshaNo 被保険者番号 = viewStateData.get被保険者番号();
        div.getCcdKaigoAtenaInfo().initialize(識別コード);
        div.getCcdKaigoFukaKihon().load(searchKey);
        FlexibleYear 日付関連_調定年度 = new FlexibleYear(DbBusinessConfig.get(ConfigNameDBB.日付関連_調定年度,
                RDate.getNowDate(), SubGyomuCode.DBB介護賦課));
        List<KeyValueDataSource> 調定年度List = new ArrayList<>();
        for (FlexibleYear 調定年度 = 日付関連_調定年度; 平成11年度.isBeforeOrEquals(調定年度)
                && 調定年度.isBeforeOrEquals(日付関連_調定年度);) {
            KeyValueDataSource source = new KeyValueDataSource(調定年度.toDateString(), 調定年度.wareki()
                    .eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).fillType(FillType.BLANK).toDateString());
            調定年度 = 調定年度.minusYear(整数_1);
            調定年度List.add(source);
        }
        div.getShotokuShokaiHyoHakkoIchiranPanel().getDdlJuminzeiNendo().setDataSource(調定年度List);
        if (!調定年度List.isEmpty()) {
            div.getShotokuShokaiHyoHakkoIchiranPanel().getDdlJuminzeiNendo().setSelectedIndex(整数_0);
        }

        div.getShotokuShokaiHyoHakkoIchiranPanel().getTxtHakkoNengappi().setValue(RDate.getNowDate());
        List<ShotokushokaihyoTaishoSetaiin> 所得照会票発行対象世帯員リスト = getHandler(div)
                .get所得照会票発行対象世帯員リスト(識別コード);
        ViewStateHolder.put(ViewStateKeys.所得照会票発行対象世帯員, (Serializable) 所得照会票発行対象世帯員リスト);
        getHandler(div).set所得照会票個別発行個人一覧(所得照会票発行対象世帯員リスト);
        ViewStateHolder.put(ViewStateKeys.識別コード, 識別コード);
        MemoNyuryokuHandler.dataGridupdateImage(GyomuCode.DB介護保険, div.getShotokuShokaiHyoHakkoIchiranPanel()
                .getDgShotokuShokaiHyoHakko(), MemoShikibetsuTaisho.識別コード.get識別対象(), 文字列_識別対象コード,
                RString.EMPTY, RString.EMPTY, メモボタン);
        AccessLogger.log(AccessLogType.照会, toPersonalData(識別コード, 被保険者番号));
        return ResponseData.of(div).respond();

    }

    /**
     * [選択世帯員の印字内容を修正する]buttonを実行のメソッドます。
     *
     * @param div NushiJuminJohoDiv
     * @return NushiJuminJohoDiv
     */
    public ResponseData<NushiJuminJohoDiv> onClick_btnSentakuShusei(NushiJuminJohoDiv div) {
        getHandler(div).set世帯員の所得照会票印字内容の修正エリア();
        List<ShotokushokaihyoTaishoSetaiin> 所得照会票発行対象世帯員リスト = ViewStateHolder
                .get(ViewStateKeys.所得照会票発行対象世帯員, List.class);
        getHandler(div).set所得照会送付先(所得照会票発行対象世帯員リスト);
        return ResponseData.of(div).setState(DBB1150001StateName.所得照会票印字内容修正);
    }

    /**
     * [印字内容を修正前に戻すbutton]を実行のメソッドます。
     *
     * @param div NushiJuminJohoDiv
     * @return NushiJuminJohoDiv
     */
    public ResponseData<NushiJuminJohoDiv> onClick_btnModosu(NushiJuminJohoDiv div) {
        ShikibetsuCode 識別コード = ViewStateHolder.get(ViewStateKeys.識別コード, ShikibetsuCode.class);
        List<ShotokushokaihyoTaishoSetaiin> 所得照会票発行対象世帯員リスト = getHandler(div)
                .get所得照会票発行対象世帯員リスト(識別コード);
        ViewStateHolder.put(ViewStateKeys.所得照会票発行対象世帯員, (Serializable) 所得照会票発行対象世帯員リスト);
        getHandler(div).set所得照会票個別発行個人一覧(所得照会票発行対象世帯員リスト);
        return ResponseData.of(div).setState(DBB1150001StateName.所得照会票個別発行個人一覧);
    }

    /**
     * [選択世帯員の印字内容を確認するbutton]を実行のメソッドます。
     *
     * @param div NushiJuminJohoDiv
     * @return NushiJuminJohoDiv
     */
    public ResponseData<NushiJuminJohoDiv> onClick_btnConfirm(NushiJuminJohoDiv div) {
        ValidationMessageControlPairs valid = getNushiJuminJohoHandlerValidationHandler(div).validate();
        if (valid.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(valid).respond();
        }
        List<ShotokushokaihyoTaishoSetaiin> 所得照会票発行対象世帯員リスト = ViewStateHolder
                .get(ViewStateKeys.所得照会票発行対象世帯員, List.class);
        getHandler(div).set所得照会票の発行(所得照会票発行対象世帯員リスト);
        return ResponseData.of(div).setState(DBB1150001StateName.所得照会票発行);
    }

    /**
     * [廃棄して戻るbutton]を実行のメソッドます。
     *
     * @param div NushiJuminJohoDiv
     * @return NushiJuminJohoDiv
     */
    public ResponseData<NushiJuminJohoDiv> onClick_btnHakiBack(NushiJuminJohoDiv div) {
        div.getShotokuShokaihyoShuseiNyuryokuPanel().getShuseiSetaiInListPanel().getDgShuseiSetaiIn()
                .getDataSource().clear();
        return ResponseData.of(div).setState(DBB1150001StateName.所得照会票個別発行個人一覧);
    }

    /**
     * [所得照会送付先エリアの全国住所コードの変更]を実行のメソッドます。
     *
     * @param div NushiJuminJohoDiv
     * @return NushiJuminJohoDiv
     */
    public ResponseData<NushiJuminJohoDiv> onChange_txtZenkokuJushoCode(NushiJuminJohoDiv div) {
        getHandler(div).onChange_全国住所コード();
        return ResponseData.of(div).respond();
    }

    /**
     * [保存して戻るbutton]を実行のメソッドます。
     *
     * @param div NushiJuminJohoDiv
     * @return NushiJuminJohoDiv
     */
    public ResponseData<NushiJuminJohoDiv> onClick_btnHozonBack(NushiJuminJohoDiv div) {
        List<ShotokushokaihyoTaishoSetaiin> 所得照会票発行対象世帯員リスト = ViewStateHolder
                .get(ViewStateKeys.所得照会票発行対象世帯員, List.class);
        所得照会票発行対象世帯員リスト = getHandler(div).save所得照会票発行対象世帯員(所得照会票発行対象世帯員リスト);
        ViewStateHolder.put(ViewStateKeys.所得照会票発行対象世帯員, (Serializable) 所得照会票発行対象世帯員リスト);
        return ResponseData.of(div).setState(DBB1150001StateName.所得照会票個別発行個人一覧);
    }

    /**
     * [個別発行個人一覧に戻る]を実行のメソッドます。
     *
     * @param div NushiJuminJohoDiv
     * @return NushiJuminJohoDiv
     */
    public ResponseData<NushiJuminJohoDiv> onClick_btnIchiranBack(NushiJuminJohoDiv div) {
        return ResponseData.of(div).setState(DBB1150001StateName.所得照会票個別発行個人一覧);
    }

    /**
     * [発行check]を実行のメソッドます。
     *
     * @param div NushiJuminJohoDiv
     * @return NushiJuminJohoDiv
     */
    public ResponseData<NushiJuminJohoDiv> onClick_check(NushiJuminJohoDiv div) {
        ValidationMessageControlPairs valid = getNushiJuminJohoHandlerValidationHandler(div).validate住所一致();
        if (valid.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(valid).respond();
        }
        RString hdnFlag = div.getShotokuShokaihyoShuseiNyuryokuPanel().getSofusakiGenJushoShuseiPanel()
                .getSofusakiNyuryokuPanel().getTextNO1().getValue();
        RString flag = div.getShotokuShokaihyoShuseiNyuryokuPanel().getSofusakiGenJushoShuseiPanel()
                .getSofusakiNyuryokuPanel().getTextNo().getValue();
        if (文字列_TWO.equals(flag)) {
            if (!ResponseHolder.isReRequest() && !hdnFlag.equals(文字列_ONE) && !hdnFlag.equals(文字列_TWO)) {
                div.getShotokuShokaihyoShuseiNyuryokuPanel().getSofusakiGenJushoShuseiPanel()
                        .getSofusakiNyuryokuPanel().getTextNO1().setValue(文字列_ONE);
                return ResponseData.of(div)
                        .addMessage(DbzWarningMessages.確認.getMessage().replace(引数.toString())).respond();
            }
            if (ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
                List<DbT2008ShotokuKanriEntity> entityList = getHandler(div).get識別コード();
                if (entityList == null || entityList.isEmpty()) {
                    return ResponseData.of(div).respond();
                } else {
                    RString 編集した識別コード = RString.EMPTY;
                    for (DbT2008ShotokuKanriEntity entity : entityList) {
                        編集した識別コード = 編集した識別コード.concat(entity.getShikibetsuCode().value()).concat(区切);
                    }
                    編集した識別コード = 編集した識別コード.substring(整数_0, 編集した識別コード.length() - 整数_1);
                    if (!hdnFlag.equals(文字列_TWO)) {
                        div.getShotokuShokaihyoShuseiNyuryokuPanel().getSofusakiGenJushoShuseiPanel()
                                .getSofusakiNyuryokuPanel().getTextNO1().setValue(文字列_TWO);
                        return ResponseData.of(div).addMessage(DbzWarningMessages.確認.getMessage()
                                .replace(編集した識別コード.toString())).respond();
                    }
                    if (ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
                        List<ShotokushokaihyoTaishoSetaiin> 所得照会票発行対象世帯員リスト
                                = ViewStateHolder.get(ViewStateKeys.所得照会票発行対象世帯員, List.class);
                        getHandler(div).db出力(所得照会票発行対象世帯員リスト);
                        return ResponseData.of(div).respond();
                    }
                }
            }
        }
        return ResponseData.of(div).respond();
    }

    /**
     * [以上の内容を発行する]を実行のメソッドます。
     *
     * @param div NushiJuminJohoDiv
     * @return NushiJuminJohoDiv
     */
    public ResponseData<SourceDataCollection> onClick_btnReportPublish(NushiJuminJohoDiv div) {
        ChohyoSeigyoHanyo 帳票制御汎用Entity = TokuchoKaishiTsuchishoDataHenshu.createInstance()
                .load帳票制御汎用ByKey(帳票分類ID, 管理年度, 項目名);
        RString 通知書タイプ = 帳票制御汎用Entity.get設定値();
        RString 文書タイトル = TokuchoKaishiTsuchishoDataHenshu.createInstance()
                .load帳票制御汎用ByKey(帳票分類ID, 管理年度, 項目名_文書タイトル).get設定値();
        RString 送付先担当課名称 = TokuchoKaishiTsuchishoDataHenshu.createInstance()
                .load帳票制御汎用ByKey(帳票分類ID, 管理年度, 項目名_送付先担当課名称).get設定値();
        List<ShotokushokaihyoTaishoSetaiin> 所得照会票発行対象世帯員リスト = ViewStateHolder
                .get(ViewStateKeys.所得照会票発行対象世帯員, List.class);
        NushiJuminJohoResult 所得照会票 = getHandler(div).get所得照会票モデルを作成(所得照会票発行対象世帯員リスト);
        if (文字列_001.equals(通知書タイプ)) {
            return ResponseData.of(new ShotokuShokaihyoPrintSercive().
                    printＡ４横(所得照会票, 文書タイトル, 送付先担当課名称)).respond();
        }
        return ResponseData.of(new ShotokuShokaihyoPrintSercive()
                .printＡ４縦(所得照会票, 文書タイトル, 送付先担当課名称)).respond();
    }

    private PersonalData toPersonalData(ShikibetsuCode 識別コード, HihokenshaNo 被保険者番号) {
        ExpandedInformation expandedInfo = new ExpandedInformation(new Code(文字列_0003.toString()),
                文字列_被保険者番号, 被保険者番号.value());
        return PersonalData.of(識別コード, expandedInfo);
    }

    private NushiJuminJohoHandler getHandler(NushiJuminJohoDiv div) {
        return NushiJuminJohoHandler.of(div);
    }

    private NushiJuminJohoHandlerValidationHandler getNushiJuminJohoHandlerValidationHandler(
            NushiJuminJohoDiv div) {
        return new NushiJuminJohoHandlerValidationHandler(div);
    }

}
