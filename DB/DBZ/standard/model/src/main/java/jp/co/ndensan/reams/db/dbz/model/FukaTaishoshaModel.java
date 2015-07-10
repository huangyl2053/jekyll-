/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.model;

import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.TsuchishoNo;
import jp.co.ndensan.reams.db.dbz.entity.relate.FukaTaishoshaRelateEntity;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.Gender;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.shikibetsutaisho.enumeratedtype.JuminShubetsu;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.KojinNo;
import jp.co.ndensan.reams.uz.uza.biz.SetaiCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import static java.util.Objects.requireNonNull;

/**
 * 対象者のモデルです。（賦課系）
 *
 * @author N8156 宮本 康
 */
public class FukaTaishoshaModel {

    private final FukaTaishoshaRelateEntity entity;

    /**
     * コンストラクタです。
     *
     * @param entity 対象者エンティティ
     * @throws NullPointerException 引数がnullの時
     */
    public FukaTaishoshaModel(FukaTaishoshaRelateEntity entity) throws NullPointerException {
        this.entity = requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("対象者エンティティ"));
    }

    /**
     * 調定年度を返します。
     *
     * @return 調定年度
     */
    public FlexibleYear get調定年度() {
        return entity.get賦課検索エンティティ().getChoteiNendo();
    }

    /**
     * 賦課年度を返します。
     *
     * @return 賦課年度
     */
    public FlexibleYear get賦課年度() {
        return entity.get賦課検索エンティティ().getFukaNendo();
    }

    /**
     * 通知書番号を返します。
     *
     * @return 通知書番号
     */
    public TsuchishoNo get通知書番号() {
        return entity.get賦課検索エンティティ().getTsuchishoNo();
    }

    /**
     * 被保険者番号を返します。
     *
     * @return 被保険者番号
     */
    public HihokenshaNo get被保険者番号() {
        return entity.get賦課検索エンティティ().getHihokenshaNo();
    }

    /**
     * 識別コードを返します。
     *
     * @return 識別コード
     */
    public ShikibetsuCode get識別コード() {
        return entity.get住基個人住登内エンティティ().getShikibetsuCode();
    }

    /**
     * 氏名を返します。
     *
     * @return 氏名
     */
    public AtenaMeisho get氏名() {
        return entity.get住基個人住登内エンティティ().getKanjiShimei();
    }

    /**
     * カナ氏名を返します。
     *
     * @return カナ氏名
     */
    public AtenaKanaMeisho getカナ氏名() {
        return entity.get住基個人住登内エンティティ().getKanaShimei();
    }

    /**
     * 性別を返します。
     *
     * @return 性別
     */
    public Gender get性別() {
        return Gender.toValue(entity.get住基個人住登内エンティティ().getSeibetsuCode());
    }

    /**
     * 生年月日を返します。
     *
     * @return 生年月日
     */
    public FlexibleDate get生年月日() {
        return entity.get住基個人住登内エンティティ().getSeinengappiYMD();
    }

    /**
     * 郵便番号を返します。
     *
     * @return 郵便番号
     */
    public YubinNo get郵便番号() {
        return entity.get住基個人住登内エンティティ().getYubinNo();
    }

    /**
     * 住所を返します。
     *
     * @return 住所
     */
    public AtenaJusho get住所() {
        return new AtenaJusho(entity.get住基個人住登内エンティティ().getJusho());
    }

    /**
     * 個人番号を返します。
     *
     * @return 個人番号
     */
    public KojinNo get個人番号() {
        return entity.get住基個人住登内エンティティ().getKojinNo();
    }

    /**
     * 住民種別を返します。
     *
     * @return 住民種別
     */
    public JuminShubetsu get住民種別() {
        return JuminShubetsu.toValue(entity.get住基個人住登内エンティティ().getJuminShubetsuCode());
    }

    /**
     * 世帯コードを返します。
     *
     * @return 世帯コード
     */
    public SetaiCode get世帯コード() {
        return entity.get住基個人住登内エンティティ().getSetaiCode();
    }
}
