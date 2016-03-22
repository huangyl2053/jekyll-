/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.divcontroller.controller.parentdiv.DBA1080011;

import java.util.List;
import jp.co.ndensan.reams.db.dba.business.core.shikakushutokujogaishakanri.ShikakuShutokuJogaishaKanri;
import static jp.co.ndensan.reams.db.dba.definition.enumeratedtype.config.ConfigKeysJukyuShikakuShomeishoHakko.資格取得除外者登録キー;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.parentdiv.DBA1080011.DBA1080011StateName;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.parentdiv.DBA1080011.JogaishaTorokuDiv;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.parentdiv.DBA1080011.dgNenreiTotatshusha_Row;
import jp.co.ndensan.reams.db.dba.divcontroller.handler.parentdiv.DBA1080011.JogaishaTorokuHandler;
import jp.co.ndensan.reams.db.dba.service.core.shikakushutokujogaishakanri.ShikakuShutokuJogaishaKanriManager;
import jp.co.ndensan.reams.db.dbz.business.core.ShikakuShutokuJogaisha;
import jp.co.ndensan.reams.db.dbz.business.core.ShikakuShutokuJogaishaBuilder;
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
import jp.co.ndensan.reams.uz.uza.util.db.SearchResult;

/**
 *
 * 資格取得除外者登録のクラス。
 */
public class JogaishaToroku {

    /**
     * 資格取得除外者登録の初期化。<br/>
     *
     * @param requestDiv JogaishaTorokuDiv
     * @return ResponseData<JogaishaTorokuDiv>
     */
    public ResponseData<JogaishaTorokuDiv> onLoad(JogaishaTorokuDiv requestDiv) {

        if (ViewStateHolder.get(資格取得除外者登録キー, RString.class) == null || ViewStateHolder.get(資格取得除外者登録キー, RString.class).isEmpty()) {
            SearchResult<ShikakuShutokuJogaishaKanri> 資格取得除外者情報
                    = ShikakuShutokuJogaishaKanriManager.createInstance().getTennyuHoryuTokuteiJushoIchiran();
            getHandler(requestDiv).onLoad(資格取得除外者情報.records());
        } else {
            getHandler(requestDiv).onLoadKen();
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
        getHandler(requestDiv).onClick_btnKaku();
        return ResponseData.of(requestDiv).setState(DBA1080011StateName.初期状態);
    }

    /**
     * 識別コードLostFocusする。
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
        getHandler(requestDiv).onClick_Search();
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
            ValidationMessageControlPairs validationMessageControlPairs = getHandler(requestDiv).validateCheck();
            return ResponseData.of(requestDiv).addValidationMessages(validationMessageControlPairs).respond();
        }
        for (int i = 0; i < dgRowList.size(); i++) {
            ShikakuShutokuJogaisha busniess = new ShikakuShutokuJogaisha(new ShikibetsuCode(dgRowList.get(i).getShikibetsuCode()),
                    Integer.parseInt(dgRowList.get(i).getRirekiNo().toString()));
            ShikakuShutokuJogaishaBuilder builder = busniess.createBuilderForEdit();
            builder.set市町村コード(new LasdecCode(dgRowList.get(i).getLasdecCode()));
            builder.set識別コード(new ShikibetsuCode(dgRowList.get(i).getShikibetsuCode()));
            builder.set資格取得除外年月日(dgRowList.get(i).getJogaiTekiyoDate().getValue() == null
                    ? FlexibleDate.EMPTY : new FlexibleDate(dgRowList.get(i).getJogaiTekiyoDate().getValue().toDateString()));
            builder.set資格取得除外理由(dgRowList.get(i).getJogaiRiyu());
            builder.set資格取得除外解除年月日(dgRowList.get(i).getJogaiKaijyoDate().getValue() == null
                    ? FlexibleDate.EMPTY : new FlexibleDate(dgRowList.get(i).getJogaiKaijyoDate().getValue().toDateString()));
            if (RowState.Deleted.equals(dgRowList.get(i).getRowState())) {
                builder.set履歴番号(Integer.parseInt(dgRowList.get(i).getRirekiNo().toString()));
                ShikakuShutokuJogaishaKanriManager.createInstance().delShikakuShutokuJogaisha(builder.build().toEntity());
            }
            if (RowState.Added.equals(dgRowList.get(i).getRowState())) {
                ShikakuShutokuJogaishaKanriManager.createInstance().insertShikakuShutokuJogaisha(builder.build().toEntity());
            }
            if (RowState.Modified.equals(dgRowList.get(i).getRowState())) {
                builder.set履歴番号(Integer.parseInt(dgRowList.get(i).getRirekiNo().toString()));
                ShikakuShutokuJogaishaKanriManager.createInstance().updateShikakuShutokuJogaisha(builder.build().toEntity());
            }
        }
        前排他処理();
        return ResponseData.of(requestDiv).setState(DBA1080011StateName.完了状態);
    }

    private void 前排他処理() {
        LockingKey lockingKey = new LockingKey(new RString("ShikakuShutokuJogaishaToroku"));
        RealInitialLocker.release(lockingKey);
    }

    private boolean 重複チェック(JogaishaTorokuDiv div) {
        List<dgNenreiTotatshusha_Row> dgRowList = div.getJogaishaTorokuIchiran().getNenreiTotatsh().getDgNenreiTotatshusha().getDataSource();
        for (int i = 0; i < dgRowList.size(); i++) {
            if (RowState.Deleted.equals(dgRowList.get(i).getRowState())) {
                continue;
            }
            ShikakuShutokuJogaisha busniess = new ShikakuShutokuJogaisha(new ShikibetsuCode(dgRowList.get(i).getShikibetsuCode()),
                    Integer.parseInt(dgRowList.get(i).getRirekiNo().toString()));
            ShikakuShutokuJogaishaBuilder builder = busniess.createBuilderForEdit();
            builder.set識別コード(new ShikibetsuCode(dgRowList.get(i).getShikibetsuCode()));
            builder.set資格取得除外年月日(dgRowList.get(i).getJogaiTekiyoDate().getValue() == null
                    ? FlexibleDate.EMPTY : new FlexibleDate(dgRowList.get(i).getJogaiTekiyoDate().getValue().toDateString()));
            builder.set資格取得除外解除年月日(dgRowList.get(i).getJogaiKaijyoDate().getValue() == null
                    ? FlexibleDate.EMPTY : new FlexibleDate(dgRowList.get(i).getJogaiKaijyoDate().getValue().toDateString()));
            boolean flag = ShikakuShutokuJogaishaKanriManager.createInstance().jogaiKikanJufukuCheck(builder.build().toEntity());
            if (flag) {
                return true;
            }
        }
        return false;
    }

    private JogaishaTorokuHandler getHandler(JogaishaTorokuDiv requestDiv) {
        return new JogaishaTorokuHandler(requestDiv);
    }
}
