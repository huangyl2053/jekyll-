/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.db.relate.shinsakaikekkatoroku;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.CheckForNull;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5116IchijiHanteiKekkaJohoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5201NinteichosaIraiJohoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5301ShujiiIkenshoIraiJohoEntity;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;

/**
 * 審査会結果登録処理で、判定結果により、対象者の関連情報を削除する場合があります。その際に、削除の候補となる要素を保持します。
 */
@lombok.Setter
public class ShinsakaiKekkaTorokuDeletionCandidateEntity implements Serializable {

    @lombok.Getter
    private ShinseishoKanriNo shinseishoKanriNo;
    @lombok.Getter
    private RString shoKaisaiHokenshaNo;
    @lombok.Getter
    private RString hihokenshaNo;
    @lombok.Getter
    private RDateTime sharedFileID;
    private List<DbT5201NinteichosaIraiJohoEntity> chosaIrai;
    private List<DbT5301ShujiiIkenshoIraiJohoEntity> ikenshoIrai;
    private List<DbT5116IchijiHanteiKekkaJohoEntity> ichijiHantei;

    public ShinsakaiKekkaTorokuDeletionCandidateEntity() {
        this.shinseishoKanriNo = ShinseishoKanriNo.EMPTY;
        this.shoKaisaiHokenshaNo = RString.EMPTY;
        this.hihokenshaNo = RString.EMPTY;
        this.sharedFileID = null;
        this.chosaIrai = new ArrayList<>();
        this.ikenshoIrai = new ArrayList<>();
        this.ichijiHantei = new ArrayList<>();
    }

    /**
     * @param other
     * 内容をコピーする元の{@link ShinsakaiKekkaTorokuDeletionCandidateEntity}
     */
    public void shallowCopy(ShinsakaiKekkaTorokuDeletionCandidateEntity other) {
        setShinseishoKanriNo(other.shinseishoKanriNo);
        setShoKaisaiHokenshaNo(other.shoKaisaiHokenshaNo);
        setHihokenshaNo(other.hihokenshaNo);
        setSharedFileID(other.sharedFileID);
        setChosaIrai(new ArrayList<>(other.chosaIrai));
        setIkenshoIrai(new ArrayList<>(other.ikenshoIrai));
        setIchijiHantei(new ArrayList<>(other.ichijiHantei));
    }

    /**
     * ハッシュを再計算します。
     */
    public void initMd5() {
        initMd5(this.chosaIrai);
        initMd5(this.ikenshoIrai);
        initMd5(this.ichijiHantei);
    }

    private static <T extends DbTableEntityBase> void initMd5(List<? extends T> list) {
        for (T t : list) {
            t.initializeMd5();
        }
    }

    /**
     * @return 調査依頼
     */
    @CheckForNull
    public DbT5201NinteichosaIraiJohoEntity getChosaIraiEntity() {
        DbT5201NinteichosaIraiJohoEntity e = getFirstOrNull(this.chosaIrai);
        if (e == null || e.getKoroshoIfShikibetsuCode() == null) {
            return null;
        }
        return e;
    }

    private static <T extends DbTableEntityBase> T getFirstOrNull(List<? extends T> list) {
        return list.isEmpty() ? null : list.get(0);
    }

    /**
     * @return 意見書依頼
     */
    @CheckForNull
    public DbT5301ShujiiIkenshoIraiJohoEntity getIkenshoIraiEntity() {
        DbT5301ShujiiIkenshoIraiJohoEntity e = getFirstOrNull(this.ikenshoIrai);
        if (e == null || e.getKoroshoIfShikibetsuCode() == null) {
            return null;
        }
        return e;
    }

    /**
     * @return 一次判定
     */
    @CheckForNull
    public DbT5116IchijiHanteiKekkaJohoEntity getIchijiHanteiEntity() {
        DbT5116IchijiHanteiKekkaJohoEntity e = getFirstOrNull(this.ichijiHantei);
        if (e == null || e.getIchijiHanteiKekkaCode() == null) {
            return null;
        }
        return e;
    }
}
