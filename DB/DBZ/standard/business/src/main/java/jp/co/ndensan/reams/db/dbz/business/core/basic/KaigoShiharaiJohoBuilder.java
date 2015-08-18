/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.basic;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT7004KaigoShiharaiJohoEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.KamokuCode;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.NinshoshaCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHM;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * {@link KaigoShiharaiJoho}の編集を行うビルダークラスです。
 */
public class KaigoShiharaiJohoBuilder {

    private final DbT7004KaigoShiharaiJohoEntity entity;
    private final KaigoShiharaiJohoIdentifier id;

    /**
     * {@link DbT7004KaigoShiharaiJohoEntity}より{@link KaigoShiharaiJoho}の編集用Builderクラスを生成します。
     *
     * @param entity {@link DbT7004KaigoShiharaiJohoEntity}
     * @param id {@link KaigoShiharaiJohoIdentifier}
     *
     */
    KaigoShiharaiJohoBuilder(
            DbT7004KaigoShiharaiJohoEntity entity,
            KaigoShiharaiJohoIdentifier id
    ) {
        this.entity = entity.clone();
        this.id = id;

    }

//TODO Key項目のsetterメソッドは削除してください。
//TODO 一緒に置換される値のまとまりで不変なクラスを作成し、その単位でsetterを作る様に見直してください。
    /**
     * 識別コードを設定します。
     *
     * @param 識別コード 識別コード
     * @return {@link KaigoShiharaiJohoBuilder}
     */
    public KaigoShiharaiJohoBuilder set識別コード(ShikibetsuCode 識別コード) {
        requireNonNull(識別コード, UrSystemErrorMessages.値がnull.getReplacedMessage("識別コード"));
        entity.setShikibetsuCode(識別コード);
        return this;
    }

    /**
     * 科目コードを設定します。
     *
     * @param 科目コード 科目コード
     * @return {@link KaigoShiharaiJohoBuilder}
     */
    public KaigoShiharaiJohoBuilder set科目コード(KamokuCode 科目コード) {
        requireNonNull(科目コード, UrSystemErrorMessages.値がnull.getReplacedMessage("科目コード"));
        entity.setKamokuCode(科目コード);
        return this;
    }

    /**
     * 決定年月日を設定します。
     *
     * @param 決定年月日 決定年月日
     * @return {@link KaigoShiharaiJohoBuilder}
     */
    public KaigoShiharaiJohoBuilder set決定年月日(FlexibleDate 決定年月日) {
        requireNonNull(決定年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("決定年月日"));
        entity.setKetteiYMD(決定年月日);
        return this;
    }

    /**
     * 被保険者番号を設定します。
     *
     * @param 被保険者番号 被保険者番号
     * @return {@link KaigoShiharaiJohoBuilder}
     */
    public KaigoShiharaiJohoBuilder set被保険者番号(HihokenshaNo 被保険者番号) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        entity.setHihokenshaNo(被保険者番号);
        return this;
    }

    /**
     * 市町村コードを設定します。
     *
     * @param 市町村コード 市町村コード
     * @return {@link KaigoShiharaiJohoBuilder}
     */
    public KaigoShiharaiJohoBuilder set市町村コード(LasdecCode 市町村コード) {
        requireNonNull(市町村コード, UrSystemErrorMessages.値がnull.getReplacedMessage("市町村コード"));
        entity.setShichosonCode(市町村コード);
        return this;
    }

    /**
     * 支払方法区分を設定します。
     *
     * @param 支払方法区分 支払方法区分
     * @return {@link KaigoShiharaiJohoBuilder}
     */
    public KaigoShiharaiJohoBuilder set支払方法区分(RString 支払方法区分) {
        requireNonNull(支払方法区分, UrSystemErrorMessages.値がnull.getReplacedMessage("支払方法区分"));
        entity.setShiharaiHohoKubun(支払方法区分);
        return this;
    }

    /**
     * 窓口支払場所コードを設定します。
     *
     * @param 窓口支払場所コード 窓口支払場所コード
     * @return {@link KaigoShiharaiJohoBuilder}
     */
    public KaigoShiharaiJohoBuilder set窓口支払場所コード(Code 窓口支払場所コード) {
        requireNonNull(窓口支払場所コード, UrSystemErrorMessages.値がnull.getReplacedMessage("窓口支払場所コード"));
        entity.setMadoguchiShiharaiBashoCode(窓口支払場所コード);
        return this;
    }

    /**
     * 窓口支払開始年月日時分を設定します。
     *
     * @param 窓口支払開始年月日時分 窓口支払開始年月日時分
     * @return {@link KaigoShiharaiJohoBuilder}
     */
    public KaigoShiharaiJohoBuilder set窓口支払開始年月日時分(YMDHM 窓口支払開始年月日時分) {
        requireNonNull(窓口支払開始年月日時分, UrSystemErrorMessages.値がnull.getReplacedMessage("窓口支払開始年月日時分"));
        entity.setMadoguchiShiharaiKaishiYMDHM(窓口支払開始年月日時分);
        return this;
    }

    /**
     * 窓口支払終了年月日時分を設定します。
     *
     * @param 窓口支払終了年月日時分 窓口支払終了年月日時分
     * @return {@link KaigoShiharaiJohoBuilder}
     */
    public KaigoShiharaiJohoBuilder set窓口支払終了年月日時分(YMDHM 窓口支払終了年月日時分) {
        requireNonNull(窓口支払終了年月日時分, UrSystemErrorMessages.値がnull.getReplacedMessage("窓口支払終了年月日時分"));
        entity.setMadoguchiShiharaiShuryoYMDHM(窓口支払終了年月日時分);
        return this;
    }

    /**
     * 振込予定年月日を設定します。
     *
     * @param 振込予定年月日 振込予定年月日
     * @return {@link KaigoShiharaiJohoBuilder}
     */
    public KaigoShiharaiJohoBuilder set振込予定年月日(FlexibleDate 振込予定年月日) {
        requireNonNull(振込予定年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("振込予定年月日"));
        entity.setFurikomiYoteiYMD(振込予定年月日);
        return this;
    }

    /**
     * 支払金額を設定します。
     *
     * @param 支払金額 支払金額
     * @return {@link KaigoShiharaiJohoBuilder}
     */
    public KaigoShiharaiJohoBuilder set支払金額(int 支払金額) {
        requireNonNull(支払金額, UrSystemErrorMessages.値がnull.getReplacedMessage("支払金額"));
        entity.setShiharaiKingaku(支払金額);
        return this;
    }

    /**
     * 種別コードを設定します。
     *
     * @param 種別コード 種別コード
     * @return {@link KaigoShiharaiJohoBuilder}
     */
    public KaigoShiharaiJohoBuilder set種別コード(Code 種別コード) {
        requireNonNull(種別コード, UrSystemErrorMessages.値がnull.getReplacedMessage("種別コード"));
        entity.setSyubetsuCode(種別コード);
        return this;
    }

    /**
     * 用途区分コードを設定します。
     *
     * @param 用途区分コード 用途区分コード
     * @return {@link KaigoShiharaiJohoBuilder}
     */
    public KaigoShiharaiJohoBuilder set用途区分コード(Code 用途区分コード) {
        requireNonNull(用途区分コード, UrSystemErrorMessages.値がnull.getReplacedMessage("用途区分コード"));
        entity.setYotoKubunCode(用途区分コード);
        return this;
    }

    /**
     * 認証日１を設定します。
     *
     * @param 認証日１ 認証日１
     * @return {@link KaigoShiharaiJohoBuilder}
     */
    public KaigoShiharaiJohoBuilder set認証日１(FlexibleDate 認証日１) {
        requireNonNull(認証日１, UrSystemErrorMessages.値がnull.getReplacedMessage("認証日１"));
        entity.setNinshoYMD1(認証日１);
        return this;
    }

    /**
     * 認証者コード１を設定します。
     *
     * @param 認証者コード１ 認証者コード１
     * @return {@link KaigoShiharaiJohoBuilder}
     */
    public KaigoShiharaiJohoBuilder set認証者コード１(NinshoshaCode 認証者コード１) {
        requireNonNull(認証者コード１, UrSystemErrorMessages.値がnull.getReplacedMessage("認証者コード１"));
        entity.setNinshoshaCode1(認証者コード１);
        return this;
    }

    /**
     * 認証日２を設定します。
     *
     * @param 認証日２ 認証日２
     * @return {@link KaigoShiharaiJohoBuilder}
     */
    public KaigoShiharaiJohoBuilder set認証日２(FlexibleDate 認証日２) {
        requireNonNull(認証日２, UrSystemErrorMessages.値がnull.getReplacedMessage("認証日２"));
        entity.setNinshoYMD2(認証日２);
        return this;
    }

    /**
     * 認証者コード２を設定します。
     *
     * @param 認証者コード２ 認証者コード２
     * @return {@link KaigoShiharaiJohoBuilder}
     */
    public KaigoShiharaiJohoBuilder set認証者コード２(NinshoshaCode 認証者コード２) {
        requireNonNull(認証者コード２, UrSystemErrorMessages.値がnull.getReplacedMessage("認証者コード２"));
        entity.setNinshoshaCode2(認証者コード２);
        return this;
    }

    /**
     * {@link KaigoShiharaiJoho}のインスタンスを生成します。
     *
     * @return {@link KaigoShiharaiJoho}のインスタンス
     */
    public KaigoShiharaiJoho build() {
        return new KaigoShiharaiJoho(entity, id);
    }
}
