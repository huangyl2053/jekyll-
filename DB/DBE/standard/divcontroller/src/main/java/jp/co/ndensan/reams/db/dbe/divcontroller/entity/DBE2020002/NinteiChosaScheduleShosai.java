/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.entity.DBE2020002;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.chikuninteichosain.ChikuNinteiChosain;
import jp.co.ndensan.reams.db.dbe.business.core.chikuninteichosain.ChikuNinteiKoseiShichoson;
import jp.co.ndensan.reams.db.dbe.business.core.chikuninteichosain.ChikuNinteiNinteichosa;
import jp.co.ndensan.reams.db.dbe.business.core.chikuninteichosain.NinteichosaSchedule;
import jp.co.ndensan.reams.db.dbe.definition.mybatis.param.chikuninteichosain.ChosainJohoParameter;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2020002.DBE2020002TransitionEventName;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2020002.NinteiChosaScheduleShosaiDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2020002.dgNinteiChosaSchedule_Row;
import jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE2020002.NinteiChosaScheduleShosaiHander;
import jp.co.ndensan.reams.db.dbe.service.core.ninteishinseijoho.chikuninteichosainmapper.ChosainJohoFander;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.divcontroller.viewbox.ViewStateKeys;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.CodeShubetsu;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;
import jp.co.ndensan.reams.uz.uza.util.code.CodeMaster;
import jp.co.ndensan.reams.uz.uza.util.code.entity.UzT0007CodeEntity;

/**
 *
 * 認定調査スケジュール登録2クラスです。
 */
public class NinteiChosaScheduleShosai {

    public static FlexibleDate 設定日;
    public static Code 地区コード;
    public static LasdecCode 保険者;
    public static RString 調査員状況;
    public static RString 認定調査委託先コード;
    public static RString 画面ステート;
    public static ShinseishoKanriNo 申請書管理番号2;

    /**
     * 認定調査スケジュール登録2初期化の処理です。
     *
     * @param div NinteiChosaScheduleShosaiDiv
     * @return ResponseData<NinteiChosaScheduleShosaiDiv>
     */
    public ResponseData<NinteiChosaScheduleShosaiDiv> onLoad(NinteiChosaScheduleShosaiDiv div) {
        ViewStateHolder.put(ViewStateKeys.認定調査スケジュール登録_地区コード, new RString("00001"));
        ViewStateHolder.put(ViewStateKeys.認定調査スケジュール登録_設定日, new RString("20160127"));
        ViewStateHolder.put(ViewStateKeys.認定調査スケジュール登録_調査員状況02, new RString("空き"));
        ViewStateHolder.put(ViewStateKeys.認定調査スケジュール登録_保険者, new RString("123456"));
        ViewStateHolder.put(ViewStateKeys.認定調査スケジュール登録_認定調査委託先コード, new RString("1234567890"));
        ViewStateHolder.put(ViewStateKeys.認定調査スケジュール登録_画面ステート, new RString("1"));
        地区コード = new Code(ViewStateHolder.get(ViewStateKeys.認定調査スケジュール登録_地区コード, RString.class).toString());
        設定日 = new FlexibleDate(ViewStateHolder.get(ViewStateKeys.認定調査スケジュール登録_設定日, RString.class).toString());
        調査員状況 = ViewStateHolder.get(ViewStateKeys.認定調査スケジュール登録_調査員状況02, RString.class);
        保険者 = new LasdecCode(ViewStateHolder.get(ViewStateKeys.認定調査スケジュール登録_保険者, RString.class).toString());
        認定調査委託先コード = ViewStateHolder.get(ViewStateKeys.認定調査スケジュール登録_認定調査委託先コード, RString.class);
        画面ステート = ViewStateHolder.get(ViewStateKeys.認定調査スケジュール登録_画面ステート, RString.class);
        ChosainJohoParameter parame = ChosainJohoParameter.createParam_メモ情報件数(設定日, 地区コード);
        int 通常件数 = ChosainJohoFander.createInstance().get通常メモ情報件数(parame);
        int 重要件数 = ChosainJohoFander.createInstance().get重要メモ情報件数(parame);
        List<UzT0007CodeEntity> get対象地区List = CodeMaster.getCode(SubGyomuCode.DBE認定支援, new CodeShubetsu("5002"));
        ChosainJohoParameter parameter = ChosainJohoParameter.createParam_認定調査スケジュール詳細情報(設定日, 調査員状況, 地区コード, 保険者, 認定調査委託先コード);
        List<ChikuNinteiChosain> 認定調査スケジュールList = ChosainJohoFander.createInstance().get認定調査スケジュール詳細情報(parameter).records();
        ChosainJohoParameter hokensyaParameter = ChosainJohoParameter.createParam_保険者名(地区コード);
        List<ChikuNinteiKoseiShichoson> 保険者List = ChosainJohoFander.createInstance().get保険者(hokensyaParameter).records();
        getHandler(div).onLoad(通常件数, 重要件数, get対象地区List, 画面ステート, 認定調査スケジュールList, 保険者List);
        return ResponseData.of(div).respond();
    }

    /**
     * 認定調査委託先一覧の対象地区onselectの処理です。
     *
     * @param div NinteiChosaScheduleShosaiDiv
     * @return ResponseData<NinteiChosaScheduleShosaiDiv>
     */
    public ResponseData<NinteiChosaScheduleShosaiDiv> onSelect_TayisyouTiku(NinteiChosaScheduleShosaiDiv div) {
        設定日 = new FlexibleDate(ViewStateHolder.get(ViewStateKeys.認定調査スケジュール登録_設定日, RString.class).toString());
        地区コード = new Code(div.getDdlTaishoChiku().getSelectedKey().toString());
        if (地区コード == null || 地区コード.isEmpty()) {
            return ResponseData.of(div).respond();
        }
        ChosainJohoParameter parameter = ChosainJohoParameter.createParam_保険者名(地区コード);
        List<ChikuNinteiKoseiShichoson> 保険者List = ChosainJohoFander.createInstance().get保険者(parameter).records();
        ChosainJohoParameter parame = ChosainJohoParameter.createParam_メモ情報件数(設定日, 地区コード);
        int 通常件数 = ChosainJohoFander.createInstance().get通常メモ情報件数(parame);
        int 重要件数 = ChosainJohoFander.createInstance().get重要メモ情報件数(parame);
        getHandler(div).onselect_保険者名称取得(保険者List, 通常件数, 重要件数);
        return ResponseData.of(div).respond();
    }

    /**
     * 認定調査委託先一覧の保険者onselectの処理です。
     *
     * @param div NinteiChosaScheduleShosaiDiv
     * @return ResponseData<NinteiChosaScheduleShosaiDiv>
     */
    public ResponseData<NinteiChosaScheduleShosaiDiv> onSelect_Hokensya(NinteiChosaScheduleShosaiDiv div) {
        地区コード = new Code(div.getDdlTaishoChiku().getSelectedKey().toString());
        LasdecCode 市町村コード = new LasdecCode(div.getDdlHokensha().getSelectedKey().toString());
        if (地区コード == null || 地区コード.isEmpty()
                || 市町村コード.isEmpty()) {
            return ResponseData.of(div).respond();
        }
        ChosainJohoParameter parameter = ChosainJohoParameter.createParam_認定調査委託先名称(地区コード, 市町村コード);
        List<ChikuNinteiNinteichosa> 認定調査委託先名List = ChosainJohoFander.createInstance().get認定調査委託先名称(parameter).records();
        List<UzT0007CodeEntity> get対象地区List = CodeMaster.getCode(SubGyomuCode.DBE認定支援, new CodeShubetsu("5002"));
        getHandler(div).onSelect_Hokensya(get対象地区List, 認定調査委託先名List, 地区コード);
        return ResponseData.of(div).respond();
    }

    /**
     * 認定調査委託先一覧の検索するボタンの処理です。
     *
     * @param div NinteiChosaScheduleShosaiDiv
     * @return ResponseData<NinteiChosaScheduleShosaiDiv>
     */
    public ResponseData<NinteiChosaScheduleShosaiDiv> onClick_BtnKensaku(NinteiChosaScheduleShosaiDiv div) {
        保険者 = new LasdecCode(div.getDdlHokensha().getSelectedKey());
        認定調査委託先コード = div.getDdlninteiChosaItakusaki().getSelectedKey();
        if (保険者 == null || 保険者.isEmpty()) {
            throw new ApplicationException(UrErrorMessages.選択されていない.getMessage().replace("保険者"));
        }
        if (認定調査委託先コード == null || 認定調査委託先コード.isEmpty()) {
            throw new ApplicationException(UrErrorMessages.選択されていない.getMessage().replace("認定調査委託先"));
        }
        設定日 = div.getSearchNinteiChosaSchedule().getTxtSetteiDate().getValue();
        調査員状況 = div.getRadChosainJokyo().getSelectedValue();
        地区コード = new Code(div.getDdlTaishoChiku().getSelectedKey());
        ChosainJohoParameter parameter = ChosainJohoParameter.createParam_認定調査スケジュール詳細情報(設定日, 調査員状況, 地区コード, 保険者, 認定調査委託先コード);
        List<ChikuNinteiChosain> 認定調査スケジュールList = ChosainJohoFander.createInstance().get認定調査スケジュール詳細情報検索(parameter).records();
        if (認定調査スケジュールList == null || 認定調査スケジュールList.isEmpty()) {
            // TODO 認定調査スケジュール詳細Grid 閉じている
            div.getNchosainScheduleIchiran().setCanOpenAndClose(false);
            throw new ApplicationException(UrErrorMessages.対象データなし.getMessage().replace("認定調査委託先"));
        }
        getHandler(div).set認定調査スケジュール詳細情報(認定調査スケジュールList);
        return ResponseData.of(div).respond();
    }

    /**
     * 認定調査委託先一覧の前日へボタンの処理です。
     *
     * @param div NinteiChosaScheduleShosaiDiv
     * @return ResponseData<NinteiChosaScheduleShosaiDiv>
     */
    public ResponseData<NinteiChosaScheduleShosaiDiv> onSelect_BtnZenji(NinteiChosaScheduleShosaiDiv div) {
        設定日 = div.getSearchNinteiChosaSchedule().getTxtSetteiDate().getValue();
        地区コード = new Code(div.getDdlTaishoChiku().getSelectedKey().toString());
        ChosainJohoParameter parame = ChosainJohoParameter.createParam_メモ情報件数(設定日, 地区コード);
        int 通常件数 = ChosainJohoFander.createInstance().get通常メモ情報件数(parame);
        int 重要件数 = ChosainJohoFander.createInstance().get重要メモ情報件数(parame);
        getHandler(div).onSelect前日(設定日, 通常件数, 重要件数);
        return ResponseData.of(div).respond();
    }

    /**
     * 認定調査委託先一覧の次日へボタンの処理です。
     *
     * @param div NinteiChosaScheduleShosaiDiv
     * @return ResponseData<NinteiChosaScheduleShosaiDiv>
     */
    public ResponseData<NinteiChosaScheduleShosaiDiv> onSelect_BtnTugihi(NinteiChosaScheduleShosaiDiv div) {
        設定日 = div.getSearchNinteiChosaSchedule().getTxtSetteiDate().getValue();
        地区コード = new Code(div.getDdlTaishoChiku().getSelectedKey().toString());
        ChosainJohoParameter parame = ChosainJohoParameter.createParam_メモ情報件数(設定日, 地区コード);
        int 通常件数 = ChosainJohoFander.createInstance().get通常メモ情報件数(parame);
        int 重要件数 = ChosainJohoFander.createInstance().get重要メモ情報件数(parame);
        getHandler(div).onSelect次日(設定日, 通常件数, 重要件数);
        return ResponseData.of(div).respond();
    }

    /**
     * 認定調査委託先一覧のメモを表示するボタンの処理です。
     *
     * @param div NinteiChosaScheduleShosaiDiv
     * @return ResponseData<NinteiChosaScheduleShosaiDiv>
     */
    public ResponseData<NinteiChosaScheduleShosaiDiv> onSelect_BtnMemoHyouji(NinteiChosaScheduleShosaiDiv div) {
        //TODO 実装メーソド待ち
        地区コード = new Code(div.getDdlTaishoChiku().getSelectedKey());
        設定日 = div.getTxtSetteiDate().getValue();
        return ResponseData.of(div).forwardWithEventName(DBE2020002TransitionEventName.メモ入力).respond();
    }

    /**
     * 認定調査委託先一覧のメモを表示するボタンの処理です。
     *
     * @param div NinteiChosaScheduleShosaiDiv
     * @return ResponseData<NinteiChosaScheduleShosaiDiv>
     */
    public ResponseData<NinteiChosaScheduleShosaiDiv> onSelect_BtnModoru(NinteiChosaScheduleShosaiDiv div) {
        //TODO 実装メーソド待ち
        return ResponseData.of(div).forwardWithEventName(DBE2020002TransitionEventName.メモ入力).respond();
    }

    /**
     * 認定調査委託先一覧の編集ボタン1の処理です。
     *
     * @param div NinteiChosaScheduleShosaiDiv
     * @return ResponseData<NinteiChosaScheduleShosaiDiv>
     */
    public ResponseData<NinteiChosaScheduleShosaiDiv> onClick_selectMemo1(NinteiChosaScheduleShosaiDiv div) {

        dgNinteiChosaSchedule_Row row = div.getDgNinteiChosaSchedule().getActiveRow();
        RString 認定調査員コード = row.getNinteiChosainCode();
        RString 認定調査予定時間 = row.getChosaTimeFrame1();
        onClick_selectHansyou(div, 認定調査予定時間, 認定調査員コード, new Code("1"));
        //TODO 実装メーソド待ち
        return ResponseData.of(div).forwardWithEventName(DBE2020002TransitionEventName.更新モード_スケジュール一覧に戻る).respond();
    }

    public ResponseData<NinteiChosaScheduleShosaiDiv> onClick_selectMemo2(NinteiChosaScheduleShosaiDiv div) {

        dgNinteiChosaSchedule_Row row = div.getDgNinteiChosaSchedule().getActiveRow();
        RString 認定調査員コード = row.getNinteiChosainCode();
        RString 認定調査予定時間 = row.getChosaTimeFrame2();
        onClick_selectHansyou(div, 認定調査予定時間, 認定調査員コード, new Code("2"));
        return ResponseData.of(div).forwardWithEventName(DBE2020002TransitionEventName.更新モード_スケジュール一覧に戻る).respond();
    }

    public ResponseData<NinteiChosaScheduleShosaiDiv> onClick_selectMemo3(NinteiChosaScheduleShosaiDiv div) {

        dgNinteiChosaSchedule_Row row = div.getDgNinteiChosaSchedule().getActiveRow();
        RString 認定調査員コード = row.getNinteiChosainCode();
        RString 認定調査予定時間 = row.getChosaTimeFrame3();
        onClick_selectHansyou(div, 認定調査予定時間, 認定調査員コード, new Code("3"));
        return ResponseData.of(div).forwardWithEventName(DBE2020002TransitionEventName.更新モード_スケジュール入力).respond();
    }

    public ResponseData<NinteiChosaScheduleShosaiDiv> onClick_selectMemo4(NinteiChosaScheduleShosaiDiv div) {

        dgNinteiChosaSchedule_Row row = div.getDgNinteiChosaSchedule().getActiveRow();
        RString 認定調査員コード = row.getNinteiChosainCode();
        RString 認定調査予定時間 = row.getChosaTimeFrame4();
        onClick_selectHansyou(div, 認定調査予定時間, 認定調査員コード, new Code("4"));
        return ResponseData.of(div).forwardWithEventName(DBE2020002TransitionEventName.更新モード_スケジュール一覧に戻る).respond();
    }

    public ResponseData<NinteiChosaScheduleShosaiDiv> onClick_selectMemo5(NinteiChosaScheduleShosaiDiv div) {

        dgNinteiChosaSchedule_Row row = div.getDgNinteiChosaSchedule().getActiveRow();
        RString 認定調査員コード = row.getNinteiChosainCode();
        RString 認定調査予定時間 = row.getChosaTimeFrame5();
        onClick_selectHansyou(div, 認定調査予定時間, 認定調査員コード, new Code("5"));
        return ResponseData.of(div).forwardWithEventName(DBE2020002TransitionEventName.更新モード_スケジュール一覧に戻る).respond();
    }

    public ResponseData<NinteiChosaScheduleShosaiDiv> onClick_selectMemo6(NinteiChosaScheduleShosaiDiv div) {

        dgNinteiChosaSchedule_Row row = div.getDgNinteiChosaSchedule().getActiveRow();
        RString 認定調査員コード = row.getNinteiChosainCode();
        RString 認定調査予定時間 = row.getChosaTimeFrame6();
        onClick_selectHansyou(div, 認定調査予定時間, 認定調査員コード, new Code("6"));
        return ResponseData.of(div).forwardWithEventName(DBE2020002TransitionEventName.更新モード_スケジュール一覧に戻る).respond();
    }

    public ResponseData<NinteiChosaScheduleShosaiDiv> onClick_selectMemo7(NinteiChosaScheduleShosaiDiv div) {

        dgNinteiChosaSchedule_Row row = div.getDgNinteiChosaSchedule().getActiveRow();
        RString 認定調査員コード = row.getNinteiChosainCode();
        RString 認定調査予定時間 = row.getChosaTimeFrame7();
        onClick_selectHansyou(div, 認定調査予定時間, 認定調査員コード, new Code("7"));
        return ResponseData.of(div).forwardWithEventName(DBE2020002TransitionEventName.更新モード_スケジュール一覧に戻る).respond();
    }

    public ResponseData<NinteiChosaScheduleShosaiDiv> onClick_selectMemo8(NinteiChosaScheduleShosaiDiv div) {

        dgNinteiChosaSchedule_Row row = div.getDgNinteiChosaSchedule().getActiveRow();
        RString 認定調査員コード = row.getNinteiChosainCode();
        RString 認定調査予定時間 = row.getChosaTimeFrame8();
        onClick_selectHansyou(div, 認定調査予定時間, 認定調査員コード, new Code("8"));
        return ResponseData.of(div).forwardWithEventName(DBE2020002TransitionEventName.更新モード_スケジュール一覧に戻る).respond();
    }

    public ResponseData<NinteiChosaScheduleShosaiDiv> onClick_selectMemo9(NinteiChosaScheduleShosaiDiv div) {

        dgNinteiChosaSchedule_Row row = div.getDgNinteiChosaSchedule().getActiveRow();
        RString 認定調査員コード = row.getNinteiChosainCode();
        RString 認定調査予定時間 = row.getChosaTimeFrame9();
        onClick_selectHansyou(div, 認定調査予定時間, 認定調査員コード, new Code("9"));
        return ResponseData.of(div).forwardWithEventName(DBE2020002TransitionEventName.更新モード_スケジュール一覧に戻る).respond();
    }

    public ResponseData<NinteiChosaScheduleShosaiDiv> onClick_selectMemo10(NinteiChosaScheduleShosaiDiv div) {

        dgNinteiChosaSchedule_Row row = div.getDgNinteiChosaSchedule().getActiveRow();
        RString 認定調査員コード = row.getNinteiChosainCode();
        RString 認定調査予定時間 = row.getChosaTimeFrame10();
        onClick_selectHansyou(div, 認定調査予定時間, 認定調査員コード, new Code("10"));
        return ResponseData.of(div).forwardWithEventName(DBE2020002TransitionEventName.更新モード_スケジュール一覧に戻る).respond();
    }

    private static void onClick_selectHansyou(NinteiChosaScheduleShosaiDiv div, RString 認定調査予定時間, RString 認定調査員コード, Code 選択された時間枠) {
        地区コード = new Code(div.getDdlTaishoChiku().getSelectedKey());
        保険者 = new LasdecCode(div.getDdlHokensha().getSelectedKey());
        認定調査委託先コード = div.getDdlninteiChosaItakusaki().getSelectedKey();
        設定日 = div.getSearchNinteiChosaSchedule().getTxtSetteiDate().getValue();
        RString 認定調査予定開始時間 = new RString("");
        RString 認定調査予定終了時間 = new RString("");
        if (認定調査予定時間 != null && !認定調査予定時間.isEmpty()) {
            認定調査予定開始時間 = 認定調査予定時間.substring(4);
            認定調査予定終了時間 = 認定調査予定時間.substring(5, 8);
        }
        ChosainJohoParameter parameter = ChosainJohoParameter.createParam_申請書管理番号(
                設定日,
                地区コード,
                保険者,
                認定調査委託先コード,
                認定調査員コード,
                認定調査予定開始時間,
                認定調査予定終了時間,
                選択された時間枠);
        NinteichosaSchedule 申請書管理番号 = ChosainJohoFander.createInstance().get申請書管理番号(parameter);
        //TODO 10画面（NinteiChosaWariateInput）へ遷移
        if (申請書管理番号 == null) {
            ViewStateHolder.put(ViewStateKeys.認定調査スケジュール登録_申請書管理番号2, new ShinseishoKanriNo(""));
        } else {
            ViewStateHolder.put(ViewStateKeys.認定調査スケジュール登録_申請書管理番号2, 申請書管理番号.get申請書管理番号());
        }
    }

    private NinteiChosaScheduleShosaiHander getHandler(NinteiChosaScheduleShosaiDiv div) {
        return new NinteiChosaScheduleShosaiHander(div);
    }
}
