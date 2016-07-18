/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.iraishoikkatsuhakko;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbe.business.core.ikenshokinyuyoshi.IkenshokinyuyoshiBusiness;
import jp.co.ndensan.reams.db.dbe.business.report.ikenshosakuseiiraiichiranhyo.IkenshoSakuseiIraiIchiranhyoItem;
import jp.co.ndensan.reams.db.dbe.business.report.shujiiikensho.ShujiiIkenshoSakuseiIraishoItem;
import jp.co.ndensan.reams.db.dbe.business.report.shujiiikenshosakusei.ShujiiIkenshoSakuseiRyoSeikyushoItem;
import jp.co.ndensan.reams.db.dbe.business.report.shujiiikenshoteishutsuiraisho.ShujiiIkenshoTeishutsuIraishoItem;
import jp.co.ndensan.reams.db.dbe.definition.batchprm.iraisho.GridParameter;
import jp.co.ndensan.reams.db.dbe.definition.core.chosa.ChohyoAtesakiKeisho;
import jp.co.ndensan.reams.db.dbe.definition.core.reportid.ReportIdDBE;
import jp.co.ndensan.reams.db.dbe.definition.processprm.hakkoichiranhyo.ShujiiIkenshoTeishutsuIraishoHakkoProcessParamter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.hakkoichiranhyo.ShujiiIkenshoTeishutsuIraishoHakkoRelateEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.shujiiikenshoseikyuichiran.ShujiiIkenshoSeikyuIchiranEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBE;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.definition.core.ikenshosakuseiryo.IkenshoSakuseiRyo;
import jp.co.ndensan.reams.db.dbz.definition.core.seibetsu.Seibetsu;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ikensho.IkenshoIraiKubun;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ikensho.IkenshoSakuseiKaisuKubun;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ikensho.SakuseiryoSeikyuKubun;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ikensho.ZaitakuShisetsuKubun;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.NinteiShinseiShinseijiKubunCode;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5301ShujiiIkenshoIraiJohoEntity;
import jp.co.ndensan.reams.ur.urz.business.report.outputjokenhyo.ReportOutputJokenhyoItem;
import jp.co.ndensan.reams.ur.urz.entity.report.parts.ninshosha.NinshoshaSource;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.report.util.barcode.CustomerBarCode;
import jp.co.ndensan.reams.uz.uza.report.util.barcode.CustomerBarCodeResult;

/**
 *
 * バッチ設計_DBE240002_主治医意見書提出依頼書発行のRelateBusinessクラスです。
 *
 * @reamsid_L DBE-0080-130 duanzhanli
 */
public class IraishoIkkatsuHakkoBusiness {

    private static final RString 文字列0 = new RString("0");
    private static final RString 文字列1 = new RString("1");
    private static final RString 文字列2 = new RString("2");
    private static final RString DATE_時 = new RString("時");
    private static final RString DATE_分 = new RString("分");
    private static final RString DATE_秒 = new RString("秒");
    private static final RString 記号_星 = new RString("*");
    private static final RString 元号_明治 = new RString("明治");
    private static final RString 元号_大正 = new RString("大正");
    private static final RString 元号_昭和 = new RString("昭和");
    private static final RString 記号 = new RString("✔");
    private int 宛名連番 = 1;
    private int 連番 = 1;
    private static final int INT3 = 3;
    private static final int INT4 = 4;
    private static final int INT5 = 5;
    private static final int INT6 = 6;
    private static final int INT7 = 7;
    private static final int INT8 = 8;
    private static final int INT9 = 9;
    private static final int INT10 = 10;
    private static final RString IRAIFROMYMD = new RString("【依頼開始日】");
    private static final RString IRAITOYMD = new RString("【依頼終了日】");
    private static final RString SHUJIIIKENSHOSAKUSEIIRAI = new RString("【主治医意見書作成依頼印刷区分】");
    private static final RString SHUJIIIKENSHO = new RString("【意見書印刷区分】");
    private static final RString SHUJIIIKENSHOSAKUSEIIRAILIST = new RString("【主治医意見書作成依頼リスト】");
    private static final RString SHUJIIIRYOKIKANCODE = new RString("　　【主治医医療機関コード】");
    private static final RString ISHINO = new RString("　　【主治医コード】");
    private static final RString SHOKISAIHOKENSHANO = new RString("　　【証記載保険者番号】");
    private static final RString HAKKOBI = new RString("【発行日】");
    private static final RString TEISHUTSUKIGEN = new RString("【提出期限】");
    private static final RString KYOTSUHIZUKE = new RString("【共通日付】");
    private static final RString IKENSHOSAKUSEIIRAI = new RString("【主治医意見書作成依頼一覧表出力区分】");
    private static final RString IKENSHOSAKUSEISEIKYUU = new RString("【主治医意見書作成料請求一覧表出力区分】");
    private static final RString SHUJIIIKENSHOSAKUSEIIRAISHO = new RString("【主治医意見書作成依頼書出力区分】");
    private static final RString IKENSHOKINYUU = new RString("【主治医意見書記入用紙出力区分】");
    private static final RString IKENSHOKINYUUOCR = new RString("【主治医意見書記入用紙OCR出力区分】");
    private static final RString IKENSHOSAKUSEISEIKYUUSHO = new RString("【主治医意見書作成料請求書出力区分】");
    private static final RString IKENSHOTEISHUTU = new RString("【介護保険指定医依頼兼主治医意見書提出意見依頼書出力区分】");
    private final ShujiiIkenshoTeishutsuIraishoHakkoRelateEntity entity;
    private final ShujiiIkenshoTeishutsuIraishoHakkoProcessParamter processParamter;
    private final RDate 基準日;

    /**
     * コンストラクタです。
     *
     * @param entity DBより取得した{@link ShujiiIkenshoTeishutsuIraishoHakkoRelateEntity}
     * @param processParamter DBより取得した{@link ShujiiIkenshoTeishutsuIraishoHakkoProcessParamter}
     */
    public IraishoIkkatsuHakkoBusiness(ShujiiIkenshoTeishutsuIraishoHakkoRelateEntity entity,
            ShujiiIkenshoTeishutsuIraishoHakkoProcessParamter processParamter) {
        this.entity = entity;
        this.processParamter = processParamter;
        this.基準日 = RDate.getNowDate();
    }

    /**
     * 帳票「DBE231014_主治医意見書記入用紙」Entityデータを作成するメッソドです。
     *
     * @return ShujiiIkenshoTeishutsuIraishoItem
     */
    public IkenshokinyuyoshiBusiness setDBE231014Item() {
        List<RString> 保険者番号リスト = get被保険者番号(entity.get証記載保険者番号());
        List<RString> 被保険者番号リスト = get被保険者番号(entity.get被保険者番号());
        IkenshokinyuyoshiBusiness item = new IkenshokinyuyoshiBusiness();
        item.setHokenshaNo1(保険者番号リスト.get(0));
        item.setHokenshaNo2(保険者番号リスト.get(1));
        item.setHokenshaNo3(保険者番号リスト.get(2));
        item.setHokenshaNo4(保険者番号リスト.get(INT3));
        item.setHokenshaNo5(保険者番号リスト.get(INT4));
        item.setHokenshaNo6(保険者番号リスト.get(INT5));
        item.setHihokenshaNo1(被保険者番号リスト.get(0));
        item.setHihokenshaNo2(被保険者番号リスト.get(1));
        item.setHihokenshaNo3(被保険者番号リスト.get(2));
        item.setHihokenshaNo4(被保険者番号リスト.get(INT3));
        item.setHihokenshaNo5(被保険者番号リスト.get(INT4));
        item.setHihokenshaNo6(被保険者番号リスト.get(INT5));
        item.setHihokenshaNo7(被保険者番号リスト.get(INT6));
        item.setHihokenshaNo8(被保険者番号リスト.get(INT7));
        item.setHihokenshaNo9(被保険者番号リスト.get(INT8));
        item.setHihokenshaNo10(被保険者番号リスト.get(INT9));
        RString ninteiShinseiDay = new FlexibleDate(entity.get認定申請年月日()).wareki().eraType(EraType.ALPHABET).firstYear(FirstYear.ICHI_NEN)
                .separator(Separator.SLASH).fillType(FillType.ZERO).toDateString();
        item.setShinseiYY1(ninteiShinseiDay.substring(1, 2));
        item.setShinseiYY2(ninteiShinseiDay.substring(2, INT3));
        item.setShinseiMM1(ninteiShinseiDay.substring(INT4, INT5));
        item.setShinseiMM2(ninteiShinseiDay.substring(INT5, INT6));
        item.setShinseiDD1(ninteiShinseiDay.substring(INT7, INT8));
        item.setShinseiDD2(ninteiShinseiDay.substring(INT8));
        return item;
    }

    /**
     * 帳票「DBE231012_主治医意見書記入用紙」Entityデータを作成するメッソドです。
     *
     * @return ShujiiIkenshoTeishutsuIraishoItem
     */
    public IkenshokinyuyoshiBusiness setDBE231012Item() {
        List<RString> 保険者番号リスト = get被保険者番号(entity.get証記載保険者番号());
        List<RString> 被保険者番号リスト = get被保険者番号(entity.get被保険者番号());
        RString 生年月日 = entity.get生年月日();
        RString 年号 = new FlexibleDate(生年月日).wareki().eraType(EraType.KANJI).toDateString();
        IkenshokinyuyoshiBusiness item = new IkenshokinyuyoshiBusiness();
        item.setHokenshaNo1(保険者番号リスト.get(0));
        item.setHokenshaNo2(保険者番号リスト.get(1));
        item.setHokenshaNo3(保険者番号リスト.get(2));
        item.setHokenshaNo4(保険者番号リスト.get(INT3));
        item.setHokenshaNo5(保険者番号リスト.get(INT4));
        item.setHokenshaNo6(保険者番号リスト.get(INT5));
        item.setHihokenshaNo1(被保険者番号リスト.get(0));
        item.setHihokenshaNo2(被保険者番号リスト.get(1));
        item.setHihokenshaNo3(被保険者番号リスト.get(2));
        item.setHihokenshaNo4(被保険者番号リスト.get(INT3));
        item.setHihokenshaNo5(被保険者番号リスト.get(INT4));
        item.setHihokenshaNo6(被保険者番号リスト.get(INT5));
        item.setHihokenshaNo7(被保険者番号リスト.get(INT6));
        item.setHihokenshaNo8(被保険者番号リスト.get(INT7));
        item.setHihokenshaNo9(被保険者番号リスト.get(INT8));
        item.setHihokenshaNo10(被保険者番号リスト.get(INT9));
        item.setHihokenshaNameKana(entity.get被保険者氏名カナ());
        item.setHihokenshaName(entity.get被保険者氏名());
        item.setAge(entity.get年齢());
        item.setHihokenshaTel(entity.get電話番号());
        item.setJusho(entity.get住所());
        item.setShujiiName(entity.get主治医氏名());
        item.setIryokikanName(entity.get医療機関名称());
        item.setIryokikanAdress(entity.get医療機関住所());
        item.setIryokikanNameTel(entity.get医療機関電話番号());
        item.setIryokikanFax(entity.get医療機関FAX番号());
        item.setYubinNo(entity.get郵便番号());
        item.setBirthYY(年号.substring(INT3, INT5));
        item.setBirthMM(年号.substring(INT6, INT8));
        item.setBirthDD(年号.substring(INT9));
        RString ninteiShinseiDay = new FlexibleDate(entity.get認定申請年月日()).wareki().eraType(EraType.ALPHABET).firstYear(FirstYear.ICHI_NEN)
                .separator(Separator.SLASH).fillType(FillType.ZERO).toDateString();
        item.setShinseiYY1(ninteiShinseiDay.substring(1, 2));
        item.setShinseiYY2(ninteiShinseiDay.substring(2, INT3));
        item.setShinseiMM1(ninteiShinseiDay.substring(INT4, INT5));
        item.setShinseiMM2(ninteiShinseiDay.substring(INT5, INT6));
        item.setShinseiDD1(ninteiShinseiDay.substring(INT7, INT8));
        item.setShinseiDD2(ninteiShinseiDay.substring(INT8));
        item.setSeibetsuMan(Seibetsu.男.getコード().equals(entity.get性別()) ? 記号 : RString.EMPTY);
        item.setSeibetsuWoman(Seibetsu.女.getコード().equals(entity.get性別()) ? 記号 : RString.EMPTY);
        item.setBirthGengoMeiji(年号.startsWith(元号_明治) ? 記号 : RString.EMPTY);
        item.setBirthGengoTaisho(年号.startsWith(元号_大正) ? 記号 : RString.EMPTY);
        item.setBirthGengoShowa(年号.startsWith(元号_昭和) ? 記号 : RString.EMPTY);
        return item;
    }

    /**
     * 帳票「DBE236001_介護保険指定医依頼兼主治医意見書提出依頼書」Entityデータを作成するメッソドです。
     *
     * @param ninshoshaSource ninshoshaSource
     * @param bunshoNo bunshoNo
     * @param 通知文Map 通知文Map
     * @return ShujiiIkenshoTeishutsuIraishoItem
     */
    public ShujiiIkenshoTeishutsuIraishoItem setDBE236001Item(NinshoshaSource ninshoshaSource,
            RString bunshoNo, Map<Integer, RString> 通知文Map) {
        ShujiiIkenshoTeishutsuIraishoItem item = new ShujiiIkenshoTeishutsuIraishoItem();
        item.setBunshoNo(bunshoNo);
        item.setHakkoYMD1(ninshoshaSource.hakkoYMD);
        item.setDenshiKoin(ninshoshaSource.denshiKoin);
        item.setKoinMojiretsu(ninshoshaSource.koinMojiretsu);
        item.setKoinShoryaku(ninshoshaSource.koinShoryaku);
        item.setNinshoshaShimeiKakeru(ninshoshaSource.ninshoshaShimeiKakeru);
        item.setNinshoshaShimeiKakenai(ninshoshaSource.ninshoshaShimeiKakenai);
        item.setNinshoshaYakushokuMei(ninshoshaSource.ninshoshaYakushokuMei);
        item.setNinshoshaYakushokuMei1(ninshoshaSource.ninshoshaYakushokuMei1);
        item.setNinshoshaYakushokuMei2(ninshoshaSource.ninshoshaYakushokuMei2);
        item.setYubinNo1(entity.get医療機関郵便番号());
        item.setJushoText(entity.get医療機関住所());
        item.setKikanNameText(entity.get医療機関名称());
        item.setShimeiText(entity.get主治医氏名());
        RString key = DbBusinessConfig.get(ConfigNameDBE.主治医意見書作成依頼書_宛先敬称, 基準日, SubGyomuCode.DBE認定支援);
        if (ChohyoAtesakiKeisho.なし.getコード().equals(key)) {
            item.setMeishoFuyo(RString.EMPTY);
        }
        if (ChohyoAtesakiKeisho.様.getコード().equals(key)) {
            item.setMeishoFuyo(ChohyoAtesakiKeisho.様.get名称());
        }
        if (ChohyoAtesakiKeisho.殿.getコード().equals(key)) {
            item.setMeishoFuyo(ChohyoAtesakiKeisho.殿.get名称());
        }
        item.setCustomerBarCode(getカスタマーバーコード());
        item.setSonota(entity.get被保険者番号());
        item.setTitle(ReportIdDBE.DBE236001.getReportName());
        item.setTsuchibun1(通知文Map.get(1));
        List<RString> 被保険者番号リスト = get被保険者番号(entity.get被保険者番号());
        item.setHihokenshaNo1(被保険者番号リスト.get(0));
        item.setHihokenshaNo2(被保険者番号リスト.get(1));
        item.setHihokenshaNo3(被保険者番号リスト.get(2));
        item.setHihokenshaNo4(被保険者番号リスト.get(INT3));
        item.setHihokenshaNo5(被保険者番号リスト.get(INT4));
        item.setHihokenshaNo6(被保険者番号リスト.get(INT5));
        item.setHihokenshaNo7(被保険者番号リスト.get(INT6));
        item.setHihokenshaNo8(被保険者番号リスト.get(INT7));
        item.setHihokenshaNo9(被保険者番号リスト.get(INT8));
        item.setHihokenshaNo10(被保険者番号リスト.get(INT9));
        item.setHihokenshaNameKana(entity.get被保険者氏名カナ());
        item.setHihokenshaName(entity.get被保険者氏名());
        item.setSeibetsuMan(Seibetsu.男.getコード().equals(entity.get性別()) ? RString.EMPTY : 記号_星);
        item.setSeibetsuWoman(Seibetsu.女.getコード().equals(entity.get性別()) ? RString.EMPTY : 記号_星);
        RString 年号 = new FlexibleDate(entity.get生年月日()).wareki().eraType(EraType.KANJI).toDateString();
        item.setBirthGengoMeiji(年号.startsWith(元号_明治) ? RString.EMPTY : 記号_星);
        item.setBirthGengoTaisho(年号.startsWith(元号_大正) ? RString.EMPTY : 記号_星);
        item.setBirthGengoShowa(年号.startsWith(元号_昭和) ? RString.EMPTY : 記号_星);
        item.setBirthYMD(get和暦(entity.get生年月日(), false));
        item.setJusho(entity.get住所());
        RString 郵便番号 = entity.get郵便番号();
        if (!RString.isNullOrEmpty(郵便番号)) {
            item.setYubinNo(new YubinNo(entity.get郵便番号()).getEditedYubinNo());
        }
        item.setTsuchibun1(通知文Map.get(2));
        return item;
    }

    /**
     * 帳票「DBE234001_主治医意見書作成料請求書」Entityデータを作成するメッソドです。
     *
     * @return ShujiiIkenshoSakuseiRyoSeikyushoItem
     */
    public ShujiiIkenshoSakuseiRyoSeikyushoItem setDBE234001Item() {
        ShujiiIkenshoSakuseiRyoSeikyushoItem item = new ShujiiIkenshoSakuseiRyoSeikyushoItem();
        item.setGengo(RDate.getNowDate().toDateString());
        item.setAtesakiHokenshaName(entity.get保険者名());
        item.setShinkiZaitakuKingaku(IkenshoSakuseiRyo.在宅新規.get名称());
        item.setShinkiShisetsuKingaku(IkenshoSakuseiRyo.在宅継続.get名称());
        item.setKeizokuZaitakuKingaku(IkenshoSakuseiRyo.施設新規.get名称());
        item.setKeizokuShisetsuKingaku(IkenshoSakuseiRyo.施設継続.get名称());
        List<RString> 被保険者番号リスト = get被保険者番号(entity.get被保険者番号());
        item.setHihokenshaNo1(被保険者番号リスト.get(0));
        item.setHihokenshaNo2(被保険者番号リスト.get(1));
        item.setHihokenshaNo3(被保険者番号リスト.get(2));
        item.setHihokenshaNo4(被保険者番号リスト.get(INT3));
        item.setHihokenshaNo5(被保険者番号リスト.get(INT4));
        item.setHihokenshaNo6(被保険者番号リスト.get(INT5));
        item.setHihokenshaNo7(被保険者番号リスト.get(INT6));
        item.setHihokenshaNo8(被保険者番号リスト.get(INT7));
        item.setHihokenshaNo9(被保険者番号リスト.get(INT8));
        item.setHihokenshaNo10(被保険者番号リスト.get(INT9));
        item.setHihokenshaNameKana(entity.get被保険者氏名カナ());
        item.setHihokenshaName(entity.get被保険者氏名());
        item.setBirthYMD(entity.get生年月日());
        item.setSeibetsu(Seibetsu.toValue(entity.get性別()).get名称());
        if (ZaitakuShisetsuKubun.在宅.getコード().equals(entity.get在宅施設区分())) {
            item.setShubetsuZaitaku(記号);
        } else {
            item.setShubetsuZaitaku(RString.EMPTY);
        }
        if (ZaitakuShisetsuKubun.施設.getコード().equals(entity.get在宅施設区分())) {
            item.setShubetsuShisetsu(記号);
        } else {
            item.setShubetsuShisetsu(RString.EMPTY);
        }
        if (IkenshoSakuseiKaisuKubun.初回.getコード().equals(entity.get意見書作成回数区分())) {
            item.setShubetsuShinki(記号);
        } else {
            item.setShubetsuShinki(RString.EMPTY);
        }
        if (IkenshoSakuseiKaisuKubun._2回目以降.getコード().equals(entity.get意見書作成回数区分())) {
            item.setShubetsuKeizoku(記号);
        } else {
            item.setShubetsuKeizoku(RString.EMPTY);
        }
        item.setSeikyuIryokikanName(entity.get医療機関名称());
        item.setSeikyuIryokikanDaihyoName(entity.get代表者名());
        item.setSeikyuIryokikanYubinNo(entity.get医療機関郵便番号());
        item.setSeikyuIryokikanJusho(entity.get医療機関住所());
        item.setSeikyuIryokikanTel(entity.get医療機関電話番号());
        set意見書作成料(entity, item);
        return item;
    }

    private void set意見書作成料(ShujiiIkenshoTeishutsuIraishoHakkoRelateEntity entity, ShujiiIkenshoSakuseiRyoSeikyushoItem item) {
        if (IkenshoIraiKubun.初回依頼.getコード().equals(entity.get主治医意見書依頼区分())
                && ZaitakuShisetsuKubun.在宅.getコード().equals(entity.get在宅施設区分())) {
            RString shinkiZaitakuKingaku = item.getShinkiZaitakuKingaku();
            item.setIkenshoSakuseiRyo1(shinkiZaitakuKingaku.substring(0, 1));
            item.setIkenshoSakuseiRyo2(shinkiZaitakuKingaku.substring(1, 2));
            item.setIkenshoSakuseiRyo3(shinkiZaitakuKingaku.substring(2, INT3));
            item.setIkenshoSakuseiRyo4(shinkiZaitakuKingaku.substring(INT3, INT4));
            item.setSeikyugakuIkenshoSakuseiRyo1(shinkiZaitakuKingaku.substring(0, 1));
            item.setSeikyugakuIkenshoSakuseiRyo2(shinkiZaitakuKingaku.substring(1, 2));
            item.setSeikyugakuIkenshoSakuseiRyo3(shinkiZaitakuKingaku.substring(2, INT3));
            item.setSeikyugakuIkenshoSakuseiRyo4(shinkiZaitakuKingaku.substring(INT3, INT4));
        }
        if (IkenshoIraiKubun.初回依頼.getコード().equals(entity.get主治医意見書依頼区分())
                && ZaitakuShisetsuKubun.施設.getコード().equals(entity.get在宅施設区分())) {
            RString shinkiShisetsuKingaku = item.getShinkiShisetsuKingaku();
            item.setIkenshoSakuseiRyo1(shinkiShisetsuKingaku.substring(0, 1));
            item.setIkenshoSakuseiRyo2(shinkiShisetsuKingaku.substring(1, 2));
            item.setIkenshoSakuseiRyo3(shinkiShisetsuKingaku.substring(2, INT3));
            item.setIkenshoSakuseiRyo4(shinkiShisetsuKingaku.substring(INT3, INT4));
            item.setSeikyugakuIkenshoSakuseiRyo1(shinkiShisetsuKingaku.substring(0, 1));
            item.setSeikyugakuIkenshoSakuseiRyo2(shinkiShisetsuKingaku.substring(1, 2));
            item.setSeikyugakuIkenshoSakuseiRyo3(shinkiShisetsuKingaku.substring(2, INT3));
            item.setSeikyugakuIkenshoSakuseiRyo4(shinkiShisetsuKingaku.substring(INT3, INT4));

        }
        if (IkenshoIraiKubun.再依頼.getコード().equals(entity.get主治医意見書依頼区分())
                && ZaitakuShisetsuKubun.在宅.getコード().equals(entity.get在宅施設区分())) {
            RString keizokuZaitakuKingaku = item.getKeizokuZaitakuKingaku();
            item.setIkenshoSakuseiRyo1(keizokuZaitakuKingaku.substring(0, 1));
            item.setIkenshoSakuseiRyo2(keizokuZaitakuKingaku.substring(1, 2));
            item.setIkenshoSakuseiRyo3(keizokuZaitakuKingaku.substring(2, INT3));
            item.setIkenshoSakuseiRyo4(keizokuZaitakuKingaku.substring(INT3, INT4));
            item.setSeikyugakuIkenshoSakuseiRyo1(keizokuZaitakuKingaku.substring(0, 1));
            item.setSeikyugakuIkenshoSakuseiRyo2(keizokuZaitakuKingaku.substring(1, 2));
            item.setSeikyugakuIkenshoSakuseiRyo3(keizokuZaitakuKingaku.substring(2, INT3));
            item.setSeikyugakuIkenshoSakuseiRyo4(keizokuZaitakuKingaku.substring(INT3, INT4));

        }
        if (IkenshoIraiKubun.再依頼.getコード().equals(entity.get主治医意見書依頼区分())
                && ZaitakuShisetsuKubun.施設.getコード().equals(entity.get在宅施設区分())) {
            RString keizokuShisetsuKingaku = item.getKeizokuShisetsuKingaku();
            item.setIkenshoSakuseiRyo1(keizokuShisetsuKingaku.substring(0, 1));
            item.setIkenshoSakuseiRyo2(keizokuShisetsuKingaku.substring(1, 2));
            item.setIkenshoSakuseiRyo3(keizokuShisetsuKingaku.substring(2, INT3));
            item.setIkenshoSakuseiRyo4(keizokuShisetsuKingaku.substring(INT3, INT4));
            item.setSeikyugakuIkenshoSakuseiRyo1(keizokuShisetsuKingaku.substring(0, 1));
            item.setSeikyugakuIkenshoSakuseiRyo2(keizokuShisetsuKingaku.substring(1, 2));
            item.setSeikyugakuIkenshoSakuseiRyo3(keizokuShisetsuKingaku.substring(2, INT3));
            item.setSeikyugakuIkenshoSakuseiRyo4(keizokuShisetsuKingaku.substring(INT3, INT4));
        }
    }

    /**
     * 「DbT5301ShujiiIkenshoIraiJoho_主治医意見書提出依頼書発行」Entityデータを作成するメッソドです。
     *
     * @param dbT5301Entity dbT5301Entity
     * @return DbT5301ShujiiIkenshoIraiJohoEntity
     */
    public DbT5301ShujiiIkenshoIraiJohoEntity setDbt5301Entity(DbT5301ShujiiIkenshoIraiJohoEntity dbT5301Entity) {
        dbT5301Entity.setShinseishoKanriNo(new ShinseishoKanriNo(entity.get申請書管理番号()));
        dbT5301Entity.setIkenshoIraiRirekiNo(entity.get最大依頼履歴番号());
        dbT5301Entity.setLogicalDeletedFlag(false);
        RString hakkobi = processParamter.getHakkobi();
        if (!RString.isNullOrEmpty(hakkobi)) {
            dbT5301Entity.setIraishoShutsuryokuYMD(new FlexibleDate(hakkobi));
            dbT5301Entity.setIkenshoShutsuryokuYMD(new FlexibleDate(hakkobi));
        }
        RString 主治医意見書作成期限設定方法 = DbBusinessConfig.get(ConfigNameDBE.主治医意見書作成期限設定方法, 基準日, SubGyomuCode.DBE認定支援);
        if (文字列1.equals(主治医意見書作成期限設定方法)) {
            switch (processParamter.getTeishutsuKigen().toString()) {
                case "0":
                    int 期限日数 = Integer.parseInt(DbBusinessConfig.get(ConfigNameDBE.主治医意見書作成期限日数,
                            基準日, SubGyomuCode.DBE認定支援).toString());
                    FlexibleDate 作成依頼日 = entity.get主治医意見書作成依頼年月日();
                    dbT5301Entity.setIkenshoSakuseiKigenYMD(作成依頼日.plusDay(期限日数));
                    break;
                case "1":
                    dbT5301Entity.setIkenshoSakuseiKigenYMD(FlexibleDate.EMPTY);
                    break;
                case "2":
                    if (!RString.isNullOrEmpty(processParamter.getKyotsuHizuke())) {
                        dbT5301Entity.setIkenshoSakuseiKigenYMD(new FlexibleDate(processParamter.getKyotsuHizuke()));
                    }
                    break;
                default:
                    break;
            }
        }
        return dbT5301Entity;
    }

    /**
     * 帳票「DBE013006_主治医意見書作成料請求一覧表」の帳票データを作成するメッソドです。
     *
     * @return ShujiiIkenshoSeikyuIchiranEntity
     */
    public ShujiiIkenshoSeikyuIchiranEntity setDBE013006Entity() {
        ShujiiIkenshoSeikyuIchiranEntity 帳票Entity = new ShujiiIkenshoSeikyuIchiranEntity();
        帳票Entity.set保険者番号(entity.get証記載保険者番号());
        帳票Entity.set保険者名(entity.get保険者名());
        帳票Entity.set氏名(entity.get被保険者氏名());
        帳票Entity.set被保険者番号(entity.get被保険者番号());
        帳票Entity.set生年月日(getFlexibleDate(entity.get生年月日()));
        帳票Entity.set性別(entity.get性別());
        帳票Entity.set認定申請年月日(getFlexibleDate(entity.get認定申請年月日()));
        帳票Entity.set認定申請区分申請時コード(entity.get認定申請区分申請時コード());
        帳票Entity.set医療機関(entity.get医療機関名称());
        帳票Entity.set主治医意見書記入年月日(getFlexibleDate(entity.get主治医意見書記入年月日()));
        帳票Entity.set主治医意見書読取年月日(getFlexibleDate(entity.get主治医意見書読取年月日()));
        if (IkenshoSakuseiKaisuKubun.初回.getコード().equals(entity.get意見書作成回数区分())) {
            帳票Entity.set主治医意見書作成料(IkenshoSakuseiRyo.toValue(new RString("11")).get名称());
        } else if (IkenshoSakuseiKaisuKubun._2回目以降.getコード().equals(entity.get意見書作成回数区分())) {
            帳票Entity.set主治医意見書作成料(IkenshoSakuseiRyo.toValue(new RString("12")).get名称());
        }
        if (SakuseiryoSeikyuKubun.在宅新規.getコード().equals(entity.get在宅施設区分())
                || SakuseiryoSeikyuKubun.在宅継続.getコード().equals(entity.get在宅施設区分())) {
            帳票Entity.set主治医意見書作成料(IkenshoSakuseiRyo.toValue(new RString("21")).get名称());
        } else if (SakuseiryoSeikyuKubun.施設新規.getコード().equals(entity.get在宅施設区分())
                || SakuseiryoSeikyuKubun.施設継続.getコード().equals(entity.get在宅施設区分())) {
            帳票Entity.set主治医意見書作成料(IkenshoSakuseiRyo.toValue(new RString("22")).get名称());
        }
        帳票Entity.set主治医意見書別途診療費(entity.get主治医意見書別途診療費());
        帳票Entity.set報酬支払年月日(getFlexibleDate(entity.get主治医意見書報酬支払年月日()));
        return 帳票Entity;
    }

    /**
     * 帳票「DBE230001_主治医意見書作成依頼書」の帳票データを作成するメッソドです。
     *
     * @param ninshoshaSource ninshoshaSource
     * @param bunshoNo bunshoNo
     * @param 通知文Map 通知文Map
     * @return ShujiiIkenshoSakuseiIraishoItem
     */
    public ShujiiIkenshoSakuseiIraishoItem setDBE230001Item(NinshoshaSource ninshoshaSource,
            RString bunshoNo,
            Map<Integer, RString> 通知文Map) {
        ShujiiIkenshoSakuseiIraishoItem item = new ShujiiIkenshoSakuseiIraishoItem();
        item.setHakkoYMD1(ninshoshaSource.hakkoYMD);
        item.setDenshiKoin(ninshoshaSource.denshiKoin);
        item.setKoinMojiretsu(ninshoshaSource.koinMojiretsu);
        item.setKoinShoryaku(ninshoshaSource.koinShoryaku);
        item.setNinshoshaShimeiKakeru(ninshoshaSource.ninshoshaShimeiKakeru);
        item.setNinshoshaShimeiKakenai(ninshoshaSource.ninshoshaShimeiKakenai);
        item.setNinshoshaYakushokuMei(ninshoshaSource.ninshoshaYakushokuMei);
        item.setNinshoshaYakushokuMei1(ninshoshaSource.ninshoshaYakushokuMei1);
        item.setNinshoshaYakushokuMei2(ninshoshaSource.ninshoshaYakushokuMei2);
        item.setBunshoNo(bunshoNo);
        item.setYubinNo1(entity.get医療機関郵便番号());
        item.setJushoText(entity.get医療機関住所());
        item.setKikanNameText(entity.get医療機関名称());
        item.setShimeiText(entity.get主治医氏名());
        RString key = DbBusinessConfig.get(ConfigNameDBE.主治医意見書作成依頼書_宛先敬称, 基準日, SubGyomuCode.DBE認定支援);
        if (ChohyoAtesakiKeisho.なし.getコード().equals(key)) {
            item.setMeishoFuyo(RString.EMPTY);
        }
        if (ChohyoAtesakiKeisho.様.getコード().equals(key)) {
            item.setMeishoFuyo(ChohyoAtesakiKeisho.様.get名称());
        }
        if (ChohyoAtesakiKeisho.殿.getコード().equals(key)) {
            item.setMeishoFuyo(ChohyoAtesakiKeisho.殿.get名称());
        }
        item.setCustomerBarCode(getカスタマーバーコード());
        item.setSonota(entity.get被保険者番号());
        RStringBuilder builder = new RStringBuilder();
        builder.append("*");
        builder.append((new RString(String.valueOf(宛名連番++))).padLeft(文字列0, INT6));
        builder.append("#");
        item.setAtenaRenban(builder.toRString());
        item.setRemban(new RString(String.valueOf(連番++)));
        item.setTitle(ReportIdDBE.DBE230001.getReportName());
        item.setTsuchibun1(通知文Map.get(1));
        item.setShinseiKubun(NinteiShinseiShinseijiKubunCode.toValue(entity.get認定申請区分申請時コード()).get名称());
        RString hihokenshaNo = entity.get被保険者番号();
        if (!RString.isNullOrEmpty(hihokenshaNo) && INT10 <= hihokenshaNo.length()) {
            item.setHihokenshaNo1(hihokenshaNo.substring(0, 1));
            item.setHihokenshaNo2(hihokenshaNo.substring(1, 2));
            item.setHihokenshaNo3(hihokenshaNo.substring(2, INT3));
            item.setHihokenshaNo4(hihokenshaNo.substring(INT3, INT4));
            item.setHihokenshaNo5(hihokenshaNo.substring(INT4, INT5));
            item.setHihokenshaNo6(hihokenshaNo.substring(INT5, INT6));
            item.setHihokenshaNo7(hihokenshaNo.substring(INT6, INT7));
            item.setHihokenshaNo8(hihokenshaNo.substring(INT7, INT8));
            item.setHihokenshaNo9(hihokenshaNo.substring(INT8, INT9));
            item.setHihokenshaNo10(hihokenshaNo.substring(INT9, INT10));
        }
        RString hokenshaNo = entity.get証記載保険者番号();
        if (!RString.isNullOrEmpty(hokenshaNo) && INT5 <= hokenshaNo.length()) {
            item.setHokenshaNo1(hokenshaNo.substring(0, 1));
            item.setHokenshaNo2(hokenshaNo.substring(1, 2));
            item.setHokenshaNo3(hokenshaNo.substring(2, INT3));
            item.setHokenshaNo4(hokenshaNo.substring(INT3, INT4));
            item.setHokenshaNo5(hokenshaNo.substring(INT4, INT5));
            item.setHokenshaNo6(hokenshaNo.substring(INT5, INT6));
        }
        item.setHihokenshaNameKana(entity.get被保険者氏名カナ());
        item.setHihokenshaName(entity.get被保険者氏名());
        item.setSeibetsuMan(Seibetsu.男.getコード().equals(entity.get性別()) ? RString.EMPTY : 記号_星);
        item.setSeibetsuWoman(Seibetsu.女.getコード().equals(entity.get性別()) ? RString.EMPTY : 記号_星);
        RString 年号 = new FlexibleDate(entity.get生年月日()).wareki().eraType(EraType.KANJI).toDateString();
        item.setBirthGengoMeiji(年号.startsWith(元号_明治) ? RString.EMPTY : 記号_星);
        item.setBirthGengoTaisho(年号.startsWith(元号_大正) ? RString.EMPTY : 記号_星);
        item.setBirthGengoShowa(年号.startsWith(元号_昭和) ? RString.EMPTY : 記号_星);
        item.setBirthYMD(get和暦(entity.get生年月日(), false));
        RString 郵便番号 = entity.get郵便番号();
        if (!RString.isNullOrEmpty(郵便番号)) {
            item.setYubinNo(new YubinNo(entity.get郵便番号()).getEditedYubinNo());
        }
        item.setJusho(entity.get住所());
        item.setShinseiYMD(get和暦(entity.get認定申請年月日(), true));
        item.setTeishutsuKigen(get提出期限());
        item.setTsuchibun2(通知文Map.get(2));
        item.setShoriName(IkenshoIraiKubun.toValue(entity.get主治医意見書依頼区分()).get名称());
        return item;
    }

    private RString get和暦(RString 日付, boolean 年号フラグ) {
        RString 和暦 = RString.EMPTY;
        if (!RString.isNullOrEmpty(日付)) {
            FlexibleDate flexibleDate = new FlexibleDate(日付);
            if (年号フラグ) {
                和暦 = flexibleDate.wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).
                        separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();
            } else {
                和暦 = flexibleDate.wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).
                        separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString().substring(2);
            }
        }
        return 和暦;
    }

    private RString getカスタマーバーコード() {
        RString カスタマーバーコード = RString.EMPTY;
        CustomerBarCode barCode = new CustomerBarCode();
        RString 被保険者郵便番号 = entity.get医療機関郵便番号();
        RString 住所 = entity.get医療機関住所();
        if (!RString.isNullOrEmpty(被保険者郵便番号) && !RString.isNullOrEmpty(住所)) {
            CustomerBarCodeResult result = barCode.convertCustomerBarCode(被保険者郵便番号, 住所);
            if (result != null) {
                カスタマーバーコード = result.getCustomerBarCode();
            }
        }
        return カスタマーバーコード;
    }

    /**
     * 帳票「DBE230002_主治医意見書作成依頼一覧表」の帳票データを作成するメッソドです。
     *
     * @param ninshoshaSource ninshoshaSource
     * @param 通知文Map 通知文Map
     * @return IkenshoSakuseiIraiIchiranhyoItem
     */
    public IkenshoSakuseiIraiIchiranhyoItem setDBE230002BodyItem(NinshoshaSource ninshoshaSource,
            Map<Integer, RString> 通知文Map) {
        return new IkenshoSakuseiIraiIchiranhyoItem(
                ninshoshaSource.hakkoYMD,
                ninshoshaSource.denshiKoin,
                ninshoshaSource.ninshoshaYakushokuMei1,
                ninshoshaSource.ninshoshaYakushokuMei,
                ninshoshaSource.ninshoshaYakushokuMei2,
                ninshoshaSource.ninshoshaShimeiKakeru,
                ninshoshaSource.ninshoshaShimeiKakenai,
                ninshoshaSource.koinMojiretsu,
                ninshoshaSource.koinShoryaku,
                entity.get医療機関郵便番号(),
                entity.get医療機関住所(),
                entity.get医療機関名称(),
                entity.get代表者名(),
                get名称付与(),
                get印刷日時(),
                通知文Map.get(1),
                entity.get主治医氏名(),
                entity.get被保険者番号(),
                entity.get被保険者氏名(),
                entity.get被保険者氏名カナ(),
                entity.get住所(),
                get和暦(entity.get生年月日()),
                Seibetsu.toValue(entity.get性別()).get名称(),
                get提出期限());
    }

    private RString get提出期限() {

        RString 提出期限 = RString.EMPTY;
        if (文字列1.equals(DbBusinessConfig.get(ConfigNameDBE.主治医意見書作成期限設定方法, 基準日, SubGyomuCode.DBE認定支援))) {
            if (文字列0.equals(processParamter.getTeishutsuKigen())) {
                int 期限日数 = Integer.parseInt(DbBusinessConfig.get(ConfigNameDBE.主治医意見書作成期限日数,
                        基準日, SubGyomuCode.DBE認定支援).toString());
                提出期限 = get和暦(new RString(entity.get主治医意見書作成期限年月日().plusDay(期限日数).toString()));
            } else if (文字列1.equals(processParamter.getTeishutsuKigen())) {
                提出期限 = RString.EMPTY;
            } else if (文字列2.equals(processParamter.getTeishutsuKigen())) {
                提出期限 = !RString.isNullOrEmpty(processParamter.getKyotsuHizuke())
                        ? get和暦(processParamter.getKyotsuHizuke()) : RString.EMPTY;
            }
        } else {
            FlexibleDate 主治医意見書作成期限日 = entity.get主治医意見書作成期限年月日();
            if (主治医意見書作成期限日 != null && !主治医意見書作成期限日.isEmpty()) {
                提出期限 = get和暦(new RString(主治医意見書作成期限日.toString()));
            }
        }
        return 提出期限;
    }

    private List<RString> get被保険者番号(RString 被保険者番号) {
        List<RString> 被保険者番号リスト = new ArrayList<>();
        for (int i = 0; i <= INT9; i++) {
            被保険者番号リスト.add(RString.EMPTY);
        }
        if (0 < 被保険者番号.length()) {
            被保険者番号リスト.set(0, 被保険者番号.substring(0, 1));
        }
        if (1 < 被保険者番号.length()) {
            被保険者番号リスト.set(1, 被保険者番号.substring(1, 2));
        }
        if (2 < 被保険者番号.length()) {
            被保険者番号リスト.set(2, 被保険者番号.substring(2, INT3));
        }
        if (INT3 < 被保険者番号.length()) {
            被保険者番号リスト.set(INT3, 被保険者番号.substring(INT3, INT4));
        }
        if (INT4 < 被保険者番号.length()) {
            被保険者番号リスト.set(INT4, 被保険者番号.substring(INT4, INT5));
        }
        if (INT5 < 被保険者番号.length()) {
            被保険者番号リスト.set(INT5, 被保険者番号.substring(INT5, INT6));
        }
        if (INT6 < 被保険者番号.length()) {
            被保険者番号リスト.set(INT6, 被保険者番号.substring(INT6, INT7));
        }
        if (INT7 < 被保険者番号.length()) {
            被保険者番号リスト.set(INT7, 被保険者番号.substring(INT7, INT8));
        }
        if (INT8 < 被保険者番号.length()) {
            被保険者番号リスト.set(INT8, 被保険者番号.substring(INT8, INT9));
        }
        if (INT9 < 被保険者番号.length()) {
            被保険者番号リスト.set(INT9, 被保険者番号.substring(INT9));
        }
        return 被保険者番号リスト;
    }

    private RString get印刷日時() {
        RDateTime printdate = RDateTime.now();
        RStringBuilder printTimeStampSb = new RStringBuilder();
        printTimeStampSb.append(printdate.getDate().wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).
                separator(Separator.JAPANESE).
                fillType(FillType.ZERO).toDateString());
        printTimeStampSb.append(RString.HALF_SPACE);
        printTimeStampSb.append(String.format("%02d", printdate.getHour()));
        printTimeStampSb.append(DATE_時);
        printTimeStampSb.append(String.format("%02d", printdate.getMinute()));
        printTimeStampSb.append(DATE_分);
        printTimeStampSb.append(String.format("%02d", printdate.getSecond()));
        printTimeStampSb.append(DATE_秒);
        printTimeStampSb.append(RString.HALF_SPACE);
        return printTimeStampSb.toRString();
    }

    private RString get名称付与() {
        RString key = DbBusinessConfig.get(ConfigNameDBE.主治医意見書作成依頼書_宛先敬称, 基準日, SubGyomuCode.DBE認定支援);
        RString 名称付与 = RString.EMPTY;
        if (ChohyoAtesakiKeisho.なし.getコード().equals(key)) {
            名称付与 = RString.EMPTY;
        }
        if (ChohyoAtesakiKeisho.様.getコード().equals(key)) {
            名称付与 = ChohyoAtesakiKeisho.様.get名称();
        }
        if (ChohyoAtesakiKeisho.殿.getコード().equals(key)) {
            名称付与 = ChohyoAtesakiKeisho.殿.get名称();
        }
        return 名称付与;
    }

    private RString get和暦(RString 日付) {
        RString 和暦 = RString.EMPTY;
        if (!RString.isNullOrEmpty(日付)) {
            FlexibleDate flexibleDate = new FlexibleDate(日付);
            和暦 = flexibleDate.wareki().eraType(EraType.KANJI_RYAKU).toDateString();
        }
        return 和暦;
    }

    private FlexibleDate getFlexibleDate(RString date) {
        FlexibleDate 戻り値 = FlexibleDate.EMPTY;
        if (!RString.isNullOrEmpty(date)) {
            戻り値 = new FlexibleDate(date);
        }
        return 戻り値;
    }

    /**
     * バッチ出力条件Itemの設定メッソドです。
     *
     * @param 市町村名 市町村名
     * @param 出力ページ数 出力ページ数
     * @param 導入団体コード 導入団体コード
     * @param reportID reportID
     * @return ReportOutputJokenhyoItem
     */
    public ReportOutputJokenhyoItem バッチ出力条件リストの出力(RString 市町村名,
            RString 出力ページ数,
            RString 導入団体コード,
            ReportIdDBE reportID) {
        RString csv出力有無 = new RString("無し");
        RString csvファイル名 = new RString("－");
        RString ジョブ番号 = new RString("56");
        List<RString> 出力条件 = new ArrayList<>();
        RStringBuilder builder = new RStringBuilder();
        builder.append(IRAIFROMYMD);
        builder.append(processParamter.getIraiFromYMD());
        出力条件.add(builder.toRString());
        builder = new RStringBuilder();
        builder.append(IRAITOYMD);
        builder.append(processParamter.getIraiToYMD());
        出力条件.add(builder.toRString());
        builder = new RStringBuilder();
        builder.append(SHUJIIIKENSHOSAKUSEIIRAI);
        builder.append(processParamter.getShujiiikenshoSakuseiIrai());
        出力条件.add(builder.toRString());
        builder = new RStringBuilder();
        builder.append(SHUJIIIKENSHO);
        builder.append(processParamter.getShujiiIkensho());
        出力条件.add(builder.toRString());
        builder = new RStringBuilder();
        builder.append(SHUJIIIKENSHOSAKUSEIIRAILIST);
        出力条件.add(builder.toRString());
        List<GridParameter> shujiiIkenshoSakuseiIraiList = processParamter.getShujiiIkenshoSakuseiIraiList();
        for (GridParameter gridParameter : shujiiIkenshoSakuseiIraiList) {
            builder = new RStringBuilder();
            builder.append(SHUJIIIRYOKIKANCODE);
            builder.append(gridParameter.getShujiiIryoKikanCode());
            出力条件.add(builder.toRString());
            builder = new RStringBuilder();
            builder.append(ISHINO);
            builder.append(gridParameter.getIshiNo());
            出力条件.add(builder.toRString());
            builder = new RStringBuilder();
            builder.append(SHOKISAIHOKENSHANO);
            builder.append(gridParameter.getShoKisaiHokenshaNo());
            出力条件.add(builder.toRString());
        }
        builder = new RStringBuilder();
        builder.append(HAKKOBI);
        builder.append(processParamter.getHakkobi());
        出力条件.add(builder.toRString());
        builder = new RStringBuilder();
        builder.append(TEISHUTSUKIGEN);
        builder.append(processParamter.getTeishutsuKigen());
        出力条件.add(builder.toRString());
        builder = new RStringBuilder();
        builder.append(KYOTSUHIZUKE);
        builder.append(processParamter.getKyotsuHizuke());
        出力条件.add(builder.toRString());
        builder = new RStringBuilder();
        builder.append(IKENSHOSAKUSEIIRAI);
        builder.append(processParamter.isIkenshoSakuseiirai());
        出力条件.add(builder.toRString());
        builder = new RStringBuilder();
        builder.append(IKENSHOSAKUSEISEIKYUU);
        builder.append(processParamter.isIkenshoSakuseiSeikyuu());
        出力条件.add(builder.toRString());
        builder = new RStringBuilder();
        builder.append(SHUJIIIKENSHOSAKUSEIIRAISHO);
        builder.append(processParamter.isShujiiIkenshoSakuseiIraisho());
        出力条件.add(builder.toRString());
        builder = new RStringBuilder();
        builder.append(IKENSHOKINYUU);
        builder.append(processParamter.isIkenshoKinyuu());
        出力条件.add(builder.toRString());
        builder = new RStringBuilder();
        builder.append(IKENSHOKINYUUOCR);
        builder.append(processParamter.isIkenshoKinyuuOCR());
        出力条件.add(builder.toRString());
        builder = new RStringBuilder();
        builder.append(IKENSHOSAKUSEISEIKYUUSHO);
        builder.append(processParamter.isIkenshoSakuseiSeikyuusho());
        出力条件.add(builder.toRString());
        builder = new RStringBuilder();
        builder.append(IKENSHOTEISHUTU);
        builder.append(processParamter.isIkenshoTeishutu());
        出力条件.add(builder.toRString());
        return new ReportOutputJokenhyoItem(
                reportID.getReportId().value(),
                導入団体コード,
                市町村名,
                ジョブ番号,
                reportID.getReportName(),
                出力ページ数,
                csv出力有無,
                csvファイル名,
                出力条件);
    }
}
