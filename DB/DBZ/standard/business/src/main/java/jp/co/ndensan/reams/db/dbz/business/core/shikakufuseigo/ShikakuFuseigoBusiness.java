/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.shikakufuseigo;

import java.io.Serializable;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.business.core.basic.SeigoseiCheck;
import jp.co.ndensan.reams.db.dbz.entity.db.relate.shikakufuseigo.ShikakuFuseigoEntity;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.ShikibetsuTaishoFactory;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.kojin.IKojin;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 資格不整合一覧情報のBusinessクラスです。
 *
 * @reamsid_L DBB-0630-020 chengsanyuan
 */
public class ShikakuFuseigoBusiness implements Serializable {

    private static final long serialVersionUID = 442215077353059054L;

    private final SeigoseiCheck 不整合チェック;
    private final IKojin 個人情報;

    /**
     * コンストラクタです.
     *
     * @param entity ShikakuFuseigoEntity
     */
    public ShikakuFuseigoBusiness(ShikakuFuseigoEntity entity) {
        entity.getDbt1014Entity().initializeMd5();
        this.不整合チェック = new SeigoseiCheck(entity.getDbt1014Entity());
        this.個人情報 = ShikibetsuTaishoFactory.createKojin(entity.getFt200Entity());
    }

    /**
     * 対象外フラグを返します。
     *
     * @return 対象外フラグ
     */
    public boolean is対象外フラグ() {
        return 不整合チェック.is対象外フラグ();
    }

    /**
     * 被保険者番号を返します。
     *
     * @return 被保険者番号
     */
    public HihokenshaNo get被保険者番号() {
        return 不整合チェック.get被保険者番号();
    }

    /**
     * 識別コードを返します。
     *
     * @return 識別コード
     */
    public ShikibetsuCode get識別コード() {
        return 不整合チェック.get識別コード();
    }

    /**
     * 生年月日を返します。
     *
     * @return 生年月日
     */
    public FlexibleDate get生年月日() {
        return 不整合チェック.get生年月日();
    }

    /**
     * 不整合理由コードを返します。
     *
     * @return 不整合理由コード
     */
    public RString get不整合理由コード() {
        return 不整合チェック.get不整合理由コード();
    }

    /**
     * 住民状態を返します。
     *
     * @return 住民状態
     */
    public RString get住民状態() {
        return 個人情報.get住民状態().住民状態略称();
    }

    /**
     * 氏名カナを返します。
     *
     * @return 氏名カナ
     */
    public AtenaKanaMeisho get氏名カナ() {
        if (個人情報.is外国人()) {
            return nullToEmptyForKana(個人情報.get外国人氏名().getKana());
        }
        return nullToEmptyForKana(個人情報.get日本人氏名().getKana());
    }

    /**
     * 氏名を返します。
     *
     * @return 氏名
     */
    public AtenaMeisho get氏名() {
        if (個人情報.is外国人()) {
            return nullToEmpty(個人情報.get外国人氏名().getName());
        }
        return nullToEmpty(個人情報.get日本人氏名().getName());
    }

    /**
     * 性別を返します。
     *
     * @return 性別
     */
    public RString get性別() {
        return 個人情報.get性別().getCommonName();
    }

    /**
     * 年齢を返します。
     *
     * @return 年齢
     */
    public RString get年齢() {
        return 個人情報.get年齢算出().get年齢();
    }

    /**
     * is日本人を返します。
     *
     * @return TRUE:日本人 FALSE:外国人
     */
    public boolean is日本人() {
        return 個人情報.is日本人();
    }

    /**
     * 処理日時を返します。
     *
     * @return 処理日時
     */
    public RDateTime get処理日時() {
        return 不整合チェック.get登録日時();
    }

    /**
     * 台帳種別を返します。
     *
     * @return 台帳種別
     */
    public RString get台帳種別() {
        return 不整合チェック.get台帳種別();
    }

    /**
     * 個人情報を返します。
     *
     * @return 個人情報
     */
    public IKojin get個人情報() {
        return 個人情報;
    }

    /**
     * 整合性チェック情報を返します。
     *
     * @return 整合性チェック情報
     */
    public SeigoseiCheck get整合性チェック情報() {
        return 不整合チェック;
    }

    private AtenaKanaMeisho nullToEmptyForKana(AtenaKanaMeisho 氏名カナ) {
        if (氏名カナ == null) {
            return AtenaKanaMeisho.EMPTY;
        }
        return 氏名カナ;
    }

    private AtenaMeisho nullToEmpty(AtenaMeisho 氏名) {
        if (氏名 == null) {
            return AtenaMeisho.EMPTY;
        }
        return 氏名;
    }
}
