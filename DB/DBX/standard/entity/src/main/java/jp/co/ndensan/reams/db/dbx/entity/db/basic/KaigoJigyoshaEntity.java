/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.entity.db.basic;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.KaigoJigyoshaNo;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.OnRshareSchema;

/**
 * 介護事業者マスタの内容を持つエンティティです。
 *
 * @author n2818 西澤 貴幸
 * @jpName 介護事業者エンティティ
 * @bizDomain 介護
 * @category 介護
 * @subCategory 介護事業者
 * @mainClass
 * @reference
 * @deprecated {@link UrT0518KaigoJigyoshaEntity}を使用してください。
 */
//TODO n8178 城間篤人 URドメイン化未対応。修正について介護業務側で預かる予定 2014年3月末
//TODO n3423 樋木隆真 不要クラスのため、施設入退所対応時および、新ビジネス対応時に削除
@OnRshareSchema
public class KaigoJigyoshaEntity {

    /**
     * 事業者番号
     */
    private KaigoJigyoshaNo jigyoshaBango;
    /**
     * 有効開始年月日
     */
    private FlexibleDate yukoKaishiYMD;
    /**
     * 有効終了年月日
     */
    private FlexibleDate yukoShuryoYMD;
    /**
     * 識別コード
     */
    private ShikibetsuCode shikibetsuCd;
    /**
     * 事業者略称
     */
    private RString jigyoshaRyakusho;
    /**
     * 事業者略称カナ
     */
    private RString jigyoshaRyakushoKana;
    /**
     * 事業者住所カナ
     */
    private RString jigyoshaJushoKana;
    /**
     * 異動事由
     */
    private RString idoJiyu;
    /**
     * 異動年月日
     */
    private FlexibleDate idoYMD;
    /**
     * 社会福祉法人軽減対象区分
     */
    private RString 社会福祉法人軽減対象区分;
    /**
     * 地域差区分
     */
    private RString 地域差区分;
    /**
     * 受領委任区分
     */
    private RString 受領委任区分;
    /**
     * 生活保護指定区分
     */
    private RString 生活保護指定区分;
    /**
     * 法人種別
     */
    private RString hojinShubetsu;
    /**
     * 事業開始年月日
     */
    private FlexibleDate jigyoKaishiYMD;
    /**
     * 事業休止年月日
     */
    private FlexibleDate jigyoKyushiYMD;
    /**
     * 事業廃止年月日
     */
    private FlexibleDate jigyoHaishiYMD;
    /**
     * 事業再開年月日
     */
    private FlexibleDate jigyoSaikaiYMD;

    /**
     * 介護事業者エンティティのコンストラクタです。
     *
     * @param jigyoshaBango 事業者番号
     * @param yukoKaishiYMD 有効開始年月日
     * @param yukoShuryoYMD 有効終了年月日
     * @param shikibetsuCd 識別コード
     * @param jigyoshaRyakusho 事業者略称
     * @param jigyoshaRyakushoKana 事業者略称カナ
     * @param jigyoshaJushoKana 事業者住所カナ
     * @param idoJiyu 異動事由
     * @param idoYMD 異動年月日
     * @param 社会福祉法人軽減対象区分 社会福祉法人軽減対象区分
     * @param 地域差区分 地域差区分
     * @param 受領委任区分 受領委任区分
     * @param 生活保護指定区分 生活保護指定区分
     * @param hojinShubetsu 法人区分
     * @param jigyoKaishiYMD 事業開始年月日
     * @param jigyoKyushiYMD 事業休止年月日
     * @param jigyoHaishiYMD 事業廃止年月日
     * @param jigyoSaikaiYMD 事業再開年月日
     */
    public KaigoJigyoshaEntity(KaigoJigyoshaNo jigyoshaBango, FlexibleDate yukoKaishiYMD, FlexibleDate yukoShuryoYMD, ShikibetsuCode shikibetsuCd,
            RString jigyoshaRyakusho, RString jigyoshaRyakushoKana, RString jigyoshaJushoKana,
            RString idoJiyu, FlexibleDate idoYMD, RString 社会福祉法人軽減対象区分, RString 地域差区分, RString 受領委任区分,
            RString 生活保護指定区分, RString hojinShubetsu, FlexibleDate jigyoKaishiYMD, FlexibleDate jigyoKyushiYMD,
            FlexibleDate jigyoHaishiYMD, FlexibleDate jigyoSaikaiYMD) {
        this.jigyoshaBango = requireNonNull(jigyoshaBango, UrSystemErrorMessages.値がnull.getReplacedMessage("jigyoshaBango"));
        this.yukoKaishiYMD = requireNonNull(yukoKaishiYMD, UrSystemErrorMessages.値がnull.getReplacedMessage("yukoKaishiYMD"));
        this.yukoShuryoYMD = requireNonNull(yukoShuryoYMD, UrSystemErrorMessages.値がnull.getReplacedMessage("yukoShuryoYMD"));
        this.shikibetsuCd = requireNonNull(shikibetsuCd, UrSystemErrorMessages.値がnull.getReplacedMessage("shikibetsuCd"));
        this.jigyoshaRyakusho = requireNonNull(jigyoshaRyakusho, UrSystemErrorMessages.値がnull.getReplacedMessage("jigyoshaRyakusho"));
        this.jigyoshaRyakushoKana = requireNonNull(jigyoshaRyakushoKana, UrSystemErrorMessages.値がnull.getReplacedMessage("jigyoshaRyakushoKana"));
        this.jigyoshaJushoKana = requireNonNull(jigyoshaJushoKana, UrSystemErrorMessages.値がnull.getReplacedMessage("jigyoshaJushoKana"));
        this.idoJiyu = requireNonNull(idoJiyu, UrSystemErrorMessages.値がnull.getReplacedMessage("idoJiyu"));
        this.idoYMD = requireNonNull(idoYMD, UrSystemErrorMessages.値がnull.getReplacedMessage("idoYMD"));
        this.社会福祉法人軽減対象区分 = requireNonNull(社会福祉法人軽減対象区分, UrSystemErrorMessages.値がnull.getReplacedMessage("社会福祉法人軽減対象区分"));
        this.地域差区分 = requireNonNull(地域差区分, UrSystemErrorMessages.値がnull.getReplacedMessage("地域差区分"));
        this.受領委任区分 = requireNonNull(受領委任区分, UrSystemErrorMessages.値がnull.getReplacedMessage("受領委任区分"));
        this.生活保護指定区分 = requireNonNull(生活保護指定区分, UrSystemErrorMessages.値がnull.getReplacedMessage("生活保護指定区分"));
        this.hojinShubetsu = requireNonNull(hojinShubetsu, UrSystemErrorMessages.値がnull.getReplacedMessage("hojinShubetsu"));
        this.jigyoKaishiYMD = requireNonNull(jigyoKaishiYMD, UrSystemErrorMessages.値がnull.getReplacedMessage("jigyoKaishiYMD"));
        this.jigyoKyushiYMD = requireNonNull(jigyoKyushiYMD, UrSystemErrorMessages.値がnull.getReplacedMessage("jigyoKyushiYMD"));
        this.jigyoHaishiYMD = requireNonNull(jigyoHaishiYMD, UrSystemErrorMessages.値がnull.getReplacedMessage("jigyoHaishiYMD"));
        this.jigyoSaikaiYMD = requireNonNull(jigyoSaikaiYMD, UrSystemErrorMessages.値がnull.getReplacedMessage("jigyoSaikaiYMD"));
    }

    /**
     * 事業者番号を返します。
     *
     * @return jigyoshaBango
     */
    public KaigoJigyoshaNo get事業者番号() {
        return jigyoshaBango;
    }

    /**
     * 有効開始年月日を返します。
     *
     * @return yukoKaishiYMD
     */
    public FlexibleDate get有効開始年月日() {
        return yukoKaishiYMD;
    }

    /**
     * 有効終了年月日を返します。
     *
     * @return yukoShuryoYMD
     */
    public FlexibleDate get有効終了年月日() {
        return yukoShuryoYMD;
    }

    /**
     * 識別コードを返します。
     *
     * @return shikibetsuCd
     */
    public ShikibetsuCode get識別コード() {
        return shikibetsuCd;
    }

    /**
     * 事業者略称を返します。
     *
     * @return jigyoshaRyakusyo
     */
    public RString get事業者略称() {
        return jigyoshaRyakusho;
    }

    /**
     * 事業者略称カナを返します。
     *
     * @return jigyoshaRyakushoKana
     */
    public RString get事業者略称カナ() {
        return jigyoshaRyakushoKana;
    }

    /**
     * 事業者住所カナを返します。
     *
     * @return jigyoshaJushoKana
     */
    public RString get事業者住所カナ() {
        return jigyoshaJushoKana;
    }

    /**
     * 異動事由を返します。
     *
     * @return idoJiyu
     */
    public RString get異動事由() {
        return idoJiyu;
    }

    /**
     * 異動年月日を返します。
     *
     * @return idoYMD
     */
    public FlexibleDate get異動年月日() {
        return idoYMD;
    }

    /**
     * 社会福祉法人軽減対象区分を返します。
     *
     * @return 社会福祉法人軽減対象区分
     */
    public RString get社会福祉法人軽減対象区分() {
        return 社会福祉法人軽減対象区分;
    }

    /**
     * 地域差区分を返します。
     *
     * @return 地域差区分
     */
    public RString get地域差区分() {
        return 地域差区分;
    }

    /**
     * 受領委任区分を返します。
     *
     * @return 受領委任区分
     */
    public RString get受領委任区分() {
        return 受領委任区分;
    }

    /**
     * 生活保護指定区分を返します。
     *
     * @return 生活保護指定区分
     */
    public RString get生活保護指定区分() {
        return 生活保護指定区分;
    }

    /**
     * 法人種別を返します。
     *
     * @return hojinShubetsu
     */
    public RString get法人種別() {
        return hojinShubetsu;
    }

    /**
     * 事業開始年月日を返します。
     *
     * @return jigyoKaishiYMD
     */
    public FlexibleDate get事業開始年月日() {
        return jigyoKaishiYMD;
    }

    /**
     * 事業休止年月日を返します。
     *
     * @return jigyoKyushiYMD
     */
    public FlexibleDate get事業休止年月日() {
        return jigyoKyushiYMD;
    }

    /**
     * 事業廃止年月日を返します。
     *
     * @return jigyoHaishiYMD
     */
    public FlexibleDate get事業廃止年月日() {
        return jigyoHaishiYMD;
    }

    /**
     * 事業再開年月日を返します。
     *
     * @return jigyoSaikaiYMD
     */
    public FlexibleDate get事業再開年月日() {
        return jigyoSaikaiYMD;
    }
}
