/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.entity.db.relate.genendoidoukekkaichiran;

import jp.co.ndensan.reams.db.dbb.entity.db.basic.DbT2015KeisangoJohoEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.TsuchishoNo;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt200FindShikibetsuTaishoEntity;
import jp.co.ndensan.reams.ua.uax.entity.db.relate.KozaRelateEntity;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.SetaiCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 賦課の計算結果と、宛名口座情報を結びつけたEntity
 *
 * @reamsid_L DBB-0930-030 sunhui
 */
@lombok.Getter
@lombok.Setter
public class KeisanjohoAtenaKozaEntity {

    private UaFt200FindShikibetsuTaishoEntity 宛名Entity;
    private KozaRelateEntity 口座Entity;

    private FlexibleYear 調定年度;
    private FlexibleYear 賦課年度;
    private TsuchishoNo 通知書番号;

    private RString 更正前後区分;
    private RString 作成処理名;
    private int 賦課履歴番号;
    private HihokenshaNo 被保険者番号;
    private ShikibetsuCode 識別コード;
    private SetaiCode 世帯コード;
    private int 世帯員数;
    private FlexibleDate 資格取得日;
    private RString 資格取得事由;
    private FlexibleDate 資格喪失日;
    private RString 資格喪失事由;
    private RString 生活保護扶助種類;
    private FlexibleDate 生保開始日;
    private FlexibleDate 生保廃止日;
    private FlexibleDate 老齢開始日;
    private FlexibleDate 老齢廃止日;
    private FlexibleDate 賦課期日;
    private RString 課税区分;
    private RString 世帯課税区分;
    private Decimal 合計所得金額;
    private Decimal 公的年金収入額;
    private RString 保険料段階;
    private RString 保険料算定段階1;
    private Decimal 算定年額保険料1;
    private FlexibleYearMonth 月割開始年月1;
    private FlexibleYearMonth 月割終了年月1;
    private RString 保険料算定段階2;
    private Decimal 算定年額保険料2;
    private FlexibleYearMonth 月割開始年月2;
    private FlexibleYearMonth 月割終了年月2;
    private YMDHMS 調定日時;
    private RString 調定事由1;
    private RString 調定事由2;
    private RString 調定事由3;
    private RString 調定事由4;
    private RString 更正月;
    private Decimal 減免前介護保険料_年額;
    private Decimal 減免額;
    private Decimal 確定介護保険料_年額;
    private RString 保険料段階_仮算定時;
    private int 徴収方法履歴番号;
    private YMDHMS 異動基準日時;
    private RString 口座区分;
    private RString 境界層区分;
    private RString 職権区分;
    private LasdecCode 賦課市町村コード;
    private Decimal 特徴歳出還付額;
    private Decimal 普徴歳出還付額;
    private Decimal 特徴期別金額01;
    private Decimal 特徴期別金額02;
    private Decimal 特徴期別金額03;
    private Decimal 特徴期別金額04;
    private Decimal 特徴期別金額05;
    private Decimal 特徴期別金額06;
    private Decimal 普徴期別金額01;
    private Decimal 普徴期別金額02;
    private Decimal 普徴期別金額03;
    private Decimal 普徴期別金額04;
    private Decimal 普徴期別金額05;
    private Decimal 普徴期別金額06;
    private Decimal 普徴期別金額07;
    private Decimal 普徴期別金額08;
    private Decimal 普徴期別金額09;
    private Decimal 普徴期別金額10;
    private Decimal 普徴期別金額11;
    private Decimal 普徴期別金額12;
    private Decimal 普徴期別金額13;
    private Decimal 普徴期別金額14;
    private RString 徴収方法4月;
    private RString 徴収方法5月;
    private RString 徴収方法6月;
    private RString 徴収方法7月;
    private RString 徴収方法8月;
    private RString 徴収方法9月;
    private RString 徴収方法10月;
    private RString 徴収方法11月;
    private RString 徴収方法12月;
    private RString 徴収方法1月;
    private RString 徴収方法2月;
    private RString 徴収方法3月;
    private RString 徴収方法翌4月;
    private RString 徴収方法翌5月;
    private RString 徴収方法翌6月;
    private RString 徴収方法翌7月;
    private RString 徴収方法翌8月;
    private RString 徴収方法翌9月;
    private RString 仮徴収_基礎年金番号;
    private RString 仮徴収_年金コード;
    private RString 仮徴収_捕捉月;
    private RString 本徴収_基礎年金番号;
    private RString 本徴収_年金コード;
    private RString 本徴収_捕捉月;
    private RString 翌年度仮徴収_基礎年金番号;
    private RString 翌年度仮徴収_年金コード;
    private RString 翌年度仮徴収_捕捉月;
    private boolean 依頼情報送付済みフラグ;
    private boolean 追加依頼情報送付済みフラグ;
    private YMDHMS 特別徴収停止日時;
    private RString 特別徴収停止事由コード;
    private Decimal 特徴収入額01;
    private Decimal 特徴収入額02;
    private Decimal 特徴収入額03;
    private Decimal 特徴収入額04;
    private Decimal 特徴収入額05;
    private Decimal 特徴収入額06;
    private Decimal 普徴収入額01;
    private Decimal 普徴収入額02;
    private Decimal 普徴収入額03;
    private Decimal 普徴収入額04;
    private Decimal 普徴収入額05;
    private Decimal 普徴収入額06;
    private Decimal 普徴収入額07;
    private Decimal 普徴収入額08;
    private Decimal 普徴収入額09;
    private Decimal 普徴収入額10;
    private Decimal 普徴収入額11;
    private Decimal 普徴収入額12;
    private Decimal 普徴収入額13;
    private Decimal 普徴収入額14;

    /**
     * KeisangojohoAtenaKozaEntityのコンストラクタ
     *
     */
    public KeisanjohoAtenaKozaEntity() {
    }

    /**
     * KeisangojohoAtenaKozaEntityのコンストラクタ
     *
     * @param 計算後情報 DbT2015KeisangoJohoEntity
     * @param 宛名Entity UaFt200FindShikibetsuTaishoEntity
     * @param 口座Entity UaFt310FindKozaEntity
     */
    public KeisanjohoAtenaKozaEntity(DbT2015KeisangoJohoEntity 計算後情報, UaFt200FindShikibetsuTaishoEntity 宛名Entity, KozaRelateEntity 口座Entity) {
        this.宛名Entity = 宛名Entity;
        this.口座Entity = 口座Entity;
        this.調定年度 = 計算後情報.getChoteiNendo();
        this.賦課年度 = 計算後情報.getFukaNendo();
        this.通知書番号 = 計算後情報.getTsuchishoNo();
        this.更正前後区分 = 計算後情報.getKoseiZengoKubun();
        this.作成処理名 = 計算後情報.getSakuseiShoriName();
        this.賦課履歴番号 = 計算後情報.getFukaRirekiNo();
        this.被保険者番号 = 計算後情報.getHihokenshaNo();
        this.識別コード = 計算後情報.getShikibetsuCode();
        this.世帯コード = 計算後情報.getSetaiCode();
        this.世帯員数 = 計算後情報.getSetaiInsu();
        this.資格取得日 = 計算後情報.getShikakuShutokuYMD();
        this.資格取得事由 = 計算後情報.getShikakuShutokuJiyu();
        this.資格喪失日 = 計算後情報.getShikakuSoshitsuYMD();
        this.資格喪失事由 = 計算後情報.getShikakuSoshitsuJiyu();
        this.生活保護扶助種類 = 計算後情報.getSeihofujoShurui();
        this.生保開始日 = 計算後情報.getSeihoKaishiYMD();
        this.生保廃止日 = 計算後情報.getSeihoHaishiYMD();
        this.老齢開始日 = 計算後情報.getRonenKaishiYMD();
        this.老齢廃止日 = 計算後情報.getRonenHaishiYMD();
        this.賦課期日 = 計算後情報.getFukaYMD();
        this.課税区分 = 計算後情報.getKazeiKubun();
        this.世帯課税区分 = 計算後情報.getSetaikazeiKubun();
        this.合計所得金額 = 計算後情報.getGokeiShotokuGaku();
        this.公的年金収入額 = 計算後情報.getNenkinShunyuGaku();
        this.保険料段階 = 計算後情報.getHokenryoDankai();
        this.保険料算定段階1 = 計算後情報.getHokenryoDankai1();
        this.算定年額保険料1 = 計算後情報.getNengakuHokenryo1();
        this.月割開始年月1 = 計算後情報.getTsukiwariStartYM1();
        this.月割終了年月1 = 計算後情報.getTsukiwariEndYM1();
        this.保険料算定段階2 = 計算後情報.getHokenryoDankai2();
        this.算定年額保険料2 = 計算後情報.getNengakuHokenryo2();
        this.月割開始年月2 = 計算後情報.getTsukiwariStartYM2();
        this.月割終了年月2 = 計算後情報.getTsukiwariEndYM2();
        this.調定日時 = 計算後情報.getChoteiNichiji();
        this.調定事由1 = 計算後情報.getChoteiJiyu1();
        this.調定事由2 = 計算後情報.getChoteiJiyu2();
        this.調定事由3 = 計算後情報.getChoteiJiyu3();
        this.調定事由4 = 計算後情報.getChoteiJiyu4();
        this.更正月 = 計算後情報.getKoseiM();
        this.減免前介護保険料_年額 = 計算後情報.getGemmenMaeHokenryo();
        this.減免額 = 計算後情報.getGemmenGaku();
        this.確定介護保険料_年額 = 計算後情報.getKakuteiHokenryo();
        this.保険料段階_仮算定時 = 計算後情報.getHokenryoDankaiKarisanntei();
        this.徴収方法履歴番号 = 計算後情報.getChoshuHohoRirekiNo();
        this.異動基準日時 = 計算後情報.getIdoKijunNichiji();
        this.口座区分 = 計算後情報.getKozaKubun();
        this.境界層区分 = 計算後情報.getKyokaisoKubun();
        this.職権区分 = 計算後情報.getShokkenKubun();
        this.賦課市町村コード = 計算後情報.getFukaShichosonCode();
        this.特徴歳出還付額 = 計算後情報.getTkSaishutsuKampuGaku();
        this.普徴歳出還付額 = 計算後情報.getFuSaishutsuKampuGaku();
        this.特徴期別金額01 = 計算後情報.getTkKibetsuGaku01();
        this.特徴期別金額02 = 計算後情報.getTkKibetsuGaku02();
        this.特徴期別金額03 = 計算後情報.getTkKibetsuGaku03();
        this.特徴期別金額04 = 計算後情報.getTkKibetsuGaku04();
        this.特徴期別金額05 = 計算後情報.getTkKibetsuGaku05();
        this.特徴期別金額06 = 計算後情報.getTkKibetsuGaku06();
        this.普徴期別金額01 = 計算後情報.getFuKibetsuGaku01();
        this.普徴期別金額02 = 計算後情報.getFuKibetsuGaku02();
        this.普徴期別金額03 = 計算後情報.getFuKibetsuGaku03();
        this.普徴期別金額04 = 計算後情報.getFuKibetsuGaku04();
        this.普徴期別金額05 = 計算後情報.getFuKibetsuGaku05();
        this.普徴期別金額06 = 計算後情報.getFuKibetsuGaku06();
        this.普徴期別金額07 = 計算後情報.getFuKibetsuGaku07();
        this.普徴期別金額08 = 計算後情報.getFuKibetsuGaku08();
        this.普徴期別金額09 = 計算後情報.getFuKibetsuGaku09();
        this.普徴期別金額10 = 計算後情報.getFuKibetsuGaku10();
        this.普徴期別金額11 = 計算後情報.getFuKibetsuGaku11();
        this.普徴期別金額12 = 計算後情報.getFuKibetsuGaku12();
        this.普徴期別金額13 = 計算後情報.getFuKibetsuGaku13();
        this.普徴期別金額14 = 計算後情報.getFuKibetsuGaku14();
        this.徴収方法4月 = 計算後情報.getChoshuHoho4gatsu();
        this.徴収方法5月 = 計算後情報.getChoshuHoho5gatsu();
        this.徴収方法6月 = 計算後情報.getChoshuHoho6gatsu();
        this.徴収方法7月 = 計算後情報.getChoshuHoho7gatsu();
        this.徴収方法8月 = 計算後情報.getChoshuHoho8gatsu();
        this.徴収方法9月 = 計算後情報.getChoshuHoho9gatsu();
        this.徴収方法10月 = 計算後情報.getChoshuHoho10gatsu();
        this.徴収方法11月 = 計算後情報.getChoshuHoho11gatsu();
        this.徴収方法12月 = 計算後情報.getChoshuHoho12gatsu();
        this.徴収方法1月 = 計算後情報.getChoshuHoho1gatsu();
        this.徴収方法2月 = 計算後情報.getChoshuHoho2gatsu();
        this.徴収方法3月 = 計算後情報.getChoshuHoho3gatsu();
        this.徴収方法翌4月 = 計算後情報.getChoshuHohoYoku4gatsu();
        this.徴収方法翌5月 = 計算後情報.getChoshuHohoYoku5gatsu();
        this.徴収方法翌6月 = 計算後情報.getChoshuHohoYoku6gatsu();
        this.徴収方法翌7月 = 計算後情報.getChoshuHohoYoku7gatsu();
        this.徴収方法翌8月 = 計算後情報.getChoshuHohoYoku8gatsu();
        this.徴収方法翌9月 = 計算後情報.getChoshuHohoYoku9gatsu();
        this.仮徴収_基礎年金番号 = 計算後情報.getKariNenkinNo();
        this.仮徴収_年金コード = 計算後情報.getKariNenkinCode();
        this.仮徴収_捕捉月 = 計算後情報.getKariHosokuM();
        this.本徴収_基礎年金番号 = 計算後情報.getHonNenkinNo();
        this.本徴収_年金コード = 計算後情報.getHonNenkinCode();
        this.本徴収_捕捉月 = 計算後情報.getHonHosokuM();
        this.翌年度仮徴収_基礎年金番号 = 計算後情報.getYokunendoKariNenkinNo();
        this.翌年度仮徴収_年金コード = 計算後情報.getYokunendoKariNenkinCode();
        this.翌年度仮徴収_捕捉月 = 計算後情報.getYokunendoKariHosokuM();
        this.依頼情報送付済みフラグ = 計算後情報.getIraiSohuzumiFlag();
        this.追加依頼情報送付済みフラグ = 計算後情報.getTsuikaIraiSohuzumiFlag();
        this.特別徴収停止日時 = 計算後情報.getTokuchoTeishiNichiji();
        this.特別徴収停止事由コード = 計算後情報.getTokuchoTeishiJiyuCode();
        this.特徴収入額01 = 計算後情報.getTkShunyuGaku01();
        this.特徴収入額02 = 計算後情報.getTkShunyuGaku02();
        this.特徴収入額03 = 計算後情報.getTkShunyuGaku03();
        this.特徴収入額04 = 計算後情報.getTkShunyuGaku04();
        this.特徴収入額05 = 計算後情報.getTkShunyuGaku05();
        this.特徴収入額06 = 計算後情報.getTkShunyuGaku06();
        this.普徴収入額01 = 計算後情報.getFuShunyuGaku01();
        this.普徴収入額02 = 計算後情報.getFuShunyuGaku02();
        this.普徴収入額03 = 計算後情報.getFuShunyuGaku03();
        this.普徴収入額04 = 計算後情報.getFuShunyuGaku04();
        this.普徴収入額05 = 計算後情報.getFuShunyuGaku05();
        this.普徴収入額06 = 計算後情報.getFuShunyuGaku06();
        this.普徴収入額07 = 計算後情報.getFuShunyuGaku07();
        this.普徴収入額08 = 計算後情報.getFuShunyuGaku08();
        this.普徴収入額09 = 計算後情報.getFuShunyuGaku09();
        this.普徴収入額10 = 計算後情報.getFuShunyuGaku10();
        this.普徴収入額11 = 計算後情報.getFuShunyuGaku11();
        this.普徴収入額12 = 計算後情報.getFuShunyuGaku12();
        this.普徴収入額13 = 計算後情報.getFuShunyuGaku13();
        this.普徴収入額14 = 計算後情報.getFuShunyuGaku14();
    }

}
