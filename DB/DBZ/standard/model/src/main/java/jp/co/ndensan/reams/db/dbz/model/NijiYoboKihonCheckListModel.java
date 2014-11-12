/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.model;

import java.io.Serializable;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT3101NijiYoboKihonCheckListEntity;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 二次予防基本チェックリストのモデルクラスです。
 *
 * @author LDNS 宋昕沢
 */
public class NijiYoboKihonCheckListModel implements Serializable {

    private DbT3101NijiYoboKihonCheckListEntity entity;

    /**
     * コンストラクタです。
     */
    public NijiYoboKihonCheckListModel() {
        entity = new DbT3101NijiYoboKihonCheckListEntity();
    }

    /**
     * コンストラクタです。
     *
     * @param entity DbT3101NijiYoboKihonCheckListEntity
     */
    public NijiYoboKihonCheckListModel(DbT3101NijiYoboKihonCheckListEntity entity) {
        this.entity = entity;
    }

    /**
     * DbT3101NijiYoboKihonCheckListEntityを返します。
     *
     * @return DbT3101NijiYoboKihonCheckListEntity
     */
    public DbT3101NijiYoboKihonCheckListEntity getEntity() {
        return entity;
    }

    /**
     * DbT3101NijiYoboKihonCheckListEntityを設定します。
     *
     * @param entity DbT3101NijiYoboKihonCheckListEntity
     */
    public void setEntity(DbT3101NijiYoboKihonCheckListEntity entity) {
        this.entity = entity;
    }

    /**
     * 識別コードを返します。
     *
     * @return 識別コード
     */
    public ShikibetsuCode get識別コード() {
        return entity.getShikibetsuCode();
    }

    /**
     * 被保険者番号を返します。
     *
     * @return 被保険者番号
     */
    public HihokenshaNo get被保険者番号() {
        return entity.getHihokenshaNo();
    }

    /**
     * 受付年月日を返します。
     *
     * @return 受付年月日
     */
    public FlexibleDate get受付年月日() {
        return entity.getUketsukeYMD();
    }

    /**
     * 処理日時を返します。
     *
     * @return 処理日時
     */
    public YMDHMS get処理日時() {
        return entity.getShoriTimestamp();
    }

    /**
     * 記入年月日を返します。
     *
     * @return 記入年月日
     */
    public FlexibleDate get記入年月日() {
        return entity.getKinyuYMD();
    }

    /**
     * 質問事項１を返します。
     *
     * @return 質問事項１
     */
    public int get質問事項１() {
        return entity.getShitsumonJiko01();
    }

    /**
     * 質問事項２を返します。
     *
     * @return 質問事項２
     */
    public int get質問事項２() {
        return entity.getShitsumonJiko02();
    }

    /**
     * 質問事項３を返します。
     *
     * @return 質問事項３
     */
    public int get質問事項３() {
        return entity.getShitsumonJiko03();
    }

    /**
     * 質問事項４を返します。
     *
     * @return 質問事項４
     */
    public int get質問事項４() {
        return entity.getShitsumonJiko04();
    }

    /**
     * 質問事項５を返します。
     *
     * @return 質問事項５
     */
    public int get質問事項５() {
        return entity.getShitsumonJiko05();
    }

    /**
     * 質問事項６を返します。
     *
     * @return 質問事項６
     */
    public int get質問事項６() {
        return entity.getShitsumonJiko06();
    }

    /**
     * 質問事項７を返します。
     *
     * @return 質問事項７
     */
    public int get質問事項７() {
        return entity.getShitsumonJiko07();
    }

    /**
     * 質問事項８を返します。
     *
     * @return 質問事項８
     */
    public int get質問事項８() {
        return entity.getShitsumonJiko08();
    }

    /**
     * 質問事項９を返します。
     *
     * @return 質問事項９
     */
    public int get質問事項９() {
        return entity.getShitsumonJiko09();
    }

    /**
     * 質問事項１０を返します。
     *
     * @return 質問事項１０
     */
    public int get質問事項１０() {
        return entity.getShitsumonJiko10();
    }

    /**
     * 質問事項１１を返します。
     *
     * @return 質問事項１１
     */
    public int get質問事項１１() {
        return entity.getShitsumonJiko11();
    }

    /**
     * 質問事項１２身長を返します。
     *
     * @return 質問事項１２身長
     */
    public Decimal get質問事項１２身長() {
        return entity.getShitsumonJiko12Shincho();
    }

    /**
     * 質問事項１２体重を返します。
     *
     * @return 質問事項１２体重
     */
    public Decimal get質問事項１２体重() {
        return entity.getShitsumonJiko12Taiju();
    }

    /**
     * 質問事項１３を返します。
     *
     * @return 質問事項１３
     */
    public int get質問事項１３() {
        return entity.getShitsumonJiko13();
    }

    /**
     * 質問事項１４を返します。
     *
     * @return 質問事項１４
     */
    public int get質問事項１４() {
        return entity.getShitsumonJiko14();
    }

    /**
     * 質問事項１５を返します。
     *
     * @return 質問事項１５
     */
    public int get質問事項１５() {
        return entity.getShitsumonJiko15();
    }

    /**
     * 質問事項１６を返します。
     *
     * @return 質問事項１６
     */
    public int get質問事項１６() {
        return entity.getShitsumonJiko16();
    }

    /**
     * 質問事項１７を返します。
     *
     * @return 質問事項１７
     */
    public int get質問事項１７() {
        return entity.getShitsumonJiko17();
    }

    /**
     * 質問事項１８を返します。
     *
     * @return 質問事項１８
     */
    public int get質問事項１８() {
        return entity.getShitsumonJiko18();
    }

    /**
     * 質問事項１９を返します。
     *
     * @return 質問事項１９
     */
    public int get質問事項１９() {
        return entity.getShitsumonJiko19();
    }

    /**
     * 質問事項２０を返します。
     *
     * @return 質問事項２０
     */
    public int get質問事項２０() {
        return entity.getShitsumonJiko20();
    }

    /**
     * 質問事項２１を返します。
     *
     * @return 質問事項２１
     */
    public int get質問事項２１() {
        return entity.getShitsumonJiko21();
    }

    /**
     * 質問事項２２を返します。
     *
     * @return 質問事項２２
     */
    public int get質問事項２２() {
        return entity.getShitsumonJiko22();
    }

    /**
     * 質問事項２３を返します。
     *
     * @return 質問事項２３
     */
    public int get質問事項２３() {
        return entity.getShitsumonJiko23();
    }

    /**
     * 質問事項２４を返します。
     *
     * @return 質問事項２４
     */
    public int get質問事項２４() {
        return entity.getShitsumonJiko24();
    }

    /**
     * 質問事項２５を返します。
     *
     * @return 質問事項２５
     */
    public int get質問事項２５() {
        return entity.getShitsumonJiko25();
    }

    /**
     * 識別コードを設定します。
     *
     * @param 識別コード 識別コード
     */
    public void set識別コード(ShikibetsuCode 識別コード) {
        requireNonNull(識別コード, UrSystemErrorMessages.値がnull.getReplacedMessage("識別コード"));
        entity.setShikibetsuCode(識別コード);
    }

    /**
     * 被保険者番号を設定します。
     *
     * @param 被保険者番号 被保険者番号
     */
    public void set被保険者番号(HihokenshaNo 被保険者番号) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        entity.setHihokenshaNo(被保険者番号);
    }

    /**
     * 受付年月日を設定します。
     *
     * @param 受付年月日 受付年月日
     */
    public void set受付年月日(FlexibleDate 受付年月日) {
        requireNonNull(受付年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("受付年月日"));
        entity.setUketsukeYMD(受付年月日);
    }

    /**
     * 処理日時を設定します。
     *
     * @param 処理日時 処理日時
     */
    public void set処理日時(YMDHMS 処理日時) {
        requireNonNull(処理日時, UrSystemErrorMessages.値がnull.getReplacedMessage("処理日時"));
        entity.setShoriTimestamp(処理日時);
    }

    /**
     * 記入年月日を設定します。
     *
     * @param 記入年月日 記入年月日
     */
    public void set記入年月日(FlexibleDate 記入年月日) {
        requireNonNull(記入年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("記入年月日"));
        entity.setKinyuYMD(記入年月日);
    }

    /**
     * 質問事項１を設定します。
     *
     * @param 質問事項１ 質問事項１
     */
    public void set質問事項１(int 質問事項１) {
        requireNonNull(質問事項１, UrSystemErrorMessages.値がnull.getReplacedMessage("質問事項１"));
        entity.setShitsumonJiko01(質問事項１);
    }

    /**
     * 質問事項２を設定します。
     *
     * @param 質問事項２ 質問事項２
     */
    public void set質問事項２(int 質問事項２) {
        requireNonNull(質問事項２, UrSystemErrorMessages.値がnull.getReplacedMessage("質問事項２"));
        entity.setShitsumonJiko02(質問事項２);
    }

    /**
     * 質問事項３を設定します。
     *
     * @param 質問事項３ 質問事項３
     */
    public void set質問事項３(int 質問事項３) {
        requireNonNull(質問事項３, UrSystemErrorMessages.値がnull.getReplacedMessage("質問事項３"));
        entity.setShitsumonJiko03(質問事項３);
    }

    /**
     * 質問事項４を設定します。
     *
     * @param 質問事項４ 質問事項４
     */
    public void set質問事項４(int 質問事項４) {
        requireNonNull(質問事項４, UrSystemErrorMessages.値がnull.getReplacedMessage("質問事項４"));
        entity.setShitsumonJiko04(質問事項４);
    }

    /**
     * 質問事項５を設定します。
     *
     * @param 質問事項５ 質問事項５
     */
    public void set質問事項５(int 質問事項５) {
        requireNonNull(質問事項５, UrSystemErrorMessages.値がnull.getReplacedMessage("質問事項５"));
        entity.setShitsumonJiko05(質問事項５);
    }

    /**
     * 質問事項６を設定します。
     *
     * @param 質問事項６ 質問事項６
     */
    public void set質問事項６(int 質問事項６) {
        requireNonNull(質問事項６, UrSystemErrorMessages.値がnull.getReplacedMessage("質問事項６"));
        entity.setShitsumonJiko06(質問事項６);
    }

    /**
     * 質問事項７を設定します。
     *
     * @param 質問事項７ 質問事項７
     */
    public void set質問事項７(int 質問事項７) {
        requireNonNull(質問事項７, UrSystemErrorMessages.値がnull.getReplacedMessage("質問事項７"));
        entity.setShitsumonJiko07(質問事項７);
    }

    /**
     * 質問事項８を設定します。
     *
     * @param 質問事項８ 質問事項８
     */
    public void set質問事項８(int 質問事項８) {
        requireNonNull(質問事項８, UrSystemErrorMessages.値がnull.getReplacedMessage("質問事項８"));
        entity.setShitsumonJiko08(質問事項８);
    }

    /**
     * 質問事項９を設定します。
     *
     * @param 質問事項９ 質問事項９
     */
    public void set質問事項９(int 質問事項９) {
        requireNonNull(質問事項９, UrSystemErrorMessages.値がnull.getReplacedMessage("質問事項９"));
        entity.setShitsumonJiko09(質問事項９);
    }

    /**
     * 質問事項１０を設定します。
     *
     * @param 質問事項１０ 質問事項１０
     */
    public void set質問事項１０(int 質問事項１０) {
        requireNonNull(質問事項１０, UrSystemErrorMessages.値がnull.getReplacedMessage("質問事項１０"));
        entity.setShitsumonJiko10(質問事項１０);
    }

    /**
     * 質問事項１１を設定します。
     *
     * @param 質問事項１１ 質問事項１１
     */
    public void set質問事項１１(int 質問事項１１) {
        requireNonNull(質問事項１１, UrSystemErrorMessages.値がnull.getReplacedMessage("質問事項１１"));
        entity.setShitsumonJiko11(質問事項１１);
    }

    /**
     * 質問事項１２身長を設定します。
     *
     * @param 質問事項１２身長 質問事項１２身長
     */
    public void set質問事項１２身長(Decimal 質問事項１２身長) {
        requireNonNull(質問事項１２身長, UrSystemErrorMessages.値がnull.getReplacedMessage("質問事項１２身長"));
        entity.setShitsumonJiko12Shincho(質問事項１２身長);
    }

    /**
     * 質問事項１２体重を設定します。
     *
     * @param 質問事項１２体重 質問事項１２体重
     */
    public void set質問事項１２体重(Decimal 質問事項１２体重) {
        requireNonNull(質問事項１２体重, UrSystemErrorMessages.値がnull.getReplacedMessage("質問事項１２体重"));
        entity.setShitsumonJiko12Taiju(質問事項１２体重);
    }

    /**
     * 質問事項１３を設定します。
     *
     * @param 質問事項１３ 質問事項１３
     */
    public void set質問事項１３(int 質問事項１３) {
        requireNonNull(質問事項１３, UrSystemErrorMessages.値がnull.getReplacedMessage("質問事項１３"));
        entity.setShitsumonJiko13(質問事項１３);
    }

    /**
     * 質問事項１４を設定します。
     *
     * @param 質問事項１４ 質問事項１４
     */
    public void set質問事項１４(int 質問事項１４) {
        requireNonNull(質問事項１４, UrSystemErrorMessages.値がnull.getReplacedMessage("質問事項１４"));
        entity.setShitsumonJiko14(質問事項１４);
    }

    /**
     * 質問事項１５を設定します。
     *
     * @param 質問事項１５ 質問事項１５
     */
    public void set質問事項１５(int 質問事項１５) {
        requireNonNull(質問事項１５, UrSystemErrorMessages.値がnull.getReplacedMessage("質問事項１５"));
        entity.setShitsumonJiko15(質問事項１５);
    }

    /**
     * 質問事項１６を設定します。
     *
     * @param 質問事項１６ 質問事項１６
     */
    public void set質問事項１６(int 質問事項１６) {
        requireNonNull(質問事項１６, UrSystemErrorMessages.値がnull.getReplacedMessage("質問事項１６"));
        entity.setShitsumonJiko16(質問事項１６);
    }

    /**
     * 質問事項１７を設定します。
     *
     * @param 質問事項１７ 質問事項１７
     */
    public void set質問事項１７(int 質問事項１７) {
        requireNonNull(質問事項１７, UrSystemErrorMessages.値がnull.getReplacedMessage("質問事項１７"));
        entity.setShitsumonJiko17(質問事項１７);
    }

    /**
     * 質問事項１８を設定します。
     *
     * @param 質問事項１８ 質問事項１８
     */
    public void set質問事項１８(int 質問事項１８) {
        requireNonNull(質問事項１８, UrSystemErrorMessages.値がnull.getReplacedMessage("質問事項１８"));
        entity.setShitsumonJiko18(質問事項１８);
    }

    /**
     * 質問事項１９を設定します。
     *
     * @param 質問事項１９ 質問事項１９
     */
    public void set質問事項１９(int 質問事項１９) {
        requireNonNull(質問事項１９, UrSystemErrorMessages.値がnull.getReplacedMessage("質問事項１９"));
        entity.setShitsumonJiko19(質問事項１９);
    }

    /**
     * 質問事項２０を設定します。
     *
     * @param 質問事項２０ 質問事項２０
     */
    public void set質問事項２０(int 質問事項２０) {
        requireNonNull(質問事項２０, UrSystemErrorMessages.値がnull.getReplacedMessage("質問事項２０"));
        entity.setShitsumonJiko20(質問事項２０);
    }

    /**
     * 質問事項２１を設定します。
     *
     * @param 質問事項２１ 質問事項２１
     */
    public void set質問事項２１(int 質問事項２１) {
        requireNonNull(質問事項２１, UrSystemErrorMessages.値がnull.getReplacedMessage("質問事項２１"));
        entity.setShitsumonJiko21(質問事項２１);
    }

    /**
     * 質問事項２２を設定します。
     *
     * @param 質問事項２２ 質問事項２２
     */
    public void set質問事項２２(int 質問事項２２) {
        requireNonNull(質問事項２２, UrSystemErrorMessages.値がnull.getReplacedMessage("質問事項２２"));
        entity.setShitsumonJiko22(質問事項２２);
    }

    /**
     * 質問事項２３を設定します。
     *
     * @param 質問事項２３ 質問事項２３
     */
    public void set質問事項２３(int 質問事項２３) {
        requireNonNull(質問事項２３, UrSystemErrorMessages.値がnull.getReplacedMessage("質問事項２３"));
        entity.setShitsumonJiko23(質問事項２３);
    }

    /**
     * 質問事項２４を設定します。
     *
     * @param 質問事項２４ 質問事項２４
     */
    public void set質問事項２４(int 質問事項２４) {
        requireNonNull(質問事項２４, UrSystemErrorMessages.値がnull.getReplacedMessage("質問事項２４"));
        entity.setShitsumonJiko24(質問事項２４);
    }

    /**
     * 質問事項２５を設定します。
     *
     * @param 質問事項２５ 質問事項２５
     */
    public void set質問事項２５(int 質問事項２５) {
        requireNonNull(質問事項２５, UrSystemErrorMessages.値がnull.getReplacedMessage("質問事項２５"));
        entity.setShitsumonJiko25(質問事項２５);
    }

    /**
     * 状態に削除を設定します。
     *
     * @param deleteFlag deleteFlag
     */
    public void setDeletedState(boolean deleteFlag) {
        if (deleteFlag) {
            entity.setState(EntityDataState.Deleted);
        } else {
            entity.unsetState();
        }
    }

    /**
     * stateを返します。
     *
     * @return EntityDataState
     */
    public EntityDataState getState() {
        return entity.getState();
    }
}
