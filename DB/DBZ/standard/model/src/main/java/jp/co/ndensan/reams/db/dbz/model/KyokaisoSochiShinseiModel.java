/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.model;

import java.io.Serializable;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT1013KyokaisoSochiShinseiEntity;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 境界層措置申請のモデルクラスです。
 *
 * @author LDNS 鄭雪双
 */
public class KyokaisoSochiShinseiModel implements Serializable {

    private DbT1013KyokaisoSochiShinseiEntity entity;

    /**
     * コンストラクタです。
     */
    public KyokaisoSochiShinseiModel() {
        entity = new DbT1013KyokaisoSochiShinseiEntity();
    }

    /**
     * コンストラクタです。
     *
     * @param entity DbT1013KyokaisoSochiShinseiEntity
     */
    public KyokaisoSochiShinseiModel(DbT1013KyokaisoSochiShinseiEntity entity) {
        this.entity = entity;
    }

    /**
     * DbT1013KyokaisoSochiShinseiEntityを返します。
     *
     * @return DbT1013KyokaisoSochiShinseiEntity
     */
    public DbT1013KyokaisoSochiShinseiEntity getEntity() {
        return entity;
    }

    /**
     * DbT1013KyokaisoSochiShinseiEntityを設定します。
     *
     * @param entity DbT1013KyokaisoSochiShinseiEntity
     */
    public void setEntity(DbT1013KyokaisoSochiShinseiEntity entity) {
        this.entity = entity;
    }

    /**
     * 証記載保険者番号を返します。
     *
     * @return 証記載保険者番号
     */
    public ShoKisaiHokenshaNo get証記載保険者番号() {
        return entity.getShoKisaiHokenshaNo();
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
     * 申請年月日を返します。
     *
     * @return 申請年月日
     */
    public FlexibleDate get申請年月日() {
        return entity.getShinseiYMD();
    }

    /**
     * 処理日時を返します。
     *
     * @return 処理日時
     */
    public YMDHMS get処理日時() {
        return entity.getShoriTimeStamp();
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
     * 申請_廃止区分を返します。
     *
     * @return 申請_廃止区分
     */
    public RString get申請_廃止区分() {
        return entity.getShinsei_HaishiKubun();
    }

    /**
     * 申請_廃止年月日を返します。
     *
     * @return 申請_廃止年月日
     */
    public FlexibleDate get申請_廃止年月日() {
        return entity.getShinsei_HaishiYMD();
    }

    /**
     * 保護不要根拠減額金額を返します。
     *
     * @return 保護不要根拠減額金額
     */
    public Decimal get保護不要根拠減額金額() {
        return entity.getHogoHuyoKonkyoGengakuKingaku();
    }

    /**
     * 境界層証明書交付年月日を返します。
     *
     * @return 境界層証明書交付年月日
     */
    public FlexibleDate get境界層証明書交付年月日() {
        return entity.getKyokaisoShomeishoKofuYMD();
    }

    /**
     * 給付額減額取消_減額自己負担月額を返します。
     *
     * @return 給付額減額取消_減額自己負担月額
     */
    public Decimal get給付額減額取消_減額自己負担月額() {
        return entity.getKyufuGengakuTorikeshi_GengakuJikofutanGetsugaku();
    }

    /**
     * 居住費軽減_減額自己負担月額を返します。
     *
     * @return 居住費軽減_減額自己負担月額
     */
    public Decimal get居住費軽減_減額自己負担月額() {
        return entity.getKyojuhiKeigen_GengakuJikofutanGetsugaku();
    }

    /**
     * 居住費軽減_負担限度額段階コードを返します。
     *
     * @return 居住費軽減_負担限度額段階コード
     */
    public RString get居住費軽減_負担限度額段階コード() {
        return entity.getKyojuhiKeigen_FutangendogakuDankaiCode();
    }

    /**
     * 食費軽減_減額自己負担月額を返します。
     *
     * @return 食費軽減_減額自己負担月額
     */
    public Decimal get食費軽減_減額自己負担月額() {
        return entity.getShokuhiKeigen_GengakuJikofutanGetsugaku();
    }

    /**
     * 食費軽減_負担限度額段階コードを返します。
     *
     * @return 食費軽減_負担限度額段階コード
     */
    public RString get食費軽減_負担限度額段階コード() {
        return entity.getShokuhiKeigen_FutangendogakuDankaiCode();
    }

    /**
     * 利用者負担世帯合算額_減額自己負担月額を返します。
     *
     * @return 利用者負担世帯合算額_減額自己負担月額
     */
    public Decimal get利用者負担世帯合算額_減額自己負担月額() {
        return entity.getRiyoshaFutanSetaiGassanGaku_GengakuJokofutanGetsugaku();
    }

    /**
     * 保険料減額_減額自己負担月額を返します。
     *
     * @return 保険料減額_減額自己負担月額
     */
    public Decimal get保険料減額_減額自己負担月額() {
        return entity.getHokenryoGengaku_GengakuJikofutanGetsugaku();
    }

    /**
     * 減額自己負担月額合計額を返します。
     *
     * @return 減額自己負担月額合計額
     */
    public Decimal get減額自己負担月額合計額() {
        return entity.getGengakuJikofutanGetsugakuGokeigaku();
    }

    /**
     * 境界層措置決定年月日を返します。
     *
     * @return 境界層措置決定年月日
     */
    public FlexibleDate get境界層措置決定年月日() {
        return entity.getKyukaisoSochiKetteiYMD();
    }

    /**
     * 措置該当_非該当区分を返します。
     *
     * @return 措置該当_非該当区分
     */
    public RString get措置該当_非該当区分() {
        return entity.getSochiGaito_HigaitoKubun();
    }

    /**
     * 証記載保険者番号を設定します。
     *
     * @param 証記載保険者番号 証記載保険者番号
     */
    public void set証記載保険者番号(ShoKisaiHokenshaNo 証記載保険者番号) {
        requireNonNull(証記載保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("証記載保険者番号"));
        entity.setShoKisaiHokenshaNo(証記載保険者番号);
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
     * 申請年月日を設定します。
     *
     * @param 申請年月日 申請年月日
     */
    public void set申請年月日(FlexibleDate 申請年月日) {
        requireNonNull(申請年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("申請年月日"));
        entity.setShinseiYMD(申請年月日);
    }

    /**
     * 処理日時を設定します。
     *
     * @param 処理日時 処理日時
     */
    public void set処理日時(YMDHMS 処理日時) {
        requireNonNull(処理日時, UrSystemErrorMessages.値がnull.getReplacedMessage("処理日時"));
        entity.setShoriTimeStamp(処理日時);
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
     * 申請_廃止区分を設定します。
     *
     * @param 申請_廃止区分 申請_廃止区分
     */
    public void set申請_廃止区分(RString 申請_廃止区分) {
        requireNonNull(申請_廃止区分, UrSystemErrorMessages.値がnull.getReplacedMessage("申請_廃止区分"));
        entity.setShinsei_HaishiKubun(申請_廃止区分);
    }

    /**
     * 申請_廃止年月日を設定します。
     *
     * @param 申請_廃止年月日 申請_廃止年月日
     */
    public void set申請_廃止年月日(FlexibleDate 申請_廃止年月日) {
        requireNonNull(申請_廃止年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("申請_廃止年月日"));
        entity.setShinsei_HaishiYMD(申請_廃止年月日);
    }

    /**
     * 保護不要根拠減額金額を設定します。
     *
     * @param 保護不要根拠減額金額 保護不要根拠減額金額
     */
    public void set保護不要根拠減額金額(Decimal 保護不要根拠減額金額) {
        requireNonNull(保護不要根拠減額金額, UrSystemErrorMessages.値がnull.getReplacedMessage("保護不要根拠減額金額"));
        entity.setHogoHuyoKonkyoGengakuKingaku(保護不要根拠減額金額);
    }

    /**
     * 境界層証明書交付年月日を設定します。
     *
     * @param 境界層証明書交付年月日 境界層証明書交付年月日
     */
    public void set境界層証明書交付年月日(FlexibleDate 境界層証明書交付年月日) {
        requireNonNull(境界層証明書交付年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("境界層証明書交付年月日"));
        entity.setKyokaisoShomeishoKofuYMD(境界層証明書交付年月日);
    }

    /**
     * 給付額減額取消_減額自己負担月額を設定します。
     *
     * @param 給付額減額取消_減額自己負担月額 給付額減額取消_減額自己負担月額
     */
    public void set給付額減額取消_減額自己負担月額(Decimal 給付額減額取消_減額自己負担月額) {
        requireNonNull(給付額減額取消_減額自己負担月額, UrSystemErrorMessages.値がnull.getReplacedMessage("給付額減額取消_減額自己負担月額"));
        entity.setKyufuGengakuTorikeshi_GengakuJikofutanGetsugaku(給付額減額取消_減額自己負担月額);
    }

    /**
     * 居住費軽減_減額自己負担月額を設定します。
     *
     * @param 居住費軽減_減額自己負担月額 居住費軽減_減額自己負担月額
     */
    public void set居住費軽減_減額自己負担月額(Decimal 居住費軽減_減額自己負担月額) {
        requireNonNull(居住費軽減_減額自己負担月額, UrSystemErrorMessages.値がnull.getReplacedMessage("居住費軽減_減額自己負担月額"));
        entity.setKyojuhiKeigen_GengakuJikofutanGetsugaku(居住費軽減_減額自己負担月額);
    }

    /**
     * 居住費軽減_負担限度額段階コードを設定します。
     *
     * @param 居住費軽減_負担限度額段階コード 居住費軽減_負担限度額段階コード
     */
    public void set居住費軽減_負担限度額段階コード(RString 居住費軽減_負担限度額段階コード) {
        requireNonNull(居住費軽減_負担限度額段階コード, UrSystemErrorMessages.値がnull.getReplacedMessage("居住費軽減_負担限度額段階コード"));
        entity.setKyojuhiKeigen_FutangendogakuDankaiCode(居住費軽減_負担限度額段階コード);
    }

    /**
     * 食費軽減_減額自己負担月額を設定します。
     *
     * @param 食費軽減_減額自己負担月額 食費軽減_減額自己負担月額
     */
    public void set食費軽減_減額自己負担月額(Decimal 食費軽減_減額自己負担月額) {
        requireNonNull(食費軽減_減額自己負担月額, UrSystemErrorMessages.値がnull.getReplacedMessage("食費軽減_減額自己負担月額"));
        entity.setShokuhiKeigen_GengakuJikofutanGetsugaku(食費軽減_減額自己負担月額);
    }

    /**
     * 食費軽減_負担限度額段階コードを設定します。
     *
     * @param 食費軽減_負担限度額段階コード 食費軽減_負担限度額段階コード
     */
    public void set食費軽減_負担限度額段階コード(RString 食費軽減_負担限度額段階コード) {
        requireNonNull(食費軽減_負担限度額段階コード, UrSystemErrorMessages.値がnull.getReplacedMessage("食費軽減_負担限度額段階コード"));
        entity.setShokuhiKeigen_FutangendogakuDankaiCode(食費軽減_負担限度額段階コード);
    }

    /**
     * 利用者負担世帯合算額_減額自己負担月額を設定します。
     *
     * @param 利用者負担世帯合算額_減額自己負担月額 利用者負担世帯合算額_減額自己負担月額
     */
    public void set利用者負担世帯合算額_減額自己負担月額(Decimal 利用者負担世帯合算額_減額自己負担月額) {
        requireNonNull(利用者負担世帯合算額_減額自己負担月額, UrSystemErrorMessages.値がnull.getReplacedMessage("利用者負担世帯合算額_減額自己負担月額"));
        entity.setRiyoshaFutanSetaiGassanGaku_GengakuJokofutanGetsugaku(利用者負担世帯合算額_減額自己負担月額);
    }

    /**
     * 保険料減額_減額自己負担月額を設定します。
     *
     * @param 保険料減額_減額自己負担月額 保険料減額_減額自己負担月額
     */
    public void set保険料減額_減額自己負担月額(Decimal 保険料減額_減額自己負担月額) {
        requireNonNull(保険料減額_減額自己負担月額, UrSystemErrorMessages.値がnull.getReplacedMessage("保険料減額_減額自己負担月額"));
        entity.setHokenryoGengaku_GengakuJikofutanGetsugaku(保険料減額_減額自己負担月額);
    }

    /**
     * 減額自己負担月額合計額を設定します。
     *
     * @param 減額自己負担月額合計額 減額自己負担月額合計額
     */
    public void set減額自己負担月額合計額(Decimal 減額自己負担月額合計額) {
        requireNonNull(減額自己負担月額合計額, UrSystemErrorMessages.値がnull.getReplacedMessage("減額自己負担月額合計額"));
        entity.setGengakuJikofutanGetsugakuGokeigaku(減額自己負担月額合計額);
    }

    /**
     * 境界層措置決定年月日を設定します。
     *
     * @param 境界層措置決定年月日 境界層措置決定年月日
     */
    public void set境界層措置決定年月日(FlexibleDate 境界層措置決定年月日) {
        requireNonNull(境界層措置決定年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("境界層措置決定年月日"));
        entity.setKyukaisoSochiKetteiYMD(境界層措置決定年月日);
    }

    /**
     * 措置該当_非該当区分を設定します。
     *
     * @param 措置該当_非該当区分 措置該当_非該当区分
     */
    public void set措置該当_非該当区分(RString 措置該当_非該当区分) {
        requireNonNull(措置該当_非該当区分, UrSystemErrorMessages.値がnull.getReplacedMessage("措置該当_非該当区分"));
        entity.setSochiGaito_HigaitoKubun(措置該当_非該当区分);
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
