/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.dbamn00000;

import jp.co.ndensan.reams.db.dba.entity.dbamn00000.KaigoAtenaKihonEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 介護資格系基本情報Businessクラスです。
 */
public class KaigoAtenaKihonBusiness {

    private final KaigoAtenaKihonEntity entity;

    /**
     * コンストラクタです.
     *
     * @param entity KaigoAtenaKihonEntity
     */
    public KaigoAtenaKihonBusiness(KaigoAtenaKihonEntity entity) {
        this.entity = entity;
    }

    /**
     * 被保険者番号を取得します。
     *
     * @return 被保険者番号
     */
    public HihokenshaNo get被保険者番号() {
        return entity.getHihokenshaNo();
    }

    /**
     * 異動日を取得します。
     *
     * @return 異動日
     */
    public FlexibleDate get異動日() {
        return entity.getIdoYMD();
    }

    /**
     * 枝番を取得します。
     *
     * @return 枝番
     */
    public RString get枝番() {
        return entity.getEdaNo();
    }

    /**
     * 異動事由コードを取得します。
     *
     * @return 異動事由コード
     */
    public RString get異動事由コード() {
        return entity.getIdoJiyuCode();
    }

    /**
     * 市町村コードを取得します。
     *
     * @return 市町村コード
     */
    public LasdecCode get市町村コード() {
        return entity.getShichosonCode();
    }

    /**
     * 識別コードを取得します。
     *
     * @return 識別コード
     */
    public ShikibetsuCode get識別コード() {
        return entity.getShikibetsuCode();
    }

    /**
     * 資格取得事由コードを取得します。
     *
     * @return 資格取得事由コード
     */
    public RString get資格取得事由コード() {
        return entity.getShikakuShutokuJiyuCode();
    }

    /**
     * 資格取得年月日を取得します。
     *
     * @return 資格取得年月日
     */
    public FlexibleDate get資格取得年月日() {
        return entity.getShikakuShutokuYMD();
    }

    /**
     * 資格取得届出年月日を取得します。
     *
     * @return 資格取得届出年月日
     */
    public FlexibleDate get資格取得届出年月日() {
        return entity.getShikakuShutokuTodokedeYMD();
    }

    /**
     * 第1号資格取得年月日を取得します。
     *
     * @return 第1号資格取得年月日
     */
    public FlexibleDate get第1号資格取得年月日() {
        return entity.getIchigoShikakuShutokuYMD();
    }

    /**
     * 被保険者区分コードを取得します。
     *
     * @return 被保険者区分コード
     */
    public RString get被保険者区分コード() {
        return entity.getHihokennshaKubunCode();
    }

    /**
     * 資格喪失事由コードを取得します。
     *
     * @return 資格喪失事由コード
     */
    public RString get資格喪失事由コード() {
        return entity.getShikakuSoshitsuJiyuCode();
    }

    /**
     * 資格喪失年月日を取得します。
     *
     * @return 資格喪失年月日
     */
    public FlexibleDate get資格喪失年月日() {
        return entity.getShikakuSoshitsuYMD();
    }

    /**
     * 資格喪失届出年月日を取得します。
     *
     * @return 資格喪失届出年月日
     */
    public FlexibleDate get資格喪失届出年月日() {
        return entity.getShikakuSoshitsuTodokedeYMD();
    }

    /**
     * 資格変更事由コードを取得します。
     *
     * @return 資格変更事由コード
     */
    public RString get資格変更事由コード() {
        return entity.getShikakuHenkoJiyuCode();
    }

    /**
     * 資格変更年月日を取得します。
     *
     * @return 資格変更年月日
     */
    public FlexibleDate get資格変更年月日() {
        return entity.getShikakuHenkoYMD();
    }

    /**
     * 資格変更届出年月日を取得します。
     *
     * @return 資格変更届出年月日
     */
    public FlexibleDate get資格変更届出年月日() {
        return entity.getShikakuHenkoTodokedeYMD();
    }

    /**
     * 住所地特例適用事由コードを取得します。
     *
     * @return 住所地特例適用事由コード
     */
    public RString get住所地特例適用事由コード() {
        return entity.getJushochitokureiTekiyoJiyuCode();
    }

    /**
     * 適用年月日を取得します。
     *
     * @return 適用年月日
     */
    public FlexibleDate get適用年月日() {
        return entity.getJushochitokureiTekiyoYMD();
    }

    /**
     * 適用届出年月日を取得します。
     *
     * @return 適用届出年月日
     */
    public FlexibleDate get適用届出年月日() {
        return entity.getChitokureiTekiyoTodokedeYMD();
    }

    /**
     * 住所地特例解除事由コードを取得します。
     *
     * @return 住所地特例解除事由コード
     */
    public RString get住所地特例解除事由コード() {
        return entity.getJushochitokureiKaijoJiyuCode();
    }

    /**
     * 解除年月日を取得します。
     *
     * @return 解除年月日
     */
    public FlexibleDate get解除年月日() {
        return entity.getJushochitokureiKaijoYMD();
    }

    /**
     * 解除届出年月日を取得します。
     *
     * @return 解除届出年月日
     */
    public FlexibleDate get解除届出年月日() {
        return entity.getChitokureiKaijoTodokedeYMD();
    }

    /**
     * 住所地特例フラグを取得します。
     *
     * @return 住所地特例フラグ
     */
    public RString get住所地特例フラグ() {
        return entity.getJushochiTokureiFlag();
    }

    /**
     * 広域内住所地特例フラグを取得します。
     *
     * @return 広域内住所地特例フラグ
     */
    public RString get広域内住所地特例フラグ() {
        return entity.getKoikinaiJushochiTokureiFlag();
    }

    /**
     * 広住特措置元市町村コードを取得します。
     *
     * @return 広住特措置元市町村コード
     */
    public LasdecCode get広住特措置元市町村コード() {
        return entity.getTokureiSochimotoShichosonCode();
    }

    /**
     * 旧市町村コードを取得します。
     *
     * @return 旧市町村コード
     */
    public LasdecCode get旧市町村コード() {
        return entity.getKyuShichosonCode();
    }

    /**
     * 論理削除フラグを取得します。
     *
     * @return 論理削除フラグ
     */
    public boolean is論理削除フラグ() {
        return entity.isLogicalDeletedFlag();
    }

    /**
     * 要介護認定状態区分コードを取得します。
     *
     * @return 要介護認定状態区分コード
     */
    public Code get要介護認定状態区分コード() {
        return entity.getYokaigoJotaiKubunCode();
    }

    /**
     * 認定有効期間開始年月日を取得します。
     *
     * @return 認定有効期間開始年月日
     */
    public FlexibleDate get認定有効期間開始年月日() {
        return entity.getNinteiYukoKikanKaishiYMD();
    }

    /**
     * 認定有効期間終了年月日を取得します。
     *
     * @return 認定有効期間終了年月日
     */
    public FlexibleDate get認定有効期間終了年月日() {
        return entity.getNinteiYukoKikanShuryoYMD();
    }

    /**
     * 認定年月日を取得します。
     *
     * @return 認定年月日
     */
    public FlexibleDate get認定年月日() {
        return entity.getNinteiYMD();
    }
}
