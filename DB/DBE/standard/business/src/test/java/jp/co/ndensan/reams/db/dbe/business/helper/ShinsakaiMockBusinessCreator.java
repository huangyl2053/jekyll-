/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.helper;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.GogitaiDetail;
import jp.co.ndensan.reams.db.dbe.business.GogitaichoKubun;
import jp.co.ndensan.reams.db.dbe.business.JogaiShinsakaiIin;
import jp.co.ndensan.reams.db.dbe.business.JogaiShinsakaiIinList;
import jp.co.ndensan.reams.db.dbe.business.ShinsainKubun;
import jp.co.ndensan.reams.db.dbe.business.Shinsakai;
import jp.co.ndensan.reams.db.dbe.business.ShinsakaiDetail;
import jp.co.ndensan.reams.db.dbe.business.ShinsakaiIin;
import jp.co.ndensan.reams.db.dbe.business.ShinsakaiIinKoza;
import jp.co.ndensan.reams.db.dbe.business.ShinsakaiIinList;
import jp.co.ndensan.reams.db.dbe.business.ShinsakaiIinShikaku;
import jp.co.ndensan.reams.db.dbe.business.ShinsakaiKaisaiBasho;
import jp.co.ndensan.reams.db.dbe.business.ShinsakaiWariateIin;
import jp.co.ndensan.reams.db.dbe.business.ShinsakaiWariateIinList;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.GogitaiDummyKubun;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.GogitaiSeishinkaIshiSonzaiKubun;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.ShinsainYusoKubun;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.ShinsakaiIinJokyo;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.ShinsakaiIinShukketsuKubun;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.ShinsakaiKaisaiBashoJokyo;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.ShinsakaiKyukaiKubun;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.GogitaiNo;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.GogitaiYukoKikanKaishiDate;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.ShinsakaiIinCode;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.ShinsakaiKaisaiBashoCode;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.ShinsakaiKaisaiChiku;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.ShinsakaiKaisaiNo;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.TimeString;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.Gender;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.KinyuKikanCode;
import jp.co.ndensan.reams.uz.uza.biz.KinyuKikanShitenCode;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Range;

/**
 * 審査会関連のテストで使用する、businessのインスタンスを生成します。
 *
 * @author n8178 城間篤人
 */
public final class ShinsakaiMockBusinessCreator {

    private ShinsakaiMockBusinessCreator() {
    }

    /**
     * 合議体情報を生成します。
     *
     * @param 合議体番号 合議体番号
     * @return 合議体情報
     */
    public static GogitaiDetail create合議体情報(int 合議体番号) {
        return new GogitaiDetail(new GogitaiNo(合議体番号), RString.EMPTY, new GogitaiYukoKikanKaishiDate("19990101"),
                FlexibleDate.MAX, new Range(new TimeString("0000"), new TimeString("2359")),
                create審査会開催場所("A001"), 6, 7, 8, GogitaiSeishinkaIshiSonzaiKubun.存在, GogitaiDummyKubun.ダミー);
    }

    /**
     * 審査会開催場所を生成します。
     *
     * @param 場所コード 場所コード
     * @return 審査会開催場所
     */
    public static ShinsakaiKaisaiBasho create審査会開催場所(String 場所コード) {
        return new ShinsakaiKaisaiBasho(new ShinsakaiKaisaiBashoCode(new RString(場所コード)), RString.EMPTY,
                new ShinsakaiKaisaiChiku(new Code("A001"), RString.EMPTY), new AtenaJusho("yamadaB001"),
                new TelNo("098-999-9999"), ShinsakaiKaisaiBashoJokyo.有効);
    }

    /**
     * 審査会情報を生成します。
     *
     * @param 審査会開催番号 審査会開催番号
     * @param 審査会開催年月日 審査会開催年月日
     * @return 審査会情報
     */
    public static ShinsakaiDetail create審査会情報(int 審査会開催番号, String 審査会開催年月日) {
        return new ShinsakaiDetail.Builder(new ShinsakaiKaisaiNo(審査会開催番号), new FlexibleDate(審査会開催年月日),
                new TimeString("0000"), new TimeString("2359"), create合議体情報(1))
                .set審査会開催場所(create審査会開催場所("A001")).set審査会予定定員(6).set審査会最大定員(7).set審査会自動割当定員(8)
                .set審査会委員定員(9).set精神科医存在区分(GogitaiSeishinkaIshiSonzaiKubun.存在).set合議体ダミー区分(GogitaiDummyKubun.ダミー)
                .set審査会資料作成年月日(new FlexibleDate("19800101")).set審査会休会区分(ShinsakaiKyukaiKubun.休会).set審査会割当済み人数(10).build();

    }

    /**
     * 審査会割当委員を生成します。
     *
     * @param 審査会開催番号 審査会開催番号
     * @param 審査会開催年月日 審査会開催年月日
     * @param 審査会委員コード 審査会委員コード
     * @return 審査会割当委員
     */
    public static ShinsakaiWariateIin create審査会割当委員(int 審査会開催番号, String 審査会開催年月日, String 審査会委員コード) {
        return new ShinsakaiWariateIin(create審査会情報(審査会開催番号, 審査会開催年月日), create審査会委員(審査会委員コード),
                new ShinsainKubun(new Code("S001"), new RString("名称"), new RString("略称")),
                new GogitaichoKubun(new Code("G001"), new RString("名称"), new RString("略称")),
                new Range(new TimeString("0000"), new TimeString("2359")), ShinsakaiIinShukketsuKubun.出席);
    }

    /**
     * 引数から項目をすべて指定して、審査会割当委員を生成します。
     *
     * @param 審査会開催番号 審査会開催番号
     * @param 審査会開催年月日 審査会開催年月日
     * @param 審査会委員コード 審査会委員コード
     * @param 審査員区分 審査員区分
     * @param 合議体長区分 合議体長区分
     * @param 開始時間 開始時間
     * @param 終了時間 終了時間
     * @param 出欠区分 出欠区分
     * @return 審査会割当委員
     */
    public static ShinsakaiWariateIin create審査会割当委員(int 審査会開催番号, String 審査会開催年月日, String 審査会委員コード,
            Code 審査員区分, Code 合議体長区分, TimeString 開始時間, TimeString 終了時間, ShinsakaiIinShukketsuKubun 出欠区分) {
        return new ShinsakaiWariateIin(create審査会情報(審査会開催番号, 審査会開催年月日), create審査会委員(審査会委員コード),
                new ShinsainKubun(審査員区分, new RString("名称"), new RString("略称")),
                new GogitaichoKubun(合議体長区分, new RString("名称"), new RString("略称")),
                new Range(開始時間, 終了時間), 出欠区分);
    }

    /**
     * 審査会割当委員Listを生成します。
     *
     * @param 審査会開催番号 審査会開催番号
     * @param 審査会開催年月日 審査会開催年月日
     * @param 委員コードList 委員コードList
     * @return 審査会割当委員List
     */
    public static ShinsakaiWariateIinList create審査会割当委員List(int 審査会開催番号, String 審査会開催年月日, String... 委員コードList) {
        List<ShinsakaiWariateIin> list = new ArrayList<>();
        for (String 委員コード : 委員コードList) {
            list.add(create審査会割当委員(審査会開催番号, 審査会開催年月日, 委員コード));
        }
        return new ShinsakaiWariateIinList(list);
    }

    /**
     * 審査会を生成して返します。
     *
     * @param 審査会開催番号 審査会開催番号
     * @param 審査会開催年月日 審査会開催年月日
     * @return 審査会
     */
    public static Shinsakai create審査会(int 審査会開催番号, String 審査会開催年月日) {
        List<ShinsakaiWariateIin> list = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            list.add(ShinsakaiMockBusinessCreator.create審査会割当委員(審査会開催番号, 審査会開催年月日, "00000001"));
        }

        return new Shinsakai(create審査会情報(審査会開催番号, 審査会開催年月日), new ShinsakaiWariateIinList(list));
    }

    /**
     * 審査会委員を生成して返します。
     *
     * @param 委員コード 委員コード
     * @return 審査会委員
     */
    public static ShinsakaiIin create審査会委員(String 委員コード) {
        return new ShinsakaiIin(new ShinsakaiIinCode(new RString(委員コード)),
                new Range(new FlexibleDate("19800101"), FlexibleDate.MAX), ShinsakaiIinJokyo.有効,
                new JigyoshaNo(RString.EMPTY), new AtenaMeisho("宛名名称"), new AtenaKanaMeisho("アテナカナメイショウ"),
                Gender.MALE, new ShinsakaiIinShikaku(new Code("kubun01"), RString.EMPTY, RString.EMPTY), ShinsainYusoKubun.自宅,
                new YubinNo("904-0000"), new AtenaJusho("住所"), new TelNo("098-000-0000"),
                create委員口座情報());
    }

    private static ShinsakaiIinKoza create委員口座情報() {
        return new ShinsakaiIinKoza(new KinyuKikanCode("0001"), new KinyuKikanShitenCode("011"),
                RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY);
    }

    /**
     * 審査会委員のListを生成して返します。
     *
     * @param 委員コードList 生成される審査会委員に振られるコードのリスト
     * @return 審査会委員List
     */
    public static ShinsakaiIinList create審査会委員List(String... 委員コードList) {
        List<ShinsakaiIin> list = new ArrayList<>();
        for (String 委員コード : 委員コードList) {
            list.add(create審査会委員(委員コード));
        }
        return new ShinsakaiIinList(list);
    }

    /**
     * 除外対象審査会委員を生成して返します。
     *
     * @return 除外審査会委員
     */
    public static JogaiShinsakaiIin create除外対象審査会委員() {
        ShinsakaiIin iin = create審査会委員("00000001");
        return new JogaiShinsakaiIin(new ShoKisaiHokenshaNo(new RString("000001")),
                new HihokenshaNo(new RString("0000000001")), 1, iin);
    }

}
