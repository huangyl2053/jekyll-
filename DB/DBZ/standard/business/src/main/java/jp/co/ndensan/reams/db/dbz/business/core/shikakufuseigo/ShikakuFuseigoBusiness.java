/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.shikakufuseigo;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.db.relate.shikakufuseigo.ShikakuFuseigoEntity;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.ShikibetsuTaishoFactory;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.kojin.IKojin;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 資格不整合一覧情報のBusinessクラスです。
 *
 * @reamsid_L DBB-0630-020 chengsanyuan
 */
public class ShikakuFuseigoBusiness {

    private final ShikakuFuseigoEntity entity;

    /**
     * コンストラクタです.
     *
     * @param entity ShikakuFuseigoEntity
     */
    public ShikakuFuseigoBusiness(ShikakuFuseigoEntity entity) {
        this.entity = entity;
    }

    /**
     * 対象外フラグを返します。
     *
     * @return 対象外フラグ
     */
    public boolean is対象外フラグ() {
        return entity.getDbt1014Entity().getTaishogaiFlag();
    }

    /**
     * 被保険者番号を返します。
     *
     * @return 被保険者番号
     */
    public HihokenshaNo get被保険者番号() {
        return entity.getDbt1014Entity().getHihokenshaNo();
    }

    /**
     * 識別コードを返します。
     *
     * @return 識別コード
     */
    public ShikibetsuCode get識別コード() {
        return entity.getDbt1014Entity().getShikibetsuCode();
    }

    /**
     * 生年月日を返します。
     *
     * @return 生年月日
     */
    public FlexibleDate get生年月日() {
        return entity.getDbt1014Entity().getSeinengappiYMD();
    }

    /**
     * 不整合理由コードを返します。
     *
     * @return 不整合理由コード
     */
    public RString get不整合理由コード() {
        return entity.getDbt1014Entity().getFuseigoRiyuCode();
    }

    /**
     * 住民状態を返します。
     *
     * @return 住民状態
     */
    public RString get住民状態() {
        return ShikibetsuTaishoFactory.createKojin(entity.getFt200Entity()).get住民状態().住民状態略称();
    }

    /**
     * 氏名カナを返します。
     *
     * @return 氏名カナ
     */
    public AtenaKanaMeisho 氏名カナ() {
        IKojin 個人情報 = ShikibetsuTaishoFactory.createKojin(entity.getFt200Entity());
        if (個人情報.is外国人()) {
            return 個人情報.get外国人氏名().get外国人氏名カナ();
        }
        return 個人情報.get日本人氏名().getKana();
    }

    /**
     * 氏名を返します。
     *
     * @return 氏名
     */
    public AtenaMeisho 氏名() {
        IKojin 個人情報 = ShikibetsuTaishoFactory.createKojin(entity.getFt200Entity());
        if (個人情報.is外国人()) {
            return 個人情報.get外国人氏名().get通称名();
        }
        return 個人情報.get日本人氏名().getName();
    }

    /**
     * 性別を返します。
     *
     * @return 性別
     */
    public RString 性別() {
        IKojin 個人情報 = ShikibetsuTaishoFactory.createKojin(entity.getFt200Entity());
        return 個人情報.get性別().getCommonName();
    }

    /**
     * 年齢を返します。
     *
     * @return 年齢
     */
    public RString 年齢() {
        IKojin 個人情報 = ShikibetsuTaishoFactory.createKojin(entity.getFt200Entity());
        return 個人情報.get年齢算出().get年齢();
    }

    /**
     * is日本人を返します。
     *
     * @return TRUE:日本人 FALSE:外国人
     */
    public boolean is日本人() {
        IKojin 個人情報 = ShikibetsuTaishoFactory.createKojin(entity.getFt200Entity());
        return 個人情報.is日本人();
    }
}
