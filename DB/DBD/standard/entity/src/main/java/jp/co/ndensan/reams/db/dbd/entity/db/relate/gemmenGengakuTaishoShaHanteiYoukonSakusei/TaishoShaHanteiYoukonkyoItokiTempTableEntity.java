/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.entity.db.relate.gemmenGengakuTaishoShaHanteiYoukonSakusei;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.OnNextSchema;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;
import jp.co.ndensan.reams.uz.uza.util.db.annotation.TempTableColumnOrder;

/**
 * 減免減額対象者判定用根拠一時entityクラスです。
 *
 * @reamsid_L DBD-3710-090 liuwei2
 */
@OnNextSchema("rgdb")
public class TaishoShaHanteiYoukonkyoItokiTempTableEntity extends DbTableEntityBase<TaishoShaHanteiYoukonkyoItokiTempTableEntity> implements IDbAccessable {

    @TableName
    public static final RString TABLE_NAME;

    static {
        TABLE_NAME = (new RString("taishoShaHanteiYoukonkyoItokiTemp"));
    }
    @TempTableColumnOrder(1)
    private HihokenshaNo 被保険者番号;
    @TempTableColumnOrder(2)
    private ShikibetsuCode 本人識別コード;
    @TempTableColumnOrder(3)
    private RString 本人課税区分;
    @TempTableColumnOrder(4)
    private RString 利用者負担段階;
    @TempTableColumnOrder(5)
    private ShikibetsuCode 配偶者識別コード;
    @TempTableColumnOrder(6)
    private RString 配偶者課税区分;
    @TempTableColumnOrder(7)
    private RString 世帯課税区分;
    @TempTableColumnOrder(8)
    private Boolean is生活保護受給者;
    @TempTableColumnOrder(9)
    private Boolean is老齢福祉年金受給者;
    @TempTableColumnOrder(10)
    private Decimal 合計所得金額;
    @TempTableColumnOrder(11)
    private Decimal 年金収入額;
    @TempTableColumnOrder(12)
    private Decimal 非課税年金勘案額;
    @TempTableColumnOrder(13)
    private Boolean is高齢者複数世帯;
    @TempTableColumnOrder(13)
    private Boolean is所得税課税世帯;
    @TempTableColumnOrder(10)
    private Boolean is所得税課税者;

    public HihokenshaNo get被保険者番号() {
        return 被保険者番号;
    }

    public ShikibetsuCode get本人識別コード() {
        return 本人識別コード;
    }

    public RString get本人課税区分() {
        return 本人課税区分;
    }

    public RString get利用者負担段階() {
        return 利用者負担段階;
    }

    public ShikibetsuCode get配偶者識別コード() {
        return 配偶者識別コード;
    }

    public RString get配偶者課税区分() {
        return 配偶者課税区分;
    }

    public RString get世帯課税区分() {
        return 世帯課税区分;
    }

    public Boolean isIs生活保護受給者() {
        return is生活保護受給者;
    }

    public Boolean isIs老齢福祉年金受給者() {
        return is老齢福祉年金受給者;
    }

    public Decimal get合計所得金額() {
        return 合計所得金額;
    }

    public Decimal get年金収入額() {
        return 年金収入額;
    }

    public Decimal get非課税年金勘案額() {
        return 非課税年金勘案額;
    }

    public Boolean isIs高齢者複数世帯() {
        return is高齢者複数世帯;
    }

    public Boolean isIs所得税課税世帯() {
        return is所得税課税世帯;
    }

    public Boolean isIs所得税課税者() {
        return is所得税課税者;
    }

    public void set被保険者番号(HihokenshaNo 被保険者番号) {
        this.被保険者番号 = 被保険者番号;
    }

    public void set本人識別コード(ShikibetsuCode 本人識別コード) {
        this.本人識別コード = 本人識別コード;
    }

    public void set本人課税区分(RString 本人課税区分) {
        this.本人課税区分 = 本人課税区分;
    }

    public void set利用者負担段階(RString 利用者負担段階) {
        this.利用者負担段階 = 利用者負担段階;
    }

    public void set配偶者識別コード(ShikibetsuCode 配偶者識別コード) {
        this.配偶者識別コード = 配偶者識別コード;
    }

    public void set配偶者課税区分(RString 配偶者課税区分) {
        this.配偶者課税区分 = 配偶者課税区分;
    }

    public void set世帯課税区分(RString 世帯課税区分) {
        this.世帯課税区分 = 世帯課税区分;
    }

    public void setIs生活保護受給者(Boolean is生活保護受給者) {
        this.is生活保護受給者 = is生活保護受給者;
    }

    public void setIs老齢福祉年金受給者(Boolean is老齢福祉年金受給者) {
        this.is老齢福祉年金受給者 = is老齢福祉年金受給者;
    }

    public void set合計所得金額(Decimal 合計所得金額) {
        this.合計所得金額 = 合計所得金額;
    }

    public void set年金収入額(Decimal 年金収入額) {
        this.年金収入額 = 年金収入額;
    }

    public void set非課税年金勘案額(Decimal 非課税年金勘案額) {
        this.非課税年金勘案額 = 非課税年金勘案額;
    }

    public void setIs高齢者複数世帯(Boolean is高齢者複数世帯) {
        this.is高齢者複数世帯 = is高齢者複数世帯;
    }

    public void setIs所得税課税世帯(Boolean is所得税課税世帯) {
        this.is所得税課税世帯 = is所得税課税世帯;
    }

    public void setIs所得税課税者(Boolean is所得税課税者) {
        this.is所得税課税者 = is所得税課税者;
    }

    /**
     * コンストラクタです。
     *
     * @param 被保険者番号
     * @param 本人識別コード
     * @param 本人課税区分
     * @param 利用者負担段階
     * @param 配偶者識別コード
     * @param 配偶者課税区分
     * @param 世帯課税区分
     * @param is生活保護受給者
     * @param is老齢福祉年金受給者
     * @param 合計所得金額
     * @param 年金収入額
     * @param 非課税年金勘案額
     * @param is高齢者複数世帯
     * @param is所得税課税世帯
     * @param is所得税課税者
     */
    /**
     * {@inheritDoc}
     *
     * @param entity
     */
    @Override
    public void shallowCopy(TaishoShaHanteiYoukonkyoItokiTempTableEntity entity) {
        this.set被保険者番号(entity.get被保険者番号());
        this.set本人識別コード(entity.get本人識別コード());
        this.set本人課税区分(entity.get本人課税区分());
        this.set利用者負担段階(entity.get利用者負担段階());
        this.set配偶者識別コード(entity.get配偶者識別コード());
        this.set配偶者課税区分(entity.get配偶者課税区分());
        this.set世帯課税区分(entity.get世帯課税区分());
        this.setIs生活保護受給者(entity.isIs生活保護受給者());
        this.setIs老齢福祉年金受給者(entity.isIs老齢福祉年金受給者());
        this.set合計所得金額(entity.get合計所得金額());
        this.set年金収入額(entity.get年金収入額());
        this.set非課税年金勘案額(entity.get非課税年金勘案額());
        this.setIs高齢者複数世帯(entity.isIs高齢者複数世帯());
        this.setIs所得税課税世帯(entity.isIs所得税課税世帯());
        this.setIs所得税課税者(entity.isIs所得税課税者());
    }

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(被保険者番号, 本人識別コード, 本人課税区分, 利用者負担段階, 配偶者識別コード, 配偶者課税区分, 世帯課税区分, is生活保護受給者, is老齢福祉年金受給者,
                合計所得金額, 年金収入額, 非課税年金勘案額, is高齢者複数世帯, is所得税課税世帯, is所得税課税者);
    }
}
