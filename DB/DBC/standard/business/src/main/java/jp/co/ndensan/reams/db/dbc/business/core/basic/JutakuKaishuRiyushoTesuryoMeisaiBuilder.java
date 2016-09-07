/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3095JutakuKaishuRiyushoTesuryoMeisaiEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceCode;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * {@link JutakuKaishuRiyushoTesuryoMeisai}の編集を行うビルダークラスです。
 */
public class JutakuKaishuRiyushoTesuryoMeisaiBuilder {

    private final DbT3095JutakuKaishuRiyushoTesuryoMeisaiEntity entity;
    private final JutakuKaishuRiyushoTesuryoMeisaiIdentifier id;

    /**
     * {@link DbT3095JutakuKaishuRiyushoTesuryoMeisaiEntity}より{@link JutakuKaishuRiyushoTesuryoMeisai}の編集用Builderクラスを生成します。
     *
     * @param entity {@link DbT3095JutakuKaishuRiyushoTesuryoMeisaiEntity}
     * @param id {@link JutakuKaishuRiyushoTesuryoMeisaiIdentifier}
     *
     */
    JutakuKaishuRiyushoTesuryoMeisaiBuilder(
            DbT3095JutakuKaishuRiyushoTesuryoMeisaiEntity entity,
            JutakuKaishuRiyushoTesuryoMeisaiIdentifier id
    ) {
        this.entity = entity.clone();
        this.id = id;

    }

//TODO Key項目のsetterメソッドは削除してください。
//TODO 一緒に置換される値のまとまりで不変なクラスを作成し、その単位でsetterを作る様に見直してください。
    /**
     * 証記載保険者番号を設定します。
     *
     * @param 証記載保険者番号 証記載保険者番号
     * @return {@link JutakuKaishuRiyushoTesuryoMeisaiBuilder}
     */
    public JutakuKaishuRiyushoTesuryoMeisaiBuilder set証記載保険者番号(HokenshaNo 証記載保険者番号) {
        requireNonNull(証記載保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("証記載保険者番号"));
        entity.setShoKisaiHokenshaNo(証記載保険者番号);
        return this;
    }

    /**
     * 被保険者番号を設定します。
     *
     * @param 被保険者番号 被保険者番号
     * @return {@link JutakuKaishuRiyushoTesuryoMeisaiBuilder}
     */
    public JutakuKaishuRiyushoTesuryoMeisaiBuilder set被保険者番号(HihokenshaNo 被保険者番号) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        entity.setHihokenshaNo(被保険者番号);
        return this;
    }

    /**
     * 履歴番号を設定します。
     *
     * @param 履歴番号 履歴番号
     * @return {@link JutakuKaishuRiyushoTesuryoMeisaiBuilder}
     */
    public JutakuKaishuRiyushoTesuryoMeisaiBuilder set履歴番号(Decimal 履歴番号) {
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));
        entity.setRirekiNo(履歴番号.intValue());
        return this;
    }

    /**
     * 識別コードを設定します。
     *
     * @param 識別コード 識別コード
     * @return {@link JutakuKaishuRiyushoTesuryoMeisaiBuilder}
     */
    public JutakuKaishuRiyushoTesuryoMeisaiBuilder set識別コード(ShikibetsuCode 識別コード) {
        requireNonNull(識別コード, UrSystemErrorMessages.値がnull.getReplacedMessage("識別コード"));
        entity.setShikibetsuCode(識別コード);
        return this;
    }

    /**
     * サービスコードを設定します。
     *
     * @param サービスコード サービスコード
     * @return {@link JutakuKaishuRiyushoTesuryoMeisaiBuilder}
     */
    public JutakuKaishuRiyushoTesuryoMeisaiBuilder setサービスコード(ServiceCode サービスコード) {
        requireNonNull(サービスコード, UrSystemErrorMessages.値がnull.getReplacedMessage("サービスコード"));
        entity.setServiceCode(サービスコード);
        return this;
    }

    /**
     * 介護住宅改修事業者名称を設定します。
     *
     * @param 介護住宅改修事業者名称 介護住宅改修事業者名称
     * @return {@link JutakuKaishuRiyushoTesuryoMeisaiBuilder}
     */
    public JutakuKaishuRiyushoTesuryoMeisaiBuilder set介護住宅改修事業者名称(AtenaMeisho 介護住宅改修事業者名称) {
        requireNonNull(介護住宅改修事業者名称, UrSystemErrorMessages.値がnull.getReplacedMessage("介護住宅改修事業者名称"));
        entity.setJutakuKaishuJigyoshaMeisho(介護住宅改修事業者名称);
        return this;
    }

    /**
     * 介護住宅改修着工年月日を設定します。
     *
     * @param 介護住宅改修着工年月日 介護住宅改修着工年月日
     * @return {@link JutakuKaishuRiyushoTesuryoMeisaiBuilder}
     */
    public JutakuKaishuRiyushoTesuryoMeisaiBuilder set介護住宅改修着工年月日(FlexibleDate 介護住宅改修着工年月日) {
        requireNonNull(介護住宅改修着工年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("介護住宅改修着工年月日"));
        entity.setJutakuKaishuChakkoYMD(介護住宅改修着工年月日);
        return this;
    }

    /**
     * 介護住宅改修住宅所有者を設定します。
     *
     * @param 介護住宅改修住宅所有者 介護住宅改修住宅所有者
     * @return {@link JutakuKaishuRiyushoTesuryoMeisaiBuilder}
     */
    public JutakuKaishuRiyushoTesuryoMeisaiBuilder set介護住宅改修住宅所有者(AtenaMeisho 介護住宅改修住宅所有者) {
        requireNonNull(介護住宅改修住宅所有者, UrSystemErrorMessages.値がnull.getReplacedMessage("介護住宅改修住宅所有者"));
        entity.setJutakuKaishuJushoShozaisha(介護住宅改修住宅所有者);
        return this;
    }

    /**
     * 改修対象住宅住所を設定します。
     *
     * @param 改修対象住宅住所 改修対象住宅住所
     * @return {@link JutakuKaishuRiyushoTesuryoMeisaiBuilder}
     */
    public JutakuKaishuRiyushoTesuryoMeisaiBuilder set改修対象住宅住所(RString 改修対象住宅住所) {
        requireNonNull(改修対象住宅住所, UrSystemErrorMessages.値がnull.getReplacedMessage("改修対象住宅住所"));
        entity.setKaishuTaishoJutakuJusho(改修対象住宅住所);
        return this;
    }

    /**
     * 改修内容・箇所及び規模を設定します。
     *
     * @param 改修内容_箇所及び規模 改修内容・箇所及び規模
     * @return {@link JutakuKaishuRiyushoTesuryoMeisaiBuilder}
     */
    public JutakuKaishuRiyushoTesuryoMeisaiBuilder set改修内容_箇所及び規模(RString 改修内容_箇所及び規模) {
        requireNonNull(改修内容_箇所及び規模, UrSystemErrorMessages.値がnull.getReplacedMessage("改修内容・箇所及び規模"));
        entity.setKaishuNaiyo_kasho_Kibo(改修内容_箇所及び規模);
        return this;
    }

    /**
     * 介護住宅改修理由書作成年月日を設定します。
     *
     * @param 介護住宅改修理由書作成年月日 介護住宅改修理由書作成年月日
     * @return {@link JutakuKaishuRiyushoTesuryoMeisaiBuilder}
     */
    public JutakuKaishuRiyushoTesuryoMeisaiBuilder set介護住宅改修理由書作成年月日(FlexibleDate 介護住宅改修理由書作成年月日) {
        requireNonNull(介護住宅改修理由書作成年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("介護住宅改修理由書作成年月日"));
        entity.setRiyushoSakuseiYMD(介護住宅改修理由書作成年月日);
        return this;
    }

    /**
     * 介護住宅改修理由書作成事業者番号を設定します。
     *
     * @param 介護住宅改修理由書作成事業者番号 介護住宅改修理由書作成事業者番号
     * @return {@link JutakuKaishuRiyushoTesuryoMeisaiBuilder}
     */
    public JutakuKaishuRiyushoTesuryoMeisaiBuilder set介護住宅改修理由書作成事業者番号(JigyoshaNo 介護住宅改修理由書作成事業者番号) {
        requireNonNull(介護住宅改修理由書作成事業者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("介護住宅改修理由書作成事業者番号"));
        entity.setRiyushoSakuseiJigyoshaNo(介護住宅改修理由書作成事業者番号);
        return this;
    }

    /**
     * 介護住宅改修理由書作成者名を設定します。
     *
     * @param 介護住宅改修理由書作成者名 介護住宅改修理由書作成者名
     * @return {@link JutakuKaishuRiyushoTesuryoMeisaiBuilder}
     */
    public JutakuKaishuRiyushoTesuryoMeisaiBuilder set介護住宅改修理由書作成者名(AtenaMeisho 介護住宅改修理由書作成者名) {
        requireNonNull(介護住宅改修理由書作成者名, UrSystemErrorMessages.値がnull.getReplacedMessage("介護住宅改修理由書作成者名"));
        entity.setRiyushoSakuseishaMei(介護住宅改修理由書作成者名);
        return this;
    }

    /**
     * 介護住宅改修理由書作成者資格を設定します。
     *
     * @param 介護住宅改修理由書作成者資格 介護住宅改修理由書作成者資格
     * @return {@link JutakuKaishuRiyushoTesuryoMeisaiBuilder}
     */
//    public JutakuKaishuRiyushoTesuryoMeisaiBuilder set介護住宅改修理由書作成者資格(RString 介護住宅改修理由書作成者資格) {
//        requireNonNull(介護住宅改修理由書作成者資格, UrSystemErrorMessages.値がnull.getReplacedMessage("介護住宅改修理由書作成者資格"));
//        entity.setRiyushoSakuseishaShikaku(介護住宅改修理由書作成者資格);
//        return this;
//    }

    /**
     * 介護住宅改修理由書作成申請年月日を設定します。
     *
     * @param 介護住宅改修理由書作成申請年月日 介護住宅改修理由書作成申請年月日
     * @return {@link JutakuKaishuRiyushoTesuryoMeisaiBuilder}
     */
    public JutakuKaishuRiyushoTesuryoMeisaiBuilder set介護住宅改修理由書作成申請年月日(FlexibleDate 介護住宅改修理由書作成申請年月日) {
        requireNonNull(介護住宅改修理由書作成申請年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("介護住宅改修理由書作成申請年月日"));
        entity.setRiyushoSakuseiShinseiYMD(介護住宅改修理由書作成申請年月日);
        return this;
    }

    /**
     * 介護住宅改修理由書作成受付年月日を設定します。
     *
     * @param 介護住宅改修理由書作成受付年月日 介護住宅改修理由書作成受付年月日
     * @return {@link JutakuKaishuRiyushoTesuryoMeisaiBuilder}
     */
    public JutakuKaishuRiyushoTesuryoMeisaiBuilder set介護住宅改修理由書作成受付年月日(FlexibleDate 介護住宅改修理由書作成受付年月日) {
        requireNonNull(介護住宅改修理由書作成受付年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("介護住宅改修理由書作成受付年月日"));
        entity.setRiyushoSakuseiUketsukeYMD(介護住宅改修理由書作成受付年月日);
        return this;
    }

    /**
     * {@link JutakuKaishuRiyushoTesuryoMeisai}のインスタンスを生成します。
     *
     * @return {@link JutakuKaishuRiyushoTesuryoMeisai}のインスタンス
     */
    public JutakuKaishuRiyushoTesuryoMeisai build() {
        return new JutakuKaishuRiyushoTesuryoMeisai(entity, id);
    }
}
