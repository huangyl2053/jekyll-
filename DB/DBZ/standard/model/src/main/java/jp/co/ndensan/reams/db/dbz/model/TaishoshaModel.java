/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.model;

import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.HihoKubun;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.JushochitokureishaKubun;
import jp.co.ndensan.reams.db.dbz.definition.util.optional.Optional;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbV7901ShikakuSearchEntity;
import jp.co.ndensan.reams.db.dbz.entity.relate.TaishoshaRelateEntity;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.KojinNo;
import jp.co.ndensan.reams.uz.uza.biz.SetaiCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.ShikibetsuTaishoFactory;
import jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.Gender;
import jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.JuminShubetsu;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;

/**
 * 対象者のモデルです。（資格系）
 *
 * @author N8156 宮本 康
 */
public class TaishoshaModel {

    private final TaishoshaRelateEntity entity;

    /**
     * コンストラクタです。
     *
     * @param entity 対象者エンティティ
     * @throws NullPointerException 引数がnullの時
     */
    public TaishoshaModel(TaishoshaRelateEntity entity) throws NullPointerException {
        this.entity = requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("対象者エンティティ"));
    }

    /**
     * 被保険者番号を返します。
     *
     * @return 被保険者番号
     */
    public HihokenshaNo get被保険者番号() {
        return entity.get資格検索エンティティ().getHihokenshaNo();
    }

    /**
     * 識別コードを返します。
     *
     * @return 識別コード
     */
    public ShikibetsuCode get識別コード() {
        return ShikibetsuTaishoFactory.createKojin(entity.get住基個人住登外エンティティ()).get識別コード();
//        return entity.get住基個人住登外エンティティ().getShikibetsuCode();
    }

    /**
     * 被保区分を返します。
     *
     * @return 被保区分
     */
    public HihoKubun get被保区分() {

        DbV7901ShikakuSearchEntity shikakuEntity = entity.get資格検索エンティティ();

        Optional<RString> 適用除外適用事由コード = Optional.ofNullable(shikakuEntity.getTekiyoJogaiTekiyoJiyuCode());
        Optional<RString> 他市町村住所地特例適用事由コード = Optional.ofNullable(shikakuEntity.getTatokureiTekiyoJiyuCode());
        JushochitokureishaKubun 住所地特例フラグ = JushochitokureishaKubun.toValue(shikakuEntity.getJushochiTokureiFlag());
        Optional<HihokenshaNo> 被保険者番号 = Optional.ofNullable(shikakuEntity.getHihokenshaNo());
        Optional<FlexibleDate> 資格喪失日 = Optional.ofNullable(shikakuEntity.getShikakuSoshitsuYMD());

        if (適用除外適用事由コード.isPresent()) {
            return HihoKubun.適除;
        } else if (他市町村住所地特例適用事由コード.isPresent()) {
            return HihoKubun.他住;
        } else if (住所地特例フラグ == JushochitokureishaKubun.住所地特例者) {
            return HihoKubun.自住;
        } else if (被保険者番号.isPresent() && !資格喪失日.isPresent()) {
            return HihoKubun.資格;
        }

        return HihoKubun.UNKNOWN;
    }

    /**
     * 氏名を返します。
     *
     * @return 氏名
     */
    public AtenaMeisho get氏名() {
        return ShikibetsuTaishoFactory.createKojin(entity.get住基個人住登外エンティティ()).get名称().getName();
//        return entity.get住基個人住登外エンティティ().getKanjiShimei();
    }

    /**
     * カナ氏名を返します。
     *
     * @return カナ氏名
     */
    public AtenaKanaMeisho getカナ氏名() {
        return ShikibetsuTaishoFactory.createKojin(entity.get住基個人住登外エンティティ()).get名称().getKana();
//        return entity.get住基個人住登外エンティティ().getKanaShimei();
    }

    /**
     * 性別を返します。
     *
     * @return 性別
     */
    public Gender get性別() {
        return ShikibetsuTaishoFactory.createKojin(entity.get住基個人住登外エンティティ()).get性別();
//        return Gender.toValue(entity.get住基個人住登外エンティティ().getSeibetsuCode());
    }

    /**
     * 生年月日を返します。
     *
     * @return 生年月日
     */
    public FlexibleDate get生年月日() {
        return ShikibetsuTaishoFactory.createKojin(entity.get住基個人住登外エンティティ()).get生年月日().toFlexibleDate();
//        return entity.get住基個人住登外エンティティ().getSeinengappiYMD();
    }

    /**
     * 郵便番号を返します。
     *
     * @return 郵便番号
     */
    public YubinNo get郵便番号() {
        return ShikibetsuTaishoFactory.createKojin(entity.get住基個人住登外エンティティ()).get住所().get郵便番号();
//        return entity.get住基個人住登外エンティティ().getYubinNo();
    }

    /**
     * 住所を返します。
     *
     * @return 住所
     */
    public AtenaJusho get住所() {
        return new AtenaJusho(ShikibetsuTaishoFactory.createKojin(entity.get住基個人住登外エンティティ()).get住所().get住所());
//        return entity.get住基個人住登外エンティティ().getJusho();
    }

    /**
     * 個人番号を返します。
     *
     * @return 個人番号
     */
    public KojinNo get個人番号() {
        return ShikibetsuTaishoFactory.createKojin(entity.get住基個人住登外エンティティ()).get個人番号();
//        return entity.get住基個人住登外エンティティ().getKojinNo();
    }

    /**
     * 住民種別を返します。
     *
     * @return 住民種別
     */
    public JuminShubetsu get住民種別() {
        return ShikibetsuTaishoFactory.createKojin(entity.get住基個人住登外エンティティ()).get住民種別();
//        return JuminShubetsu.toValue(entity.get住基個人住登外エンティティ().getJuminShubetsuCode());
    }

    /**
     * 世帯コードを返します。
     *
     * @return 世帯コード
     */
    public SetaiCode get世帯コード() {
        return ShikibetsuTaishoFactory.createKojin(entity.get住基個人住登外エンティティ()).get世帯コード();
//        return entity.get住基個人住登外エンティティ().getSetaiCode();
    }
}
