/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE1030001;

import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE1030001.KanryoShoriShinsaUketsukeDiv;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.business.core.NinteiKanryoJoho;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 完了処理・審査受付のHandlerクラスです。
 *
 * @reamsid_L DBE-2060-010 wangrenze
 */
public class KanryoShoriShinsaUketsukeHandler {

    private static final RString 審査受付モード = new RString("審査受付モード");
    private final KanryoShoriShinsaUketsukeDiv div;

    /**
     * コンストラクタです。
     *
     * @param div KanryoShoriShinsaUketsukeDiv
     */
    public KanryoShoriShinsaUketsukeHandler(KanryoShoriShinsaUketsukeDiv div) {
        this.div = div;
    }

    /**
     * 完了処理・審査受付の初期化です。
     *
     */
    public void initialize() {
        div.getCcdNinteiTaskList().initialize(審査受付モード);
    }

    /**
     * 要介護認定完了情報追加の処理です。
     *
     * @param 申請書管理番号 RString
     * @return NinteiKanryoJoho
     */
    public NinteiKanryoJoho 要介護認定完了情報が追加(RString 申請書管理番号) {
        NinteiKanryoJoho ninteiKanryoJoho = new NinteiKanryoJoho(new ShinseishoKanriNo(申請書管理番号));
        return ninteiKanryoJoho.createBuilderForEdit().set認定申請情報登録完了年月日(FlexibleDate.getNowDate()).build();
    }

    /**
     * 要介護認定完了情報更新の処理です。
     *
     * @param ninteiKanryoJoho NinteiKanryoJoho
     * @return NinteiKanryoJoho
     */
    public NinteiKanryoJoho 要介護認定完了情報更新(NinteiKanryoJoho ninteiKanryoJoho) {

        return ninteiKanryoJoho.createBuilderForEdit().set認定申請情報登録完了年月日(FlexibleDate.getNowDate()).build();
    }

}
