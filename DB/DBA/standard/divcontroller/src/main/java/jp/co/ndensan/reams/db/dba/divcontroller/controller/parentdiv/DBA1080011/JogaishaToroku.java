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
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.exclusion.LockingKey;
import jp.co.ndensan.reams.uz.uza.exclusion.RealInitialLocker;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
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
        List<dgNenreiTotatshusha_Row> dgRowList = requestDiv.getJogaishaTorokuIchiran().getNenreiTotatsh().getDgNenreiTotatshusha().getDataSource();
        if (重複チェック(requestDiv)) {
            ValidationMessageControlPairs validationMessageControlPairs = getHandler(requestDiv).juufukuCheck();
            return ResponseData.of(requestDiv).addValidationMessages(validationMessageControlPairs).respond();
        }
        List<ShikakuShutokuJogaisha> deleteKuJogaishaList = new ArrayList<>();
        List<ShikakuShutokuJogaisha> updateKuJogaishaList = new ArrayList<>();
        List<ShikakuShutokuJogaisha> insertKuJogaishaList = new ArrayList<>();
        Models<ShikakuShutokuJogaishaIdentifier, ShikakuShutokuJogaisha> models
                = ViewStateHolder.get(ViewStateKeys.資格取得除外者一覧, Models.class);
        for (int i = 0; i < dgRowList.size(); i++) {
            if (RowState.Deleted.equals(dgRowList.get(i).getRowState())) {
                ShikakuShutokuJogaishaIdentifier key = new ShikakuShutokuJogaishaIdentifier(new ShikibetsuCode(dgRowList.get(i).getShikibetsuCode()),
                        Integer.parseInt(dgRowList.get(i).getRirekiNo().toString()));
                ShikakuShutokuJogaisha shikakuShutokuJogaisha = models.get(key);
                shikakuShutokuJogaisha.toEntity().setState(EntityDataState.Deleted);
                deleteKuJogaishaList.add(shikakuShutokuJogaisha);
            }
            if (RowState.Added.equals(dgRowList.get(i).getRowState())) {
                int 履歴番号 = ShikakuShutokuJogaishaKanriManager.createInstance()
                        .select履歴番号(new ShikibetsuCode(dgRowList.get(i).getShikibetsuCode()));
                ShikakuShutokuJogaisha busniess = new ShikakuShutokuJogaisha(new ShikibetsuCode(dgRowList.get(i).getShikibetsuCode()),
                        履歴番号);
                ShikakuShutokuJogaishaBuilder builder = busniess.createBuilderForEdit();
                builder.set市町村コード(new LasdecCode(dgRowList.get(i).getLasdecCode()));
                builder.set識別コード(new ShikibetsuCode(dgRowList.get(i).getShikibetsuCode()));
                builder.set資格取得除外年月日(dgRowList.get(i).getJogaiTekiyoDate().getValue() == null
                        ? FlexibleDate.EMPTY : new FlexibleDate(dgRowList.get(i).getJogaiTekiyoDate().getValue().toDateString()));
                builder.set資格取得除外理由(dgRowList.get(i).getJogaiRiyu());
                builder.set資格取得除外解除年月日(dgRowList.get(i).getJogaiKaijyoDate().getValue() == null
                        ? FlexibleDate.EMPTY : new FlexibleDate(dgRowList.get(i).getJogaiKaijyoDate().getValue().toDateString()));
                insertKuJogaishaList.add(builder.build());
                getHandler(requestDiv).アクセスログ(new ShikibetsuCode(dgRowList.get(i).getShikibetsuCode()));
            }
            if (RowState.Modified.equals(dgRowList.get(i).getRowState())) {
                ShikakuShutokuJogaishaIdentifier key = new ShikakuShutokuJogaishaIdentifier(new ShikibetsuCode(dgRowList.get(i).getShikibetsuCode()),
                        Integer.parseInt(dgRowList.get(i).getRirekiNo().toString()));
                ShikakuShutokuJogaisha shikakuShutokuJogaisha = models.get(key);
                ShikakuShutokuJogaishaBuilder shikakubuilder = shikakuShutokuJogaisha.createBuilderForEdit();
                shikakubuilder.set市町村コード(new LasdecCode(dgRowList.get(i).getLasdecCode()));
                shikakubuilder.set識別コード(new ShikibetsuCode(dgRowList.get(i).getShikibetsuCode()));
                shikakubuilder.set資格取得除外年月日(dgRowList.get(i).getJogaiTekiyoDate().getValue() == null
                        ? FlexibleDate.EMPTY : new FlexibleDate(dgRowList.get(i).getJogaiTekiyoDate().getValue().toDateString()));
                shikakubuilder.set資格取得除外理由(dgRowList.get(i).getJogaiRiyu());
                shikakubuilder.set資格取得除外解除年月日(dgRowList.get(i).getJogaiKaijyoDate().getValue() == null
                        ? FlexibleDate.EMPTY : new FlexibleDate(dgRowList.get(i).getJogaiKaijyoDate().getValue().toDateString()));
                shikakubuilder.set履歴番号(Integer.parseInt(dgRowList.get(i).getRirekiNo().toString()));
                shikakuShutokuJogaisha.toEntity().setState(EntityDataState.Modified);
                updateKuJogaishaList.add(shikakubuilder.build());
                getHandler(requestDiv).アクセスログ(new ShikibetsuCode(dgRowList.get(i).getShikibetsuCode()));
            }
        }
        ShikakuShutokuJogaishaKanriManager.createInstance().delShikakuShutokuJogaisha(deleteKuJogaishaList);
        ShikakuShutokuJogaishaKanriManager.createInstance().insertShikakuShutokuJogaisha(insertKuJogaishaList);
        ShikakuShutokuJogaishaKanriManager.createInstance().updateShikakuShutokuJogaisha(updateKuJogaishaList);
        前排他処理();
        return ResponseData.of(requestDiv).setState(DBA1080011StateName.完了状態);
    }

    private void 前排他処理() {
        LockingKey lockingKey = new LockingKey(排他);
        RealInitialLocker.release(lockingKey);
    }

    private boolean 重複チェック(JogaishaTorokuDiv div) {
        List<dgNenreiTotatshusha_Row> dgRowList = div.getJogaishaTorokuIchiran().getNenreiTotatsh().getDgNenreiTotatshusha().getDataSource();
        List<ShikakuShutokuJogaisha> kuJogaishaList = new ArrayList<>();
        for (int i = 0; i < dgRowList.size(); i++) {
            if (RowState.Added.equals(dgRowList.get(i).getRowState()) || RowState.Modified.equals(dgRowList.get(i).getRowState())) {
                ShikakuShutokuJogaisha busniess = new ShikakuShutokuJogaisha(new ShikibetsuCode(dgRowList.get(i).getShikibetsuCode()), i);
                ShikakuShutokuJogaishaBuilder builder = busniess.createBuilderForEdit();
                builder.set識別コード(new ShikibetsuCode(dgRowList.get(i).getShikibetsuCode()));
                builder.set資格取得除外年月日(dgRowList.get(i).getJogaiTekiyoDate().getValue() == null
                        ? FlexibleDate.EMPTY : new FlexibleDate(dgRowList.get(i).getJogaiTekiyoDate().getValue().toDateString()));
                builder.set資格取得除外解除年月日(dgRowList.get(i).getJogaiKaijyoDate().getValue() == null
                        ? FlexibleDate.EMPTY : new FlexibleDate(dgRowList.get(i).getJogaiKaijyoDate().getValue().toDateString()));
                kuJogaishaList.add(builder.build());
            }
        }
        return ShikakuShutokuJogaishaKanriManager.createInstance().jogaiKikanJufukuCheck(kuJogaishaList);
    }

    private JogaishaTorokuHandler getHandler(JogaishaTorokuDiv requestDiv) {
        return new JogaishaTorokuHandler(requestDiv);
    }
}
