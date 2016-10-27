/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.divcontroller.controller.parentdiv.DBA1080011;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dba.business.core.shikakushutokujogaishakanri.ShikakuShutokuJogaishaKanri;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.parentdiv.DBA1080011.DBA1080011StateName;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.parentdiv.DBA1080011.JogaishaTorokuDiv;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.parentdiv.DBA1080011.dgNenreiTotatshusha_Row;
import jp.co.ndensan.reams.db.dba.divcontroller.handler.parentdiv.DBA1080011.JogaishaTorokuHandler;
import jp.co.ndensan.reams.db.dba.divcontroller.handler.parentdiv.DBA1080011.JogaishaTorokuSetter;
import jp.co.ndensan.reams.db.dba.service.core.shikakushutokujogaishakanri.ShikakuShutokuJogaishaKanriManager;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.db.dbz.business.core.ShikakuShutokuJogaisha;
import jp.co.ndensan.reams.db.dbz.business.core.ShikakuShutokuJogaishaBuilder;
import jp.co.ndensan.reams.db.dbz.business.core.ShikakuShutokuJogaishaIdentifier;
import static jp.co.ndensan.reams.db.dbz.definition.core.config.ConfigKeysJukyuShikakuShomeishoHakko.資格取得除外者登録キー;
import static jp.co.ndensan.reams.db.dbz.definition.core.config.ConfigKeysJukyuShikakuShomeishoHakko.除外者データキー;
import jp.co.ndensan.reams.db.dbz.service.TaishoshaKey;
import jp.co.ndensan.reams.ur.urz.definition.message.UrInformationMessages;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.exclusion.LockingKey;
import jp.co.ndensan.reams.uz.uza.exclusion.RealInitialLocker;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGrid;
import jp.co.ndensan.reams.uz.uza.ui.binding.RowState;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;
import jp.co.ndensan.reams.uz.uza.util.Models;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import jp.co.ndensan.reams.uz.uza.util.db.SearchResult;

/**
 * 資格取得除外者登録のクラスです。
 *
 * @reamsid_L DBA-0440-030 zhangzhiming
 */
public class JogaishaToroku {

    private static final RString 排他 = new RString("ShikakuShutokuJogaishaToroku");

    /**
     * 資格取得除外者登録の初期化します。<br/>
     *
     * @param requestDiv JogaishaTorokuDiv
     * @return ResponseData<JogaishaTorokuDiv>
     */
    public ResponseData<JogaishaTorokuDiv> onLoad(JogaishaTorokuDiv requestDiv) {

        if (ViewStateHolder.get(資格取得除外者登録キー, RString.class) == null || ViewStateHolder.get(資格取得除外者登録キー, RString.class).isEmpty()) {
            SearchResult<ShikakuShutokuJogaishaKanri> 資格取得除外者情報
                    = ShikakuShutokuJogaishaKanriManager.createInstance().getTennyuHoryuTokuteiJushoIchiran();
            getHandler(requestDiv).onLoad(資格取得除外者情報.records());
            List<ShikakuShutokuJogaisha> 資格取得除外者一覧 = ShikakuShutokuJogaishaKanriManager.createInstance().get資格取得除外者一覧().records();
            Models<ShikakuShutokuJogaishaIdentifier, ShikakuShutokuJogaisha> shikakuShutokuJogaisha
                    = Models.create(資格取得除外者一覧);
            ViewStateHolder.put(ViewStateKeys.資格取得除外者一覧, shikakuShutokuJogaisha);
        } else {
            JogaishaTorokuSetter jogaishaTorokuSetter = ViewStateHolder.get(除外者データキー, JogaishaTorokuSetter.class);
            ShikibetsuCode 識別コード = ViewStateHolder.get(ViewStateKeys.資格対象者, TaishoshaKey.class).get識別コード();
            ShikakuShutokuJogaishaKanri get宛名情報 = ShikakuShutokuJogaishaKanriManager.createInstance().get宛名情報(識別コード);
            jogaishaTorokuSetter.setShikibetsuCode(識別コード.value());
            jogaishaTorokuSetter.setShikibetsuCodeName(get宛名情報.getMeisho().value());
            getHandler(requestDiv).onLoadKen(jogaishaTorokuSetter);
        }
        return ResponseData.of(requestDiv).setState(DBA1080011StateName.初期状態);
    }

    /**
     * 資格取得除外者登録が操作可能になった際に実行されるイベントです。<br/>
     * 識別対象を検索する画面から戻ってきた際に、テキストボックスに選択した識別対象を反映します。
     *
     * @param requestDiv JogaishaTorokuDiv
     * @return ResponseData<JogaishaTorokuDiv>
     */
    public ResponseData<JogaishaTorokuDiv> onActive(JogaishaTorokuDiv requestDiv) {
        TaishoshaKey key = ViewStateHolder.get(ViewStateKeys.資格対象者, TaishoshaKey.class);
        if (key == null || key.get識別コード() == null || key.get識別コード().isEmpty()) {
            return ResponseData.of(requestDiv).respond();
        }
        requestDiv.getJogaishaTorokuIchiran().getJogaiTaishoIchiran().getTxtShikibetsuCode().setDomain(key.get識別コード());
        getHandler(requestDiv).onFocus_shikibetsuCode();
        return ResponseData.of(requestDiv).respond();
    }

    /**
     * 追加ボタンを押下します。
     *
     * @param requestDiv JogaishaTorokuDiv
     * @return ResponseData<JogaishaTorokuDiv>
     */
    public ResponseData<JogaishaTorokuDiv> onClick_btnAdd(JogaishaTorokuDiv requestDiv) {
        getHandler(requestDiv).onClick_btnAdd();
        return ResponseData.of(requestDiv).setState(DBA1080011StateName.初期状態);
    }

    /**
     * 修正ボタンを押下します。
     *
     * @param requestDiv JogaishaTorokuDiv
     * @return ResponseData<JogaishaTorokuDiv>
     */
    public ResponseData<JogaishaTorokuDiv> onClick_btnUpda(JogaishaTorokuDiv requestDiv) {
        getHandler(requestDiv).onClick_btnUpda();
        return ResponseData.of(requestDiv).setState(DBA1080011StateName.初期状態);
    }

    /**
     * 削除ボタンを押下します。
     *
     * @param requestDiv JogaishaTorokuDiv
     * @return ResponseData<JogaishaTorokuDiv>
     */
    public ResponseData<JogaishaTorokuDiv> onClick_btnDele(JogaishaTorokuDiv requestDiv) {
        getHandler(requestDiv).onClick_btnDele();
        return ResponseData.of(requestDiv).setState(DBA1080011StateName.初期状態);
    }

    /**
     * 取消ボタンを押下します。
     *
     * @param requestDiv JogaishaTorokuDiv
     * @return ResponseData<JogaishaTorokuDiv>
     */
    public ResponseData<JogaishaTorokuDiv> onClick_btnCacel(JogaishaTorokuDiv requestDiv) {
        getHandler(requestDiv).onClick_btnCacel();
        return ResponseData.of(requestDiv).setState(DBA1080011StateName.初期状態);
    }

    /**
     * 確定ボタンを押下します。
     *
     * @param requestDiv JogaishaTorokuDiv
     * @return ResponseData<JogaishaTorokuDiv>
     */
    public ResponseData<JogaishaTorokuDiv> onClick_btnKaku(JogaishaTorokuDiv requestDiv) {
        ValidationMessageControlPairs validationMessageControlPairs = getHandler(requestDiv).validateCheck();
        if (validationMessageControlPairs.iterator().hasNext()) {
            return ResponseData.of(requestDiv).addValidationMessages(validationMessageControlPairs).respond();
        }
        getHandler(requestDiv).onClick_btnKaku();
        return ResponseData.of(requestDiv).setState(DBA1080011StateName.初期状態);
    }

    /**
     * 識別コードLostFocusです。
     *
     * @param requestDiv JogaishaTorokuDiv
     * @return ResponseData<JogaishaTorokuDiv>
     */
    public ResponseData<JogaishaTorokuDiv> onFocus_shikibetsuCode(JogaishaTorokuDiv requestDiv) {
        getHandler(requestDiv).onFocus_shikibetsuCode();
        return ResponseData.of(requestDiv).setState(DBA1080011StateName.初期状態);
    }

    /**
     * 識別対象検索ボタンを押下します。
     *
     * @param requestDiv JogaishaTorokuDiv
     * @return ResponseData<JogaishaTorokuDiv>
     */
    public ResponseData<JogaishaTorokuDiv> onClick_Search(JogaishaTorokuDiv requestDiv) {
        JogaishaTorokuSetter 除外者データ = getHandler(requestDiv).onClick_Search();
        ViewStateHolder.put(除外者データキー, 除外者データ);
        ViewStateHolder.put(資格取得除外者登録キー, new RString("DBA18001"));
        return ResponseData.of(requestDiv).setState(DBA1080011StateName.初期状態);
    }

    /**
     * 完了するボタンを押下します。
     *
     * @param requestDiv JogaishaTorokuDiv
     * @return ResponseData<JogaishaTorokuDiv>
     */
    public ResponseData<JogaishaTorokuDiv> onClick_btnComplete(JogaishaTorokuDiv requestDiv) {
        前排他処理();
        return ResponseData.of(requestDiv).setState(DBA1080011StateName.完了状態);
    }

    /**
     * 保存するボタン押下、データがDBに更新します。
     *
     * @param requestDiv JogaishaTorokuDiv
     * @return ResponseData<JogaishaTorokuDiv>
     */
    public ResponseData<JogaishaTorokuDiv> onClick_btnUpdate(JogaishaTorokuDiv requestDiv) {
        DataGrid<dgNenreiTotatshusha_Row> dg = requestDiv.getJogaishaTorokuIchiran().getNenreiTotatsh().getDgNenreiTotatshusha();
        List<dgNenreiTotatshusha_Row> dgRowList = dg.getDataSource();

        List<ShikakuShutokuJogaisha> deleteKuJogaishaList = new ArrayList<>();
        List<ShikakuShutokuJogaisha> updateKuJogaishaList = new ArrayList<>();
        List<ShikakuShutokuJogaisha> insertKuJogaishaList = new ArrayList<>();
        Models<ShikakuShutokuJogaishaIdentifier, ShikakuShutokuJogaisha> models
                = ViewStateHolder.get(ViewStateKeys.資格取得除外者一覧, Models.class);
        for (int i = 0; i < dgRowList.size(); i++) {
            dgNenreiTotatshusha_Row row = dgRowList.get(i);
            if (RowState.Deleted.equals(row.getRowState())) {
                deleteKuJogaishaList.add(createDeleteData(row, models));
            }
            if (RowState.Added.equals(row.getRowState())) {
                insertKuJogaishaList.add(createAddData(row));
                getHandler(requestDiv).アクセスログ(new ShikibetsuCode(row.getShikibetsuCode()));
            }
            if (RowState.Modified.equals(row.getRowState())) {
                updateKuJogaishaList.add(createModifyData(row, models));
                getHandler(requestDiv).アクセスログ(new ShikibetsuCode(row.getShikibetsuCode()));
            }
        }

        int dataSize = deleteKuJogaishaList.size() + insertKuJogaishaList.size() + updateKuJogaishaList.size();
        if (dataSize <= 0) {
            ValidationMessageControlPairs validationMessageControlPairs = getHandler(requestDiv).validate更新可能();
            return ResponseData.of(requestDiv).addValidationMessages(validationMessageControlPairs).respond();
        }
        ShikakuShutokuJogaishaKanriManager.createInstance().delShikakuShutokuJogaisha(deleteKuJogaishaList);
        ShikakuShutokuJogaishaKanriManager.createInstance().insertShikakuShutokuJogaisha(insertKuJogaishaList);
        ShikakuShutokuJogaishaKanriManager.createInstance().updateShikakuShutokuJogaisha(updateKuJogaishaList);
        前排他処理();

        requestDiv.getCcdKaigoKanryoMessage().setSuccessMessage(new RString(UrInformationMessages.保存終了.getMessage().evaluate()));
        return ResponseData.of(requestDiv).setState(DBA1080011StateName.完了状態);
    }

    private ShikakuShutokuJogaisha createDeleteData(dgNenreiTotatshusha_Row row, Models<ShikakuShutokuJogaishaIdentifier, ShikakuShutokuJogaisha> models) {

        ShikakuShutokuJogaishaIdentifier key = new ShikakuShutokuJogaishaIdentifier(new ShikibetsuCode(row.getShikibetsuCode()),
                Integer.parseInt(row.getRirekiNo().toString()));
        ShikakuShutokuJogaisha shikakuShutokuJogaisha = models.get(key);
        return shikakuShutokuJogaisha.deleted();
    }

    private ShikakuShutokuJogaisha createAddData(dgNenreiTotatshusha_Row row) {
        int 履歴番号 = ShikakuShutokuJogaishaKanriManager.createInstance()
                .select履歴番号(new ShikibetsuCode(row.getShikibetsuCode()));
        ShikakuShutokuJogaisha busniess = new ShikakuShutokuJogaisha(new ShikibetsuCode(row.getShikibetsuCode()),
                履歴番号);
        ShikakuShutokuJogaishaBuilder builder = busniess.createBuilderForEdit();
        builder.set市町村コード(new LasdecCode(row.getLasdecCode()));
        builder.set識別コード(new ShikibetsuCode(row.getShikibetsuCode()));
        builder.set資格取得除外年月日(row.getJogaiTekiyoDate().getValue() == null
                             ? FlexibleDate.EMPTY : new FlexibleDate(row.getJogaiTekiyoDate().getValue().toDateString()));
        builder.set資格取得除外理由(row.getJogaiRiyu());
        builder.set資格取得除外解除年月日(row.getJogaiKaijyoDate().getValue() == null
                               ? FlexibleDate.EMPTY : new FlexibleDate(row.getJogaiKaijyoDate().getValue().toDateString()));
        return builder.build();
    }

    private ShikakuShutokuJogaisha createModifyData(dgNenreiTotatshusha_Row row, Models<ShikakuShutokuJogaishaIdentifier, ShikakuShutokuJogaisha> models) {

        int 履歴番号 = Integer.parseInt(row.getRirekiNo().toString()); // + 1;
        ShikakuShutokuJogaishaIdentifier key = new ShikakuShutokuJogaishaIdentifier(new ShikibetsuCode(row.getShikibetsuCode()), 履歴番号);
        ShikakuShutokuJogaisha shikakuShutokuJogaisha = models.get(key);
        ShikakuShutokuJogaishaBuilder shikakubuilder = shikakuShutokuJogaisha.createBuilderForEdit();
        shikakubuilder.set履歴番号(履歴番号);
        shikakubuilder.set市町村コード(new LasdecCode(row.getLasdecCode()));
        shikakubuilder.set識別コード(new ShikibetsuCode(row.getShikibetsuCode()));
        shikakubuilder.set資格取得除外年月日(row.getJogaiTekiyoDate().getValue() == null
                                    ? FlexibleDate.EMPTY : new FlexibleDate(row.getJogaiTekiyoDate().getValue().toDateString()));
        shikakubuilder.set資格取得除外理由(row.getJogaiRiyu());
        shikakubuilder.set資格取得除外解除年月日(row.getJogaiKaijyoDate().getValue() == null
                                      ? FlexibleDate.EMPTY : new FlexibleDate(row.getJogaiKaijyoDate().getValue().toDateString()));
        shikakuShutokuJogaisha.toEntity().setState(EntityDataState.Modified);
        return shikakubuilder.build();
    }

    private void 前排他処理() {
        LockingKey lockingKey = new LockingKey(排他);
        RealInitialLocker.release(lockingKey);
    }

    //n8178 城間 仕様確認した結果、同一識別対象の資格除外情報で生きているデータは1件までしか存在しないため、この処理は不要になる。
//    private boolean 重複チェック(JogaishaTorokuDiv div) {
//        List<dgNenreiTotatshusha_Row> dgRowList = div.getJogaishaTorokuIchiran().getNenreiTotatsh().getDgNenreiTotatshusha().getDataSource();
//        List<ShikakuShutokuJogaisha> kuJogaishaList = new ArrayList<>();
//        for (int i = 0; i < dgRowList.size(); i++) {
//            if (RowState.Added.equals(dgRowList.get(i).getRowState()) || RowState.Modified.equals(dgRowList.get(i).getRowState())) {
//                ShikakuShutokuJogaisha busniess = new ShikakuShutokuJogaisha(new ShikibetsuCode(dgRowList.get(i).getShikibetsuCode()), i);
//                ShikakuShutokuJogaishaBuilder builder = busniess.createBuilderForEdit();
//                builder.set識別コード(new ShikibetsuCode(dgRowList.get(i).getShikibetsuCode()));
//                builder.set資格取得除外年月日(dgRowList.get(i).getJogaiTekiyoDate().getValue() == null
//                        ? FlexibleDate.EMPTY : new FlexibleDate(dgRowList.get(i).getJogaiTekiyoDate().getValue().toDateString()));
//                builder.set資格取得除外解除年月日(dgRowList.get(i).getJogaiKaijyoDate().getValue() == null
//                        ? FlexibleDate.EMPTY : new FlexibleDate(dgRowList.get(i).getJogaiKaijyoDate().getValue().toDateString()));
//                kuJogaishaList.add(builder.build());
//            }
//        }
//        return ShikakuShutokuJogaishaKanriManager.createInstance().jogaiKikanJufukuCheck(kuJogaishaList);
//    }
    private JogaishaTorokuHandler getHandler(JogaishaTorokuDiv requestDiv) {
        return new JogaishaTorokuHandler(requestDiv);
    }
}
