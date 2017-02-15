/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.db.relate.shinsakaikekkatoroku;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.CheckForNull;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5116IchijiHanteiKekkaJohoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5201NinteichosaIraiJohoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5301ShujiiIkenshoIraiJohoEntity;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;

/**
 * 審査会結果登録処理で、判定結果により、対象者の関連情報を削除する場合があります。その際に、削除の候補となる要素を保持します。
 */
@lombok.Setter
public class ShinsakaiKekkaTorokuDeletionCandidateEntity {

    @lombok.Getter
    private ShinseishoKanriNo shinseishoKanriNo;
    @lombok.Getter
    private RDateTime sharedFileID;
    private List<DbT5201NinteichosaIraiJohoEntity> chosaIrai;
    private List<DbT5301ShujiiIkenshoIraiJohoEntity> ikenshoIrai;
    private List<DbT5116IchijiHanteiKekkaJohoEntity> ichijiHantei;

    public ShinsakaiKekkaTorokuDeletionCandidateEntity() {
        this.shinseishoKanriNo = ShinseishoKanriNo.EMPTY;
        this.sharedFileID = null;
        this.chosaIrai = new ArrayList<>();
        this.ikenshoIrai = new ArrayList<>();
        this.ichijiHantei = new ArrayList<>();
    }

    /**
     * @return 調査依頼
     */
    @CheckForNull
    public DbT5201NinteichosaIraiJohoEntity getChosaIraiEntity() {
        return this.chosaIrai.isEmpty() ? null : this.chosaIrai.get(0);
    }

    /**
     * @return 意見書依頼
     */
    @CheckForNull
    public DbT5301ShujiiIkenshoIraiJohoEntity getIkenshoIraiEntity() {
        return this.ikenshoIrai.isEmpty() ? null : this.ikenshoIrai.get(0);
    }

    /**
     * @return 一次判定
     */
    @CheckForNull
    public DbT5116IchijiHanteiKekkaJohoEntity getIchijiHanteiEntity() {
        return this.ichijiHantei.isEmpty() ? null : this.ichijiHantei.get(0);
    }
}
