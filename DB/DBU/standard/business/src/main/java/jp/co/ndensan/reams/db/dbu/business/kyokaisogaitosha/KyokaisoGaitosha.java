/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.business.kyokaisogaitosha;

import jp.co.ndensan.reams.db.dbu.entity.db.relate.kyokaisogaitosha.KyokaisoGaitoshaRelateEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 境界層該当者一覧情報を管理するビジネスです。
 */
public class KyokaisoGaitosha {

    private final KyokaisoGaitoshaRelateEntity entity;

    /**
     * コンストラクタです。
     *
     * @param entity 境界層該当者一覧情報RelateEntity
     */
    public KyokaisoGaitosha(KyokaisoGaitoshaRelateEntity entity) {
        this.entity = entity;
    }

    /**
     * 被保険者番号を取得します。
     *
     * @return 被保険者番号
     */
    public HihokenshaNo get被保険者番号() {
        return entity.get被保険者番号();
    }

    /**
     * リンク番号を取得します。
     *
     * @return リンク番号
     */
    public Decimal getリンク番号() {
        return entity.getリンク番号();
    }

    /**
     * 申請年月日を取得します。
     *
     * @return 申請年月日
     */
    public FlexibleDate get申請年月日() {
        return entity.get申請年月日();
    }

    /**
     * 受付年月日を取得します。
     *
     * @return 受付年月日
     */
    public FlexibleDate get受付年月日() {
        return entity.get受付年月日();
    }

    /**
     * 適用開始年月日を取得します。
     *
     * @return 適用開始年月日
     */
    public FlexibleDate get適用開始年月日() {
        return entity.get適用開始年月日();
    }

    /**
     * 適用終了年月日を取得します。
     *
     * @return 適用終了年月日
     */
    public FlexibleDate get適用終了年月日() {
        return entity.get適用終了年月日();
    }

    /**
     * 措置該当_非該当区分を取得します。
     *
     * @return 措置該当_非該当区分
     */
    public RString get措置該当_非該当区分() {
        return entity.get措置該当_非該当区分();
    }

    /**
     * 境界層措置決定年月日を取得します。
     *
     * @return 境界層措置決定年月日
     */
    public FlexibleDate get境界層措置決定年月日() {
        return entity.get境界層措置決定年月日();
    }

    /**
     * 給付額減額記載解除フラグを取得します。
     *
     * @return 給付額減額記載解除フラグ
     */
    public RString get給付額減額記載解除フラグ() {
        return entity.get給付額減額記載解除フラグ();
    }

    /**
     * 標準負担額額該当フラグを取得します。
     *
     * @return 標準負担額額該当フラグ
     */
    public RString get標準負担額額該当フラグ() {
        return entity.get標準負担額額該当フラグ();
    }

    /**
     * 標準負担軽減後負担額を取得します。
     *
     * @return 標準負担軽減後負担額
     */
    public Decimal get標準負担軽減後負担額() {
        return entity.get標準負担軽減後負担額();
    }

    /**
     * 居住費等負担額減額該当フラグを取得します。
     *
     * @return 居住費等負担額減額該当フラグ
     */
    public RString get居住費等負担額減額該当フラグ() {
        return entity.get居住費等負担額減額該当フラグ();
    }

    /**
     * 居住費軽減後居室種類コードを取得します。
     *
     * @return 居住費軽減後居室種類コード
     */
    public RString get居住費軽減後居室種類コード() {
        return entity.get居住費軽減後居室種類コード();
    }

    /**
     * 居住費軽減後負担額を取得します。
     *
     * @return 居住費軽減後負担額
     */
    public Decimal get居住費軽減後負担額() {
        return entity.get居住費軽減後負担額();
    }

    /**
     * 食費負担額減額該当フラグを取得します。
     *
     * @return 食費負担額減額該当フラグ
     */
    public RString get食費負担額減額該当フラグ() {
        return entity.get食費負担額減額該当フラグ();
    }

    /**
     * 食費軽減後負担額を取得します。
     *
     * @return 食費軽減後負担額
     */
    public Decimal get食費軽減後負担額() {
        return entity.get食費軽減後負担額();
    }

    /**
     * 高額ｻｰﾋﾞｽ費上限額減額該当フラグを取得します。
     *
     * @return 高額ｻｰﾋﾞｽ費上限額減額該当フラグ
     */
    public RString get高額ｻｰﾋﾞｽ費上限額減額該当フラグ() {
        return entity.get高額ｻｰﾋﾞｽ費上限額減額該当フラグ();
    }

    /**
     * 高額ｻｰﾋﾞｽ費減額後上限額を取得します。
     *
     * @return 高額ｻｰﾋﾞｽ費減額後上限額
     */
    public Decimal get高額ｻｰﾋﾞｽ費減額後上限額() {
        return entity.get高額ｻｰﾋﾞｽ費減額後上限額();
    }

    /**
     * 保険料納付減額フラグを取得します。
     *
     * @return 保険料納付減額フラグ
     */
    public RString get保険料納付減額フラグ() {
        return entity.get保険料納付減額フラグ();
    }

    /**
     * 申請_廃止区分を取得します。
     *
     * @return 申請_廃止区分
     */
    public RString get申請_廃止区分() {
        return entity.get申請_廃止区分();
    }

    /**
     * 申請_廃止年月日を取得します。
     *
     * @return 申請_廃止年月日
     */
    public FlexibleDate get申請_廃止年月日() {
        return entity.get申請_廃止年月日();
    }

    /**
     * 保護不要根拠減額金額を取得します。
     *
     * @return 保護不要根拠減額金額
     */
    public Decimal get保護不要根拠減額金額() {
        return entity.get保護不要根拠減額金額();
    }

    /**
     * 境界層証明書交付年月日を取得します。
     *
     * @return 境界層証明書交付年月日
     */
    public FlexibleDate get境界層証明書交付年月日() {
        return entity.get境界層証明書交付年月日();
    }

    /**
     * 給付額減額取消_減額自己負担月額を取得します。
     *
     * @return 給付額減額取消_減額自己負担月額
     */
    public Decimal get給付額減額取消_減額自己負担月額() {
        return entity.get給付額減額取消_減額自己負担月額();
    }

    /**
     * 居住費軽減_減額自己負担月額を取得します。
     *
     * @return 居住費軽減_減額自己負担月額
     */
    public Decimal get居住費軽減_減額自己負担月額() {
        return entity.get居住費軽減_減額自己負担月額();
    }

    /**
     * 居住費軽減_負担限度額段階コードを取得します。
     *
     * @return 居住費軽減_負担限度額段階コード
     */
    public RString get居住費軽減_負担限度額段階コード() {
        return entity.get居住費軽減_負担限度額段階コード();
    }

    /**
     * 食費軽減_減額自己負担月額を取得します。
     *
     * @return 食費軽減_減額自己負担月額
     */
    public Decimal get食費軽減_減額自己負担月額() {
        return entity.get食費軽減_減額自己負担月額();
    }

    /**
     * 食費軽減_負担限度額段階コードを取得します。
     *
     * @return 食費軽減_負担限度額段階コード
     */
    public RString get食費軽減_負担限度額段階コード() {
        return entity.get食費軽減_負担限度額段階コード();
    }

    /**
     * 利用者負担世帯合算額_減額自己負担月額を取得します。
     *
     * @return 利用者負担世帯合算額_減額自己負担月額
     */
    public Decimal get利用者負担世帯合算額_減額自己負担月額() {
        return entity.get利用者負担世帯合算額_減額自己負担月額();
    }

    /**
     * 保険料減額_減額自己負担月額を取得します。
     *
     * @return 保険料減額_減額自己負担月額
     */
    public Decimal get保険料減額_減額自己負担月額() {
        return entity.get保険料減額_減額自己負担月額();
    }

    /**
     * 減額自己負担月額合計額を取得します。
     *
     * @return 減額自己負担月額合計額
     */
    public Decimal get減額自己負担月額合計額() {
        return entity.get減額自己負担月額合計額();
    }

    /**
     * 保険料納付減額後保険料段階を取得します。
     *
     * @return 保険料納付減額後保険料段階
     */
    public RString get保険料納付減額後保険料段階() {
        return entity.get保険料納付減額後保険料段階();
    }
}
