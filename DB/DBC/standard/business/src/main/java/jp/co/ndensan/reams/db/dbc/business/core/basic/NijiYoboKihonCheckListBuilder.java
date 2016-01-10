/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3101NijiYoboKihonCheckListEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
//import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * {@link NijiYoboKihonCheckList}の編集を行うビルダークラスです。
 */
public class NijiYoboKihonCheckListBuilder {

    private final DbT3101NijiYoboKihonCheckListEntity entity;
    private final NijiYoboKihonCheckListIdentifier id;

    /**
     * {@link DbT3101NijiYoboKihonCheckListEntity}より{@link NijiYoboKihonCheckList}の編集用Builderクラスを生成します。
     *
     * @param entity {@link DbT3101NijiYoboKihonCheckListEntity}
     * @param id {@link NijiYoboKihonCheckListIdentifier}
     *
     */
    NijiYoboKihonCheckListBuilder(
            DbT3101NijiYoboKihonCheckListEntity entity,
            NijiYoboKihonCheckListIdentifier id
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
     * @return {@link NijiYoboKihonCheckListBuilder}
     */
//    public NijiYoboKihonCheckListBuilder set識別コード(ShikibetsuCode 識別コード) {
//        requireNonNull(識別コード, UrSystemErrorMessages.値がnull.getReplacedMessage("識別コード"));
//        entity.setShikibetsuCode(識別コード);
//        return this;
//    }

    /**
     * 被保険者番号を設定します。
     *
     * @param 被保険者番号 被保険者番号
     * @return {@link NijiYoboKihonCheckListBuilder}
     */
    public NijiYoboKihonCheckListBuilder set被保険者番号(HihokenshaNo 被保険者番号) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        entity.setHihokenshaNo(被保険者番号);
        return this;
    }

    /**
     * 受付年月日を設定します。
     *
     * @param 受付年月日 受付年月日
     * @return {@link NijiYoboKihonCheckListBuilder}
     */
    public NijiYoboKihonCheckListBuilder set受付年月日(FlexibleDate 受付年月日) {
        requireNonNull(受付年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("受付年月日"));
        entity.setUketsukeYMD(受付年月日);
        return this;
    }

    /**
     * 履歴番号を設定します。
     *
     * @param 履歴番号 履歴番号
     * @return {@link NijiYoboKihonCheckListBuilder}
     */
    public NijiYoboKihonCheckListBuilder set履歴番号(int 履歴番号) {
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));
        entity.setRirekiNo(履歴番号);
        return this;
    }

    /**
     * 記入年月日を設定します。
     *
     * @param 記入年月日 記入年月日
     * @return {@link NijiYoboKihonCheckListBuilder}
     */
    public NijiYoboKihonCheckListBuilder set記入年月日(FlexibleDate 記入年月日) {
        requireNonNull(記入年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("記入年月日"));
        entity.setKinyuYMD(記入年月日);
        return this;
    }

    /**
     * 質問事項１を設定します。
     *
     * @param 質問事項１ 質問事項１
     * @return {@link NijiYoboKihonCheckListBuilder}
     */
    public NijiYoboKihonCheckListBuilder set質問事項１(int 質問事項１) {
        requireNonNull(質問事項１, UrSystemErrorMessages.値がnull.getReplacedMessage("質問事項１"));
        entity.setShitsumonJiko01(質問事項１);
        return this;
    }

    /**
     * 質問事項２を設定します。
     *
     * @param 質問事項２ 質問事項２
     * @return {@link NijiYoboKihonCheckListBuilder}
     */
    public NijiYoboKihonCheckListBuilder set質問事項２(int 質問事項２) {
        requireNonNull(質問事項２, UrSystemErrorMessages.値がnull.getReplacedMessage("質問事項２"));
        entity.setShitsumonJiko02(質問事項２);
        return this;
    }

    /**
     * 質問事項３を設定します。
     *
     * @param 質問事項３ 質問事項３
     * @return {@link NijiYoboKihonCheckListBuilder}
     */
    public NijiYoboKihonCheckListBuilder set質問事項３(int 質問事項３) {
        requireNonNull(質問事項３, UrSystemErrorMessages.値がnull.getReplacedMessage("質問事項３"));
        entity.setShitsumonJiko03(質問事項３);
        return this;
    }

    /**
     * 質問事項４を設定します。
     *
     * @param 質問事項４ 質問事項４
     * @return {@link NijiYoboKihonCheckListBuilder}
     */
    public NijiYoboKihonCheckListBuilder set質問事項４(int 質問事項４) {
        requireNonNull(質問事項４, UrSystemErrorMessages.値がnull.getReplacedMessage("質問事項４"));
        entity.setShitsumonJiko04(質問事項４);
        return this;
    }

    /**
     * 質問事項５を設定します。
     *
     * @param 質問事項５ 質問事項５
     * @return {@link NijiYoboKihonCheckListBuilder}
     */
    public NijiYoboKihonCheckListBuilder set質問事項５(int 質問事項５) {
        requireNonNull(質問事項５, UrSystemErrorMessages.値がnull.getReplacedMessage("質問事項５"));
        entity.setShitsumonJiko05(質問事項５);
        return this;
    }

    /**
     * 質問事項６を設定します。
     *
     * @param 質問事項６ 質問事項６
     * @return {@link NijiYoboKihonCheckListBuilder}
     */
    public NijiYoboKihonCheckListBuilder set質問事項６(int 質問事項６) {
        requireNonNull(質問事項６, UrSystemErrorMessages.値がnull.getReplacedMessage("質問事項６"));
        entity.setShitsumonJiko06(質問事項６);
        return this;
    }

    /**
     * 質問事項７を設定します。
     *
     * @param 質問事項７ 質問事項７
     * @return {@link NijiYoboKihonCheckListBuilder}
     */
    public NijiYoboKihonCheckListBuilder set質問事項７(int 質問事項７) {
        requireNonNull(質問事項７, UrSystemErrorMessages.値がnull.getReplacedMessage("質問事項７"));
        entity.setShitsumonJiko07(質問事項７);
        return this;
    }

    /**
     * 質問事項８を設定します。
     *
     * @param 質問事項８ 質問事項８
     * @return {@link NijiYoboKihonCheckListBuilder}
     */
    public NijiYoboKihonCheckListBuilder set質問事項８(int 質問事項８) {
        requireNonNull(質問事項８, UrSystemErrorMessages.値がnull.getReplacedMessage("質問事項８"));
        entity.setShitsumonJiko08(質問事項８);
        return this;
    }

    /**
     * 質問事項９を設定します。
     *
     * @param 質問事項９ 質問事項９
     * @return {@link NijiYoboKihonCheckListBuilder}
     */
    public NijiYoboKihonCheckListBuilder set質問事項９(int 質問事項９) {
        requireNonNull(質問事項９, UrSystemErrorMessages.値がnull.getReplacedMessage("質問事項９"));
        entity.setShitsumonJiko09(質問事項９);
        return this;
    }

    /**
     * 質問事項１０を設定します。
     *
     * @param 質問事項１０ 質問事項１０
     * @return {@link NijiYoboKihonCheckListBuilder}
     */
    public NijiYoboKihonCheckListBuilder set質問事項１０(int 質問事項１０) {
        requireNonNull(質問事項１０, UrSystemErrorMessages.値がnull.getReplacedMessage("質問事項１０"));
        entity.setShitsumonJiko10(質問事項１０);
        return this;
    }

    /**
     * 質問事項１１を設定します。
     *
     * @param 質問事項１１ 質問事項１１
     * @return {@link NijiYoboKihonCheckListBuilder}
     */
    public NijiYoboKihonCheckListBuilder set質問事項１１(int 質問事項１１) {
        requireNonNull(質問事項１１, UrSystemErrorMessages.値がnull.getReplacedMessage("質問事項１１"));
        entity.setShitsumonJiko11(質問事項１１);
        return this;
    }

    /**
     * 質問事項１２身長を設定します。
     *
     * @param 質問事項１２身長 質問事項１２身長
     * @return {@link NijiYoboKihonCheckListBuilder}
     */
    public NijiYoboKihonCheckListBuilder set質問事項１２身長(Decimal 質問事項１２身長) {
        requireNonNull(質問事項１２身長, UrSystemErrorMessages.値がnull.getReplacedMessage("質問事項１２身長"));
        entity.setShitsumonJiko12Shincho(質問事項１２身長);
        return this;
    }

    /**
     * 質問事項１２体重を設定します。
     *
     * @param 質問事項１２体重 質問事項１２体重
     * @return {@link NijiYoboKihonCheckListBuilder}
     */
    public NijiYoboKihonCheckListBuilder set質問事項１２体重(Decimal 質問事項１２体重) {
        requireNonNull(質問事項１２体重, UrSystemErrorMessages.値がnull.getReplacedMessage("質問事項１２体重"));
        entity.setShitsumonJiko12Taiju(質問事項１２体重);
        return this;
    }

    /**
     * 質問事項１３を設定します。
     *
     * @param 質問事項１３ 質問事項１３
     * @return {@link NijiYoboKihonCheckListBuilder}
     */
    public NijiYoboKihonCheckListBuilder set質問事項１３(int 質問事項１３) {
        requireNonNull(質問事項１３, UrSystemErrorMessages.値がnull.getReplacedMessage("質問事項１３"));
        entity.setShitsumonJiko13(質問事項１３);
        return this;
    }

    /**
     * 質問事項１４を設定します。
     *
     * @param 質問事項１４ 質問事項１４
     * @return {@link NijiYoboKihonCheckListBuilder}
     */
    public NijiYoboKihonCheckListBuilder set質問事項１４(int 質問事項１４) {
        requireNonNull(質問事項１４, UrSystemErrorMessages.値がnull.getReplacedMessage("質問事項１４"));
        entity.setShitsumonJiko14(質問事項１４);
        return this;
    }

    /**
     * 質問事項１５を設定します。
     *
     * @param 質問事項１５ 質問事項１５
     * @return {@link NijiYoboKihonCheckListBuilder}
     */
    public NijiYoboKihonCheckListBuilder set質問事項１５(int 質問事項１５) {
        requireNonNull(質問事項１５, UrSystemErrorMessages.値がnull.getReplacedMessage("質問事項１５"));
        entity.setShitsumonJiko15(質問事項１５);
        return this;
    }

    /**
     * 質問事項１６を設定します。
     *
     * @param 質問事項１６ 質問事項１６
     * @return {@link NijiYoboKihonCheckListBuilder}
     */
    public NijiYoboKihonCheckListBuilder set質問事項１６(int 質問事項１６) {
        requireNonNull(質問事項１６, UrSystemErrorMessages.値がnull.getReplacedMessage("質問事項１６"));
        entity.setShitsumonJiko16(質問事項１６);
        return this;
    }

    /**
     * 質問事項１７を設定します。
     *
     * @param 質問事項１７ 質問事項１７
     * @return {@link NijiYoboKihonCheckListBuilder}
     */
    public NijiYoboKihonCheckListBuilder set質問事項１７(int 質問事項１７) {
        requireNonNull(質問事項１７, UrSystemErrorMessages.値がnull.getReplacedMessage("質問事項１７"));
        entity.setShitsumonJiko17(質問事項１７);
        return this;
    }

    /**
     * 質問事項１８を設定します。
     *
     * @param 質問事項１８ 質問事項１８
     * @return {@link NijiYoboKihonCheckListBuilder}
     */
    public NijiYoboKihonCheckListBuilder set質問事項１８(int 質問事項１８) {
        requireNonNull(質問事項１８, UrSystemErrorMessages.値がnull.getReplacedMessage("質問事項１８"));
        entity.setShitsumonJiko18(質問事項１８);
        return this;
    }

    /**
     * 質問事項１９を設定します。
     *
     * @param 質問事項１９ 質問事項１９
     * @return {@link NijiYoboKihonCheckListBuilder}
     */
    public NijiYoboKihonCheckListBuilder set質問事項１９(int 質問事項１９) {
        requireNonNull(質問事項１９, UrSystemErrorMessages.値がnull.getReplacedMessage("質問事項１９"));
        entity.setShitsumonJiko19(質問事項１９);
        return this;
    }

    /**
     * 質問事項２０を設定します。
     *
     * @param 質問事項２０ 質問事項２０
     * @return {@link NijiYoboKihonCheckListBuilder}
     */
    public NijiYoboKihonCheckListBuilder set質問事項２０(int 質問事項２０) {
        requireNonNull(質問事項２０, UrSystemErrorMessages.値がnull.getReplacedMessage("質問事項２０"));
        entity.setShitsumonJiko20(質問事項２０);
        return this;
    }

    /**
     * 質問事項２１を設定します。
     *
     * @param 質問事項２１ 質問事項２１
     * @return {@link NijiYoboKihonCheckListBuilder}
     */
    public NijiYoboKihonCheckListBuilder set質問事項２１(int 質問事項２１) {
        requireNonNull(質問事項２１, UrSystemErrorMessages.値がnull.getReplacedMessage("質問事項２１"));
        entity.setShitsumonJiko21(質問事項２１);
        return this;
    }

    /**
     * 質問事項２２を設定します。
     *
     * @param 質問事項２２ 質問事項２２
     * @return {@link NijiYoboKihonCheckListBuilder}
     */
    public NijiYoboKihonCheckListBuilder set質問事項２２(int 質問事項２２) {
        requireNonNull(質問事項２２, UrSystemErrorMessages.値がnull.getReplacedMessage("質問事項２２"));
        entity.setShitsumonJiko22(質問事項２２);
        return this;
    }

    /**
     * 質問事項２３を設定します。
     *
     * @param 質問事項２３ 質問事項２３
     * @return {@link NijiYoboKihonCheckListBuilder}
     */
    public NijiYoboKihonCheckListBuilder set質問事項２３(int 質問事項２３) {
        requireNonNull(質問事項２３, UrSystemErrorMessages.値がnull.getReplacedMessage("質問事項２３"));
        entity.setShitsumonJiko23(質問事項２３);
        return this;
    }

    /**
     * 質問事項２４を設定します。
     *
     * @param 質問事項２４ 質問事項２４
     * @return {@link NijiYoboKihonCheckListBuilder}
     */
    public NijiYoboKihonCheckListBuilder set質問事項２４(int 質問事項２４) {
        requireNonNull(質問事項２４, UrSystemErrorMessages.値がnull.getReplacedMessage("質問事項２４"));
        entity.setShitsumonJiko24(質問事項２４);
        return this;
    }

    /**
     * 質問事項２５を設定します。
     *
     * @param 質問事項２５ 質問事項２５
     * @return {@link NijiYoboKihonCheckListBuilder}
     */
    public NijiYoboKihonCheckListBuilder set質問事項２５(int 質問事項２５) {
        requireNonNull(質問事項２５, UrSystemErrorMessages.値がnull.getReplacedMessage("質問事項２５"));
        entity.setShitsumonJiko25(質問事項２５);
        return this;
    }

    /**
     * {@link NijiYoboKihonCheckList}のインスタンスを生成します。
     *
     * @return {@link NijiYoboKihonCheckList}のインスタンス
     */
    public NijiYoboKihonCheckList build() {
        return new NijiYoboKihonCheckList(entity, id);
    }

    public NijiYoboKihonCheckListBuilder setNijiYoboNiniCheckList(NijiYoboNiniCheckList createNijiYoboNiniCheckList) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public NijiYoboKihonCheckListBuilder setNijiYoboCheckListHanteiKekka(NijiYoboCheckListHanteiKekka createNijiYoboCheckListHanteiKekka) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
