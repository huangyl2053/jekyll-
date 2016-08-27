/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.entity.db.relate.gemmengengakutaishoshahanteiyoukonsakusei;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;
import jp.co.ndensan.reams.uz.uza.util.db.annotation.TempTableColumnOrder;
import lombok.Getter;
import lombok.Setter;

/**
 * 減免減額対象者判定用根拠一時entityクラスです。
 *
 * @reamsid_L DBD-3710-090 liuwei2
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class TaishoShaHanteiYoukonkyoItokiTempTableEntity extends
        DbTableEntityBase<TaishoShaHanteiYoukonkyoItokiTempTableEntity> implements IDbAccessable {

    /**
     * テーブル名です。
     */
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
    @TempTableColumnOrder(11)
    private Decimal 課税所得額;

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
     * @param 課税所得額
     *
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
        this.setIs生活保護受給者(entity.getIs生活保護受給者());
        this.setIs老齢福祉年金受給者(entity.getIs老齢福祉年金受給者());
        this.set合計所得金額(entity.get合計所得金額());
        this.set年金収入額(entity.get年金収入額());
        this.set非課税年金勘案額(entity.get非課税年金勘案額());
        this.setIs高齢者複数世帯(entity.getIs高齢者複数世帯());
        this.setIs所得税課税世帯(entity.getIs所得税課税世帯());
        this.setIs所得税課税者(entity.getIs所得税課税者());
        this.set課税所得額(entity.get課税所得額());
    }

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(被保険者番号, 本人識別コード, 本人課税区分, 利用者負担段階, 配偶者識別コード, 配偶者課税区分, 世帯課税区分, is生活保護受給者, is老齢福祉年金受給者,
                合計所得金額, 年金収入額, 非課税年金勘案額, is高齢者複数世帯, is所得税課税世帯, is所得税課税者, 課税所得額);
    }
}
