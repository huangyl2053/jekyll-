/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.business.core.basic;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbx.entity.basic.DbT7064CareManegerEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.KaigoJigyoshaNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * {@link CareManeger}の編集を行うビルダークラスです。
 */
public class CareManegerBuilder {

    private final DbT7064CareManegerEntity entity;
    private final CareManegerIdentifier id;

    /**
     * {@link DbT7064CareManegerEntity}より{@link CareManeger}の編集用Builderクラスを生成します。
     *
     * @param entity {@link DbT7064CareManegerEntity}
     * @param id {@link CareManegerIdentifier}
     *
     */
    CareManegerBuilder(
            DbT7064CareManegerEntity entity,
            CareManegerIdentifier id
    ) {
        this.entity = entity.clone();
        this.id = id;

    }

//TODO Key項目のsetterメソッドは削除してください。
//TODO 一緒に置換される値のまとまりで不変なクラスを作成し、その単位でsetterを作る様に見直してください。
    /**
     * 介護支援専門員番号を設定します。
     *
     * @param 介護支援専門員番号 介護支援専門員番号
     * @return {@link CareManegerBuilder}
     */
    public CareManegerBuilder set介護支援専門員番号(RString 介護支援専門員番号) {
        requireNonNull(介護支援専門員番号, UrSystemErrorMessages.値がnull.getReplacedMessage("介護支援専門員番号"));
        entity.setKaigoShienSenmoninNo(介護支援専門員番号);
        return this;
    }

    /**
     * 介護支援専門員名を設定します。
     *
     * @param 介護支援専門員名 介護支援専門員名
     * @return {@link CareManegerBuilder}
     */
    public CareManegerBuilder set介護支援専門員名(AtenaMeisho 介護支援専門員名) {
        requireNonNull(介護支援専門員名, UrSystemErrorMessages.値がnull.getReplacedMessage("介護支援専門員名"));
        entity.setKaigoShienSenmoninMei(介護支援専門員名);
        return this;
    }

    /**
     * 介護支援専門員名カナを設定します。
     *
     * @param 介護支援専門員名カナ 介護支援専門員名カナ
     * @return {@link CareManegerBuilder}
     */
    public CareManegerBuilder set介護支援専門員名カナ(AtenaKanaMeisho 介護支援専門員名カナ) {
        requireNonNull(介護支援専門員名カナ, UrSystemErrorMessages.値がnull.getReplacedMessage("介護支援専門員名カナ"));
        entity.setKaigoShienSenmoninMeiKana(介護支援専門員名カナ);
        return this;
    }

    /**
     * 所属事業者番号を設定します。
     *
     * @param 所属事業者番号 所属事業者番号
     * @return {@link CareManegerBuilder}
     */
    public CareManegerBuilder set所属事業者番号(KaigoJigyoshaNo 所属事業者番号) {
        requireNonNull(所属事業者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("所属事業者番号"));
        entity.setShozokuJigyoshaNo(所属事業者番号);
        return this;
    }

    /**
     * 有効開始年月日を設定します。
     *
     * @param 有効開始年月日 有効開始年月日
     * @return {@link CareManegerBuilder}
     */
    public CareManegerBuilder set有効開始年月日(FlexibleDate 有効開始年月日) {
        requireNonNull(有効開始年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("有効開始年月日"));
        entity.setYukoKaishiDate(有効開始年月日);
        return this;
    }

    /**
     * 有効終了年月日を設定します。
     *
     * @param 有効終了年月日 有効終了年月日
     * @return {@link CareManegerBuilder}
     */
    public CareManegerBuilder set有効終了年月日(FlexibleDate 有効終了年月日) {
        requireNonNull(有効終了年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("有効終了年月日"));
        entity.setYukoShuryoDate(有効終了年月日);
        return this;
    }

    /**
     * {@link CareManeger}のインスタンスを生成します。
     *
     * @return {@link CareManeger}のインスタンス
     */
    public CareManeger build() {
        return new CareManeger(entity, id);
    }
}
