/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.createtarget;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.createtarget.CreateTargetRelateEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * センター送信データ出力情報ビジネスクラスです。
 *
 * @reamsid_L DBE-1680-010 zhangzhiming
 */
public class CreateTargetBusiness {

    private final CreateTargetRelateEntity entity;

    /**
     * コンストラクタです。<br/>
     * センター送信情報Entityビジネスの新規作成時に使用します。
     *
     * @param entity センター送信情報Entityクラスです。
     */
    public CreateTargetBusiness(CreateTargetRelateEntity entity) {
        requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("センター送信情報Entity"));
        this.entity = entity;
    }

    /**
     * 証記載保険者番号を返します。
     *
     * @return 証記載保険者番号
     */
    public RString get証記載保険者番号() {
        return entity.get証記載保険者番号();
    }

    /**
     * 市町村名称を返します。
     *
     * @return 市町村名称
     */
    public RString get市町村名称() {
        return entity.get市町村名称();
    }

    /**
     * 被保険者番号を返します。
     *
     * @return 被保険者番号
     */
    public RString get被保険者番号() {
        return entity.get被保険者番号();
    }

    /**
     * 被保険者氏名を返します。
     *
     * @return 被保険者氏名
     */
    public AtenaMeisho get被保険者氏名() {
        return entity.get被保険者氏名();
    }

    /**
     * 被保険者氏名カナを返します。
     *
     * @return 被保険者氏名カナ
     */
    public AtenaKanaMeisho get被保険者氏名カナ() {
        return entity.get被保険者氏名カナ();
    }

    /**
     * 性別を返します。
     *
     * @return 性別
     */
    public Code get性別() {
        return entity.get性別();
    }

    /**
     * 生年月日を返します。
     *
     * @return 生年月日
     */
    public FlexibleDate get生年月日() {
        return entity.get生年月日();
    }

    /**
     * 認定申請年月日を返します。
     *
     * @return 認定申請年月日
     */
    public FlexibleDate get認定申請年月日() {
        return entity.get認定申請年月日();
    }

    /**
     * 認定申請区分_申請時コードを返します。
     *
     * @return 認定申請区分_申請時コード
     */
    public Code get認定申請区分_申請時コード() {
        return entity.get認定申請区分_申請時コード();
    }

    /**
     * 認定申請区分_法令コードを返します。
     *
     * @return 認定申請区分_法令コード
     */
    public Code get認定申請区分_法令コード() {
        return entity.get認定申請区分_法令コード();
    }

    /**
     * 申請書管理番号を返します。
     *
     * @return 申請書管理番号
     */
    public RString get申請書管理番号() {
        return entity.get申請書管理番号();
    }

    /**
     * 厚労省IF識別コードを返します。
     *
     * @return 厚労省IF識別コード
     */
    public Code get厚労省IF識別コード() {
        return entity.get厚労省IF識別コード();
    }

    /**
     * 送信年月日を返します。
     *
     * @return 送信年月日
     */
    public FlexibleDate get送信年月日() {
        return entity.get送信年月日();
    }

    /**
     * 状態区分コードを返します。
     *
     * @return 状態区分コード
     */
    public RString get状態区分コード() {
        return entity.get状態区分コード();
    }

    /**
     * 認定有効期間を返します。
     *
     * @return 認定有効期間
     */
    public int get認定有効期間() {
        return entity.get認定有効期間();
    }

    /**
     * 認定有効開始年月日を返します。
     *
     * @return 認定有効開始年月日
     */
    public FlexibleDate get認定有効開始年月日() {
        return entity.get認定有効開始年月日();
    }

    /**
     * 認定有効終了年月日を返します。
     *
     * @return 認定有効終了年月日
     */
    public FlexibleDate get認定有効終了年月日() {
        return entity.get認定有効終了年月日();
    }

    /**
     * 連番を返します。
     *
     * @return 連番
     */
    public int get連番() {
        return entity.get連番();
    }

    /**
     * 項目を返します。
     *
     * @return 項目
     */
    public RString get項目() {
        return entity.get項目();
    }
}
