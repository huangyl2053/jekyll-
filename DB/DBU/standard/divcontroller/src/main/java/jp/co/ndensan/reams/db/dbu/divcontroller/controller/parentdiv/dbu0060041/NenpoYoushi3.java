/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.divcontroller.controller.parentdiv.dbu0060041;

import java.util.List;
import jp.co.ndensan.reams.db.dbu.business.core.basic.JigyoHokokuTokeiData;
import jp.co.ndensan.reams.db.dbu.definition.core.nenpoyoushi3.NenpoYoushi3ViewStateKeys;
import jp.co.ndensan.reams.db.dbu.definition.core.zigyouhoukokunenpou.ZigyouHoukokuNenpouHoseihakouKensakuRelateEntity;
import jp.co.ndensan.reams.db.dbu.definition.enumeratedtype.DbuViewStateKey;
import jp.co.ndensan.reams.db.dbu.definition.jigyohokokunenpo.DeleteJigyoHokokuNenpo;
import jp.co.ndensan.reams.db.dbu.definition.jigyohokokunenpo.SearchJigyoHokokuNenpo;
import jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0060011.DBU0060011TransitionEventName;
import jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0060041.DBU0060041StateName;
import jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0060041.NenpoYoushi3Div;
import jp.co.ndensan.reams.db.dbu.divcontroller.handler.parentdiv.dbu0060041.NenpoYoushi3Handler;
import jp.co.ndensan.reams.db.dbu.service.core.jigyohokokunenpo.JigyoHokokuNenpoHoseiHakoManager;
import jp.co.ndensan.reams.db.dbz.definition.message.DbzErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.message.QuestionMessage;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;
import jp.co.ndensan.reams.uz.uza.util.Models;

/**
 * 事業報告（年報）補正、発行_様式３画面です。
 *
 */
public class NenpoYoushi3 {

    private static final Code 集計番号_0100 = new Code("0100");
    private static final Code 集計番号_0200 = new Code("0200");
    private static final RString 保険料収納状況 = new RString("3.保険料収納状況");
    private static final RString 保険給付支払状況 = new RString("4.保険給付支払状況");
    private static final RString フラグ_修正 = new RString("修正");
    private static final RString フラグ_削除 = new RString("削除");
    private FlexibleYear 報告年;
    private FlexibleYear 集計対象年;
    private LasdecCode 市町村コード;
    private RString 様式種類コード;
    private FlexibleDate 報告年度;
    private FlexibleDate 集計年度;
    private RString 保険者コード;
    private RString 保険者名称;
    private RString 補正フラグ;

    /**
     * 画面初期化を表示です。
     *
     * @param div　NenpoYoushi3Div
     * @return ResponseData<NenpoYoushi3Div>
     */
    public ResponseData<NenpoYoushi3Div> onLoad(NenpoYoushi3Div div) {
        ZigyouHoukokuNenpouHoseihakouKensakuRelateEntity entity1 = new ZigyouHoukokuNenpouHoseihakouKensakuRelateEntity();
        entity1.set画面報告年度(new RString("19900101"));
        entity1.set画面集計年度(new RString("20100202"));
        entity1.set保険者コード(new RString("123456"));
        entity1.set市町村名称(new RString("市町村名称"));
        entity1.set補正フラグ(new RString("修正"));
        entity1.set行報告年(new RString("1990"));
        entity1.set行集計対象年(new RString("2016"));
        entity1.set行市町村コード(new RString("123456"));
        entity1.set事業報告年報補正表示のコード(new RString("003"));
        ViewStateHolder.put(DbuViewStateKey.補正検索画面情報, entity1);
        if (!get保険料収納状況データ(div) || !get保険給付支払状況データ(div)) {
            throw new ApplicationException(UrErrorMessages.該当データなし.getMessage());
        }
        return ResponseData.of(div).respond();
    }

    /**
     * タブを切り替え時に設定です。
     *
     * @param div NenpoYoushi3Div
     * @return ResponseData<NenpoYoushi3Div>
     */
    public ResponseData<NenpoYoushi3Div> onChange_tab(NenpoYoushi3Div div) {
        RString title = div.getShokuhikyojunofutannintei().getTabShokuhikyojunofutannintei().getSelectedItem().getTitle();
        if (title.equals(保険料収納状況)) {
            onLoad(div);
        } else if (title.equals(保険給付支払状況)) {
            get保険給付支払状況データ(div);
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 保存を処理します。
     *
     * @param div NenpoYoushi3Div
     * @return ResponseData<NenpoYoushi3Div>
     */
    public ResponseData<NenpoYoushi3Div> onClick_hozon(NenpoYoushi3Div div) {
        ZigyouHoukokuNenpouHoseihakouKensakuRelateEntity entity
                = ViewStateHolder.get(DbuViewStateKey.補正検索画面情報, ZigyouHoukokuNenpouHoseihakouKensakuRelateEntity.class);
        報告年 = new FlexibleYear(entity.get行報告年());
        集計対象年 = new FlexibleYear(entity.get行集計対象年());
        市町村コード = new LasdecCode(entity.get行市町村コード());
        様式種類コード = entity.get事業報告年報補正表示のコード();
        補正フラグ = entity.get補正フラグ();
        if (補正フラグ.equals(フラグ_修正)) {
            List<JigyoHokokuTokeiData> 修正データリスト = getHandler(div).get修正データ();
            if (修正データリスト == null || 修正データリスト.isEmpty()) {
                throw new ApplicationException(DbzErrorMessages.編集なしで更新不可.getMessage());
            }
            if (!ResponseHolder.isReRequest()) {
                QuestionMessage message = new QuestionMessage(UrQuestionMessages.処理実行の確認.getMessage().getCode(),
                        UrQuestionMessages.処理実行の確認.getMessage().evaluate());
                return ResponseData.of(div).addMessage(message).respond();
            }
            if (new RString(UrQuestionMessages.処理実行の確認.getMessage().getCode()).equals(ResponseHolder.getMessageCode())
                    && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
                JigyoHokokuNenpoHoseiHakoManager.createInstance().updateJigyoHokokuNenpoData(修正データリスト);
                return ResponseData.of(div).setState(DBU0060041StateName.完了状態);
            }
            return ResponseData.of(div).respond();
        } else if (補正フラグ.equals(フラグ_削除)) {
            DeleteJigyoHokokuNenpo jigyoHokokuNenpoDelete = new DeleteJigyoHokokuNenpo(報告年, 集計対象年, 市町村コード, 様式種類コード);
            JigyoHokokuNenpoHoseiHakoManager.createInstance().deleteJigyoHokokuNenpoData(jigyoHokokuNenpoDelete);
            return ResponseData.of(div).setState(DBU0060041StateName.完了状態);
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 一覧へ戻るを処理します。
     *
     * @param div NenpoYoushi3Div
     * @return ResponseData<NenpoYoushi3Div>
     */
    public ResponseData<NenpoYoushi3Div> onClick_modoru(NenpoYoushi3Div div) {
        List<JigyoHokokuTokeiData> 修正データリスト = getHandler(div).get修正データ();
        if (修正データリスト == null || 修正データリスト.isEmpty()) {
            // TODO  事業報告（年報）補正、発行①_検索画面へ遷移
            return ResponseData.of(div).forwardWithEventName(DBU0060011TransitionEventName.様式３に遷移).respond();
        }
        if (!ResponseHolder.isReRequest()) {
            QuestionMessage message = new QuestionMessage(UrQuestionMessages.入力内容の破棄.getMessage().getCode(),
                    UrQuestionMessages.入力内容の破棄.getMessage().evaluate());
            return ResponseData.of(div).addMessage(message).respond();
        }
        if (new RString(UrQuestionMessages.入力内容の破棄.getMessage().getCode()).equals(ResponseHolder.getMessageCode())
                && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            // TODO  事業報告（年報）補正、発行①_検索画面へ遷移
            return ResponseData.of(div).forwardWithEventName(DBU0060011TransitionEventName.様式３に遷移).respond();
        }
        return ResponseData.of(div).respond();
    }

    private boolean get保険料収納状況データ(NenpoYoushi3Div div) {
        ZigyouHoukokuNenpouHoseihakouKensakuRelateEntity entity
                = ViewStateHolder.get(DbuViewStateKey.補正検索画面情報, ZigyouHoukokuNenpouHoseihakouKensakuRelateEntity.class);
        報告年度 = new FlexibleDate(entity.get画面報告年度());
        集計年度 = new FlexibleDate(entity.get画面集計年度());
        保険者コード = entity.get保険者コード();
        保険者名称 = entity.get市町村名称();
        報告年 = new FlexibleYear(entity.get行報告年());
        集計対象年 = new FlexibleYear(entity.get行集計対象年());
        市町村コード = new LasdecCode(entity.get行市町村コード());
        様式種類コード = entity.get事業報告年報補正表示のコード();
        補正フラグ = entity.get補正フラグ();
        SearchJigyoHokokuNenpo jigyoHokokuNenpoSearch = new SearchJigyoHokokuNenpo(報告年, 集計対象年, 市町村コード, 様式種類コード, 集計番号_0100);
        List<JigyoHokokuTokeiData> 事業報告集計一覧データリスト = JigyoHokokuNenpoHoseiHakoManager.createInstance().
                getJigyoHokokuNenpoDetal(jigyoHokokuNenpoSearch).records();
        ViewStateHolder.put(NenpoYoushi3ViewStateKeys.保険料収納状況データ, Models.create(事業報告集計一覧データリスト));
        if (事業報告集計一覧データリスト == null || 事業報告集計一覧データリスト.isEmpty()) {
            return false;
        } else {
            getHandler(div).initialize(事業報告集計一覧データリスト, 補正フラグ, 報告年度, 集計年度, 保険者コード, 保険者名称);
            return true;
        }
    }

    private boolean get保険給付支払状況データ(NenpoYoushi3Div div) {
        ZigyouHoukokuNenpouHoseihakouKensakuRelateEntity entity
                = ViewStateHolder.get(DbuViewStateKey.補正検索画面情報, ZigyouHoukokuNenpouHoseihakouKensakuRelateEntity.class);
        報告年 = new FlexibleYear(entity.get行報告年());
        集計対象年 = new FlexibleYear(entity.get行集計対象年());
        市町村コード = new LasdecCode(entity.get行市町村コード());
        様式種類コード = entity.get事業報告年報補正表示のコード();
        SearchJigyoHokokuNenpo jigyoHokokuNenpoSearch = new SearchJigyoHokokuNenpo(報告年, 集計対象年, 市町村コード, 様式種類コード, 集計番号_0200);
        List<JigyoHokokuTokeiData> 事業報告集計一覧データリスト = JigyoHokokuNenpoHoseiHakoManager.createInstance().
                getJigyoHokokuNenpoDetal(jigyoHokokuNenpoSearch).records();
        ViewStateHolder.put(NenpoYoushi3ViewStateKeys.保険給付支払状況データ, Models.create(事業報告集計一覧データリスト));
        if (事業報告集計一覧データリスト == null || 事業報告集計一覧データリスト.isEmpty()) {
            return false;
        } else {
            getHandler(div).set保険給付支払状況詳細データ(事業報告集計一覧データリスト);
            return true;
        }
    }

    private NenpoYoushi3Handler getHandler(NenpoYoushi3Div div) {
        return new NenpoYoushi3Handler(div);
    }
}
