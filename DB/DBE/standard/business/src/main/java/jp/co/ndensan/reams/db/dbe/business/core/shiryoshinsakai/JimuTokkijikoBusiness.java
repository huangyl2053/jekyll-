/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.shiryoshinsakai;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.shiryoshinsakai.NinteiShinseiJohoEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.shiryoshinsakai.NinteiTokkijikoEntity;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 事務局用特記事項情報のBusinessの編集クラスです。
 *
 * @reamsid_L DBE-0150-190 linghuhang
 */
public class JimuTokkijikoBusiness {

    private final NinteiShinseiJohoEntity entity;
    private final List<NinteiTokkijikoEntity> 特記事項情報;
//    private static final RString 特記事項番号_101 = new RString("101");
//    private static final RString 特記事項番号_102 = new RString("102");
//    private static final RString 特記事項番号_103 = new RString("103");
//    private static final RString 特記事項番号_104 = new RString("104");
//    private static final RString 特記事項番号_105 = new RString("105");
//    private static final RString 特記事項番号_106 = new RString("106");
//    private static final RString 特記事項番号_107 = new RString("107");
//    private static final RString 特記事項番号_108 = new RString("108");
//    private static final RString 特記事項番号_109 = new RString("109");
//    private static final RString 特記事項番号_110 = new RString("110");
//    private static final RString 特記事項番号_111 = new RString("111");
//    private static final RString 特記事項番号_112 = new RString("112");
//    private static final RString 特記事項番号_113 = new RString("113");
//    private static final RString 特記事項番号_201 = new RString("201");
//    private static final RString 特記事項番号_202 = new RString("202");
//    private static final RString 特記事項番号_203 = new RString("203");
//    private static final RString 特記事項番号_204 = new RString("204");
//    private static final RString 特記事項番号_205 = new RString("205");
//    private static final RString 特記事項番号_206 = new RString("206");
//    private static final RString 特記事項番号_207 = new RString("207");
//    private static final RString 特記事項番号_208 = new RString("208");
//    private static final RString 特記事項番号_209 = new RString("209");
//    private static final RString 特記事項番号_210 = new RString("210");
//    private static final RString 特記事項番号_211 = new RString("211");
//    private static final RString 特記事項番号_212 = new RString("212");
//    private static final RString 特記事項番号_301 = new RString("301");
//    private static final RString 特記事項番号_302 = new RString("302");
//    private static final RString 特記事項番号_303 = new RString("303");
//    private static final RString 特記事項番号_304 = new RString("304");
//    private static final RString 特記事項番号_305 = new RString("305");
//    private static final RString 特記事項番号_306 = new RString("306");
//    private static final RString 特記事項番号_307 = new RString("307");
//    private static final RString 特記事項番号_308 = new RString("308");
//    private static final RString 特記事項番号_309 = new RString("309");
//    private static final RString 特記事項番号_401 = new RString("401");
//    private static final RString 特記事項番号_402 = new RString("402");
//    private static final RString 特記事項番号_403 = new RString("403");
//    private static final RString 特記事項番号_404 = new RString("404");
//    private static final RString 特記事項番号_405 = new RString("405");
//    private static final RString 特記事項番号_406 = new RString("406");
//    private static final RString 特記事項番号_407 = new RString("407");
//    private static final RString 特記事項番号_408 = new RString("408");
//    private static final RString 特記事項番号_409 = new RString("409");
//    private static final RString 特記事項番号_410 = new RString("410");
//    private static final RString 特記事項番号_411 = new RString("411");
//    private static final RString 特記事項番号_412 = new RString("412");
//    private static final RString 特記事項番号_413 = new RString("413");
//    private static final RString 特記事項番号_414 = new RString("414");
//    private static final RString 特記事項番号_415 = new RString("415");
//    private static final RString 特記事項番号_4011 = new RString("4011");
//    private static final RString 特記事項番号_4012 = new RString("4022");
//    private static final RString 特記事項番号_501 = new RString("501");
//    private static final RString 特記事項番号_502 = new RString("502");
//    private static final RString 特記事項番号_503 = new RString("503");
//    private static final RString 特記事項番号_504 = new RString("504");
//    private static final RString 特記事項番号_505 = new RString("505");
//    private static final RString 特記事項番号_506 = new RString("506");
//    private static final RString 特記事項番号_5011 = new RString("5011");
//    private static final RString 特記事項番号_5012 = new RString("5012");
//    private static final RString 特記事項番号_5013 = new RString("5013");
//    private static final RString 特記事項番号_5014 = new RString("5014");
//    private static final RString 特記事項番号_5021 = new RString("5021");
//    private static final RString 特記事項番号_5022 = new RString("5022");
//    private static final RString 特記事項番号_601 = new RString("601");
//    private static final RString 特記事項番号_602 = new RString("602");
//    private static final RString 特記事項番号_603 = new RString("603");
//    private static final RString 特記事項番号_604 = new RString("604");
//    private static final RString 特記事項番号_605 = new RString("605");
//    private static final RString 特記事項番号_606 = new RString("606");
//    private static final RString 特記事項番号_607 = new RString("607");
//    private static final RString 特記事項番号_608 = new RString("608");
//    private static final RString 特記事項番号_609 = new RString("609");
//    private static final RString 特記事項番号_610 = new RString("610");
//    private static final RString 特記事項番号_611 = new RString("611");
//    private static final RString 特記事項番号_612 = new RString("612");
//    private static final RString 特記事項番号_6051 = new RString("6051");
//    private static final RString 特記事項番号_6052 = new RString("6052");
//    private static final RString 特記事項番号_6053 = new RString("6053");
//    private static final RString 特記事項番号_6054 = new RString("6054");
//    private static final RString 特記事項番号_6055 = new RString("6055");
//    private static final RString 特記事項番号_6056 = new RString("6056");
//    private static final RString 特記事項番号_701 = new RString("701");
//    private static final RString 特記事項番号_702 = new RString("702");
//    private static final RString フラグ = new RString("1");

    /**
     * コンストラクタです。
     *
     * @param entity NinteiShinseiJohoEntity
     * @param 特記事項情報 List<NinteiTokkijikoEntity>
     */
    public JimuTokkijikoBusiness(
            NinteiShinseiJohoEntity entity,
            List<NinteiTokkijikoEntity> 特記事項情報) {
        this.entity = entity;
        this.特記事項情報 = 特記事項情報;
    }

    /**
     * 名前を取得します。
     *
     * @return 名前
     */
    public RString get名前() {
        if (entity.getHihokenshaName() == null || RString.isNullOrEmpty(entity.getHihokenshaName().getColumnValue())) {
            return RString.EMPTY;
        }
        return entity.getHihokenshaName().getColumnValue();
    }

    /**
     * 被保険者番号を取得します。
     *
     * @return 被保険者番号
     */
    public RString get被保険者番号() {
        return entity.getHihokenshaNo();
    }

    /**
     * 保険者番号を取得します。
     *
     * @return 保険者番号
     */
    public RString get保険者番号() {
        return entity.getShoKisaiHokenshaNo();
    }

    /**
     * 認定申請年月日を取得します。
     *
     * @return 認定申請年月日
     */
    public FlexibleDate get認定申請年月日() {
        return entity.getNinteiShinseiYMD();
    }

    /**
     * 認定調査実施年月日を取得します。
     *
     * @return 認定調査実施年月日
     */
    public FlexibleDate get認定調査実施年月日() {
        return entity.getNinteichosaJisshiYMD();
    }

    /**
     * 介護認定審査会開催年月日を取得します。
     *
     * @return 介護認定審査会開催年月日
     */
    public FlexibleDate get介護認定審査会開催年月日() {
        return entity.getShinsakaiKaisaiYMD();
    }

//    public RString get特記事項Img() {
//        return
//    }
//
//    public RString get特記事項Text() {
//        return
//    }
//
//    public RString getTwo1_特記事項Img() {
//        return
//    }
//
//    public RString getListChosa_1() {
//        return
//    }
//
//    public RString getListChosa1_1() {
//        return
//    }
//
//    public RString get特記Img1() {
//        return
//    }
//
//    public RString get特記Img2() {
//        return
//    }
//
//    public RString get特記Img3() {
//        return
//    }
//
//    public RString get特記Img4() {
//        return
//    }
//
//    public RString get特記Img5() {
//        return
//    }
//
//    public RString get特記Img6() {
//        return
//    }
//
//    public RString get特記Img7() {
//        return
//    }
//
//    public RString get特記Img8() {
//        return
//    }
//
//    public RString get特記Img9() {
//        return
//    }
//
//    public RString get特記Img10() {
//        return
//    }
//
//    public RString get特記Img11() {
//        return
//    }
//
//    public RString get特記Img12() {
//        return
//    }
//
//    public RString get特記Img13() {
//        return
//    }
//
//    public RString get特記Img14() {
//        return
//    }
//
//    public RString get特記Img15() {
//        return
//    }
//
//    public RString get特記Text1() {
//        return
//    }
//
//    public RString get特記Text2() {
//        return
//    }
//
//    public RString get特記Text3() {
//        return
//    }
//
//    public RString get特記Text4() {
//        return
//    }
//
//    public RString get特記Text5() {
//        return
//    }
//
//    public RString get特記Text6() {
//        return
//    }
//
//    public RString get特記Text7() {
//        return
//    }
//
//    public RString get特記Text8() {
//        return
//    }
//
//    public RString get特記Text9() {
//        return
//    }
//
//    public RString get特記Text10() {
//        return
//    }
//
//    public RString get特記Text11() {
//        return
//    }
//
//    public RString get特記Text12() {
//        return
//    }
//
//    public RString get特記Text13() {
//        return
//    }
//
//    public RString get特記Text14() {
//        return
//    }
//
//    public RString get特記Text15() {
//        return
//    }
//
//    public RString getTwo_listChosa_1() {
//        return
//    }
//
//    public RString getTwo_listChosa1_1() {
//        return
//    }
//
//    public RString getTwo_listChosa2_1() {
//        return
//    }
//
//    public RString getTwo_listChosa3_1() {
//        return
//    }
//
//    public RString getTwo_特記Img3() {
//        return
//    }
//
//    public RString getTwo_特記Img4() {
//        return
//    }
//
//    public RString getTwo_特記Img5() {
//        return
//    }
//
//    public RString getTwo_特記Img6() {
//        return
//    }
//
//    public RString getTwo_特記Img7() {
//        return
//    }
//
//    public RString getTwo_特記Img8() {
//        return
//    }
//
//    public RString getTwo_特記Img9() {
//        return
//    }
//
//    public RString getTwo_特記Img10() {
//        return
//    }
//
//    public RString getTwo_特記Img11() {
//        return
//    }
//
//    public RString getTwo_特記Img12() {
//        return
//    }
//
//    public RString getTwo_特記Img13() {
//        return
//    }
//
//    public RString getTwo_特記Img14() {
//        return
//    }
//
//    public RString getTwo_特記Img15() {
//        return
//    }
//
//    public RString getTwo_特記Img16() {
//        return
//    }
//
//    public RString getTwo_特記Img17() {
//        return
//    }
//
//    public RString getTwo_特記Img18() {
//        return
//    }
//
//    public RString getTwo_特記Img19() {
//        return
//    }
//
//    public RString getTwo_特記Img20() {
//        return
//    }
//
//    public RString getTwo_特記Img21() {
//        return
//    }
//
//    public RString getTwo_特記Img22() {
//        return
//    }
//
//    public RString getTwo_特記Img23() {
//        return
//    }
//
//    public RString getTwo_特記Img24() {
//        return
//    }
//
//    public RString getTwo_特記Img25() {
//        return
//    }
//
//    public RString getTwo_特記Img26() {
//        return
//    }
//
//    public RString getTwo_特記Img27() {
//        return
//    }
//
//    public RString getTwo_特記Img28() {
//        return
//    }
//
//    public RString getTwo_特記Img29() {
//        return
//    }
//
//    public RString getTwo_特記Img30() {
//        return
//    }
//
//    public RString getTwo_特記Img31() {
//        return
//    }
//
//    public RString getTwo_特記Img32() {
//        return
//    }
//
//    public RString getTwo_特記Img33() {
//        return
//    }
//
//    public RString getTwo_特記Img34() {
//        return
//    }
//
//    public RString getTwo_特記Img35() {
//        return
//    }
//
//    public RString getTwo_特記Img36() {
//        return
//    }
//
//    public RString getTwo_特記Text3() {
//        return
//    }
//
//    public RString getTwo_特記Text4() {
//        return
//    }
//
//    public RString getTwo_特記Text5() {
//        return
//    }
//
//    public RString getTwo_特記Text6() {
//        return
//    }
//
//    public RString getTwo_特記Text7() {
//        return
//    }
//
//    public RString getTwo_特記Text8() {
//        return
//    }
//
//    public RString getTwo_特記Text9() {
//        return
//    }
//
//    public RString getTwo_特記Text10() {
//        return
//    }
//
//    public RString getTwo_特記Text11() {
//        return
//    }
//
//    public RString getTwo_特記Text12() {
//        return
//    }
//
//    public RString getTwo_特記Text13() {
//        return
//    }
//
//    public RString getTwo_特記Text14() {
//        return
//    }
//
//    public RString getTwo_特記Text15() {
//        return
//    }
//
//    public RString getTwo_特記Text16() {
//        return
//    }
//
//    public RString getTwo_特記Text17() {
//        return
//    }
//
//    public RString getTwo_特記Text18() {
//        return
//    }
//
//    public RString getTwo_特記Text19() {
//        return
//    }
//
//    public RString getTwo_特記Text20() {
//        return
//    }
//
//    public RString getTwo_特記Text21() {
//        return
//    }
//
//    public RString getTwo_特記Text22() {
//        return
//    }
//
//    public RString getTwo_特記Text23() {
//        return
//    }
//
//    public RString getTwo_特記Text24() {
//        return
//    }
//
//    public RString getTwo_特記Text25() {
//        return
//    }
//
//    public RString getTwo_特記Text26() {
//        return
//    }
//
//    public RString getTwo_特記Text27() {
//        return
//    }
//
//    public RString getTwo_特記Text28() {
//        return
//    }
//
//    public RString getTwo_特記Text29() {
//        return
//    }
//
//    public RString getTwo_特記Text30() {
//        return
//    }
//
//    public RString getTwo_特記Text31() {
//        return
//    }
//
//    public RString getTwo_特記Text32() {
//        return
//    }
//
//    public RString getTwo_特記Text33() {
//        return
//    }
//
//    public RString getTwo_特記Text34() {
//        return
//    }
//
//    public RString getTwo_特記Text35() {
//        return
//    }
//
//    public RString getTwo_特記Img1() {
//        return
//    }
//
//    public RString getTwo_特記Img2() {
//        return
//    }
//
//    public RString getTwo_特記Text1() {
//        return
//    }
//
//    public RString getTwo_特記Text2() {
//        return
//    }
//
//    public RString getTwo2_特記Img1() {
//        return
//    }
//
//    public RString getTwo2_特記Img2() {
//        return
//    }
//
//    public RString getThree_listChosa_1() {
//        return
//    }
//
//    public RString getThree_特記Img1() {
//        return
//    }
//
//    public RString getThree_特記Img2() {
//        return
//    }
//
//    public RString getThree_特記Img3() {
//        return
//    }
//
//    public RString getThree_特記Img4() {
//        return
//    }
//
//    public RString getThree_特記Img5() {
//        return
//    }
//
//    public RString getThree_特記Img6() {
//        return
//    }
//
//    public RString getThree_特記Img7() {
//        return
//    }
//
//    public RString getThree_特記Img8() {
//        return
//    }
//
//    public RString getThree_特記Img9() {
//        return
//    }
//
//    public RString getThree_特記Img10() {
//        return
//    }
//
//    public RString getThree_特記Img11() {
//        return
//    }
//
//    public RString getThree_特記Img12() {
//        return
//    }
//
//    public RString getThree_特記Img13() {
//        return
//    }
//
//    public RString getThree_特記Img14() {
//        return
//    }
//
//    public RString getThree_特記Img15() {
//        return
//    }
//
//    public RString getFour_特記Img1() {
//        return
//    }
//
//    public RString getFour_特記Img2() {
//        return
//    }
//
//    public RString getFour_特記Img3() {
//        return
//    }
//
//    public RString getFour_特記Img4() {
//        return
//    }
//
//    public RString getFour_特記Img5() {
//        return
//    }
//
//    public RString getFour_特記Img6() {
//        return
//    }
//
//    public RString getFour_特記Img7() {
//        return
//    }
//
//    public RString getFour_特記Img8() {
//        return
//    }
//
//    public RString getFour_特記Img9() {
//        return
//    }
//
//    public RString getFour_特記Img10() {
//        return
//    }
//
//    public RString getFour_特記Img11() {
//        return
//    }
//
//    public RString getFour_特記Img12() {
//        return
//    }
//
//    public RString getFour_特記Img13() {
//        return
//    }
//
//    public RString getFour_特記Img14() {
//        return
//    }
//
//    public RString getFour_特記Img15() {
//        return
//    }
//
//    public RString getFour_特記Img16() {
//        return
//    }
//
//    public RString getFour_特記Img17() {
//        return
//    }
//
//    public RString getFour_特記Img18() {
//        return
//    }
//
//    public RString getFour_特記Img22() {
//        return
//    }
//
//    public RString getFour_特記Img23() {
//        return
//    }
//
//    public RString getFour_特記Img24() {
//        return
//    }
//
//    public RString getFour_特記Img25() {
//        return
//    }
//
//    public RString getFour_特記Img26() {
//        return
//    }
//
//    public RString getFour_特記Img27() {
//        return
//    }
//
//    public RString getFour_特記Img28() {
//        return
//    }
//
//    public RString getFour_特記Img29() {
//        return
//    }
//
//    public RString getFour_特記Img30() {
//        return
//    }
//
//    public RString getFour_特記Img31() {
//        return
//    }
//
//    public RString getFour_特記Img32() {
//        return
//    }
//
//    public RString getFour_特記Img33() {
//        return
//    }
//
//    public RString getFour_特記Img34() {
//        return
//    }
//
//    public RString getFour_特記Img19() {
//        return
//    }
//
//    public RString getFour_特記Img20() {
//        return
//    }
//
//    public RString getFour_特記Img21() {
//        return
//    }
    /**
     * 特記事項名を取得します。
     *
     * @return 特記事項名
     */
    public RString get特記事項名() {
        if (特記事項情報 != null && !特記事項情報.isEmpty()) {
            for (NinteiTokkijikoEntity 特記事項 : 特記事項情報) {
                return 特記事項.getTokkiJiko();
            }
            return RString.EMPTY;
        }
        return RString.EMPTY;
    }
//
//    private RString get特記事項番号() {
//        if (特記事項情報 != null && !特記事項情報.isEmpty()) {
//            for (NinteiTokkijikoEntity 特記事項 : 特記事項情報) {
//                return 特記事項.getNinteichosaTokkijikoNo();
//            }
//            return RString.EMPTY;
//        }
//        return RString.EMPTY;
//    }
//
//    private RString getイメージ() {
//        if (特記事項情報 != null && !特記事項情報.isEmpty()) {
//            for (NinteiTokkijikoEntity 特記事項 : 特記事項情報) {
//                return 共有ファイルを引き出す(特記事項.getImageSharedFileId(), 特記事項.getNinteichosaTokkijikoNo(),
//                        new RString(特記事項.getRokkijikoRemban()));
//            }
//            return RString.EMPTY;
//        }
//        return RString.EMPTY;
//    }
//
//    private RString get共有ファイル(RString 特記事項番号, RString 特記事項連番) {
//        RString imageName = RString.EMPTY;
//        RStringBuilder builder = new RStringBuilder();
//        if (特記事項番号_101.equals(特記事項番号)) {
//            builder.append(new RString("C3001-"));
//            builder.append(特記事項連番);
//            imageName = builder.toRString();
//        }
//        if (特記事項番号_102.equals(特記事項番号)) {
//            builder.append(new RString("C3006-"));
//            builder.append(特記事項連番);
//            imageName = builder.toRString();
//        }
//        if (特記事項番号_103.equals(特記事項番号)) {
//            builder.append(new RString("C3010-"));
//            builder.append(特記事項連番);
//            imageName = builder.toRString();
//        }
//        if (特記事項番号_104.equals(特記事項番号)) {
//            builder.append(new RString("C3011-"));
//            builder.append(特記事項連番);
//            imageName = builder.toRString();
//        }
//        if (特記事項番号_105.equals(特記事項番号)) {
//            builder.append(new RString("C3012-"));
//            builder.append(特記事項連番);
//            imageName = builder.toRString();
//        }
//        if (特記事項番号_106.equals(特記事項番号)) {
//            builder.append(new RString("C3013-"));
//            builder.append(特記事項連番);
//            imageName = builder.toRString();
//        }
//        if (特記事項番号_107.equals(特記事項番号)) {
//            builder.append(new RString("C3014-"));
//            builder.append(特記事項連番);
//            imageName = builder.toRString();
//        }
//        if (特記事項番号_108.equals(特記事項番号)) {
//            builder.append(new RString("C3015-"));
//            builder.append(特記事項連番);
//            imageName = builder.toRString();
//        }
//        if (特記事項番号_109.equals(特記事項番号)) {
//            builder.append(new RString("C3016-"));
//            builder.append(特記事項連番);
//            imageName = builder.toRString();
//        }
//        if (特記事項番号_110.equals(特記事項番号)) {
//            builder.append(new RString("C3017-"));
//            builder.append(特記事項連番);
//            imageName = builder.toRString();
//        }
//        if (特記事項番号_111.equals(特記事項番号)) {
//            builder.append(new RString("C3018-"));
//            builder.append(特記事項連番);
//            imageName = builder.toRString();
//        }
//        if (特記事項番号_112.equals(特記事項番号)) {
//            builder.append(new RString("C3019-"));
//            builder.append(特記事項連番);
//            imageName = builder.toRString();
//        }
//        if (特記事項番号_113.equals(特記事項番号)) {
//            builder.append(new RString("C3020-"));
//            builder.append(特記事項連番);
//            imageName = builder.toRString();
//        }
//        builder.append(get特記事項2(特記事項番号, 特記事項連番));
//        builder.append(get特記事項3(特記事項番号, 特記事項連番));
//        builder.append(get特記事項4(特記事項番号, 特記事項連番));
//        builder.append(get特記事項5(特記事項番号, 特記事項連番));
//        builder.append(get特記事項6(特記事項番号, 特記事項連番));
//        return imageName;
//    }
//
//    private RString get特記事項2(RString 特記事項番号, RString 特記事項連番) {
//        RString imageName = RString.EMPTY;
//        RStringBuilder builder = new RStringBuilder();
//        if (特記事項番号_201.equals(特記事項番号)) {
//            builder.append(new RString("C3021-"));
//            builder.append(特記事項連番);
//            imageName = builder.toRString();
//        }
//        if (特記事項番号_202.equals(特記事項番号)) {
//            builder.append(new RString("C3022-"));
//            builder.append(特記事項連番);
//            imageName = builder.toRString();
//        }
//        if (特記事項番号_203.equals(特記事項番号)) {
//            builder.append(new RString("C3023-"));
//            builder.append(特記事項連番);
//            imageName = builder.toRString();
//        }
//        if (特記事項番号_204.equals(特記事項番号)) {
//            builder.append(new RString("C3024-"));
//            builder.append(特記事項連番);
//            imageName = builder.toRString();
//        }
//        if (特記事項番号_205.equals(特記事項番号)) {
//            builder.append(new RString("C3025-"));
//            builder.append(特記事項連番);
//            imageName = builder.toRString();
//        }
//        if (特記事項番号_206.equals(特記事項番号)) {
//            builder.append(new RString("C3026-"));
//            builder.append(特記事項連番);
//            imageName = builder.toRString();
//        }
//        if (特記事項番号_207.equals(特記事項番号)) {
//            builder.append(new RString("C3027-"));
//            builder.append(特記事項連番);
//            imageName = builder.toRString();
//        }
//        if (特記事項番号_208.equals(特記事項番号)) {
//            builder.append(new RString("C3028-"));
//            builder.append(特記事項連番);
//            imageName = builder.toRString();
//        }
//        if (特記事項番号_209.equals(特記事項番号)) {
//            builder.append(new RString("C3029-"));
//            builder.append(特記事項連番);
//            imageName = builder.toRString();
//        }
//        if (特記事項番号_210.equals(特記事項番号)) {
//            builder.append(new RString("C3030-"));
//            builder.append(特記事項連番);
//            imageName = builder.toRString();
//        }
//        if (特記事項番号_211.equals(特記事項番号)) {
//            builder.append(new RString("C3031-"));
//            builder.append(特記事項連番);
//            imageName = builder.toRString();
//        }
//        if (特記事項番号_212.equals(特記事項番号)) {
//            builder.append(new RString("C3032-"));
//            builder.append(特記事項連番);
//            imageName = builder.toRString();
//        }
//        if (特記事項番号_301.equals(特記事項番号)) {
//            builder.append(new RString("C3033-"));
//            builder.append(特記事項連番);
//            imageName = builder.toRString();
//        }
//        if (特記事項番号_302.equals(特記事項番号)) {
//            builder.append(new RString("C3034-"));
//            builder.append(特記事項連番);
//            imageName = builder.toRString();
//        }
//        if (特記事項番号_303.equals(特記事項番号)) {
//            builder.append(new RString("C3035-"));
//            builder.append(特記事項連番);
//            imageName = builder.toRString();
//        }
//        return imageName;
//    }
//
//    private RString get特記事項3(RString 特記事項番号, RString 特記事項連番) {
//        RString imageName = RString.EMPTY;
//        RStringBuilder builder = new RStringBuilder();
//        if (特記事項番号_304.equals(特記事項番号)) {
//            builder.append(new RString("C3036-"));
//            builder.append(特記事項連番);
//            imageName = builder.toRString();
//        }
//        if (特記事項番号_305.equals(特記事項番号)) {
//            builder.append(new RString("C3037-"));
//            builder.append(特記事項連番);
//            imageName = builder.toRString();
//        }
//        if (特記事項番号_306.equals(特記事項番号)) {
//            builder.append(new RString("C3038-"));
//            builder.append(特記事項連番);
//            imageName = builder.toRString();
//        }
//        if (特記事項番号_307.equals(特記事項番号)) {
//            builder.append(new RString("C3039-"));
//            builder.append(特記事項連番);
//            imageName = builder.toRString();
//        }
//        if (特記事項番号_308.equals(特記事項番号)) {
//            builder.append(new RString("C3040-"));
//            builder.append(特記事項連番);
//            imageName = builder.toRString();
//        }
//        if (特記事項番号_309.equals(特記事項番号)) {
//            builder.append(new RString("C3041-"));
//            builder.append(特記事項連番);
//            imageName = builder.toRString();
//        }
//        if (特記事項番号_408.equals(特記事項番号)) {
//            builder.append(new RString("C3049-"));
//            builder.append(特記事項連番);
//            imageName = builder.toRString();
//        }
//        if (特記事項番号_409.equals(特記事項番号)) {
//            builder.append(new RString("C3050-"));
//            builder.append(特記事項連番);
//            imageName = builder.toRString();
//        }
//        if (特記事項番号_410.equals(特記事項番号)) {
//            builder.append(new RString("C3051-"));
//            builder.append(特記事項連番);
//            imageName = builder.toRString();
//        }
//        if (特記事項番号_411.equals(特記事項番号)) {
//            builder.append(new RString("C3052-"));
//            builder.append(特記事項連番);
//            imageName = builder.toRString();
//        }
//        if (特記事項番号_412.equals(特記事項番号)) {
//            builder.append(new RString("C3053-"));
//            builder.append(特記事項連番);
//            imageName = builder.toRString();
//        }
//        if (特記事項番号_413.equals(特記事項番号)) {
//            builder.append(new RString("C3054-"));
//            builder.append(特記事項連番);
//            imageName = builder.toRString();
//        }
//        if (特記事項番号_414.equals(特記事項番号)) {
//            builder.append(new RString("C3055-"));
//            builder.append(特記事項連番);
//            imageName = builder.toRString();
//        }
//        if (特記事項番号_415.equals(特記事項番号)) {
//            builder.append(new RString("C3056-"));
//            builder.append(特記事項連番);
//            imageName = builder.toRString();
//        }
//        if (特記事項番号_701.equals(特記事項番号)) {
//            builder.append(new RString("C3075-"));
//            builder.append(特記事項連番);
//            imageName = builder.toRString();
//        }
//        if (特記事項番号_702.equals(特記事項番号)) {
//            builder.append(new RString("C3076-"));
//            builder.append(特記事項連番);
//            imageName = builder.toRString();
//        }
//        return imageName;
//    }
//
//    private RString get特記事項401(RString 特記事項番号, RString 特記事項連番) {
//        RString imageName = RString.EMPTY;
//        RStringBuilder builder = new RStringBuilder();
//        if (KoroshoIfShikibetsuCode.認定ｿﾌﾄ99.getコード().equals(entity.getKoroshoIfShikibetsuCode().getColumnValue())
//                || KoroshoIfShikibetsuCode.認定ｿﾌﾄ2009.getコード().equals(entity.getKoroshoIfShikibetsuCode().getColumnValue())
//                || KoroshoIfShikibetsuCode.認定ｿﾌﾄ2009_SP3.getコード().equals(entity.getKoroshoIfShikibetsuCode().getColumnValue())) {
//            if (特記事項番号_401.equals(特記事項番号)) {
//                builder.append(new RString("C3042-"));
//                builder.append(特記事項連番);
//                imageName = builder.toRString();
//            }
//            if (特記事項番号_402.equals(特記事項番号)) {
//                builder.append(new RString("C3043-"));
//                builder.append(特記事項連番);
//                imageName = builder.toRString();
//            }
//            if (特記事項番号_403.equals(特記事項番号)) {
//                builder.append(new RString("C3044-"));
//                builder.append(特記事項連番);
//                imageName = builder.toRString();
//            }
//            if (特記事項番号_404.equals(特記事項番号)) {
//                builder.append(new RString("C3045-"));
//                builder.append(特記事項連番);
//                imageName = builder.toRString();
//            }
//            if (特記事項番号_405.equals(特記事項番号)) {
//                builder.append(new RString("C3046-"));
//                builder.append(特記事項連番);
//                imageName = builder.toRString();
//            }
//            if (特記事項番号_406.equals(特記事項番号)) {
//                builder.append(new RString("C3047-"));
//                builder.append(特記事項連番);
//                imageName = builder.toRString();
//            }
//            if (特記事項番号_407.equals(特記事項番号)) {
//                builder.append(new RString("C3048-"));
//                builder.append(特記事項連番);
//                imageName = builder.toRString();
//            }
//        }
//        return imageName;
//    }
//
//    private RString get特記事項4(RString 特記事項番号, RString 特記事項連番) {
//        RString imageName = RString.EMPTY;
//        RStringBuilder builder = new RStringBuilder();
//        builder.append(get特記事項401(特記事項番号, 特記事項連番));
//        if (KoroshoIfShikibetsuCode.認定ｿﾌﾄ2002.getコード().equals(entity.getKoroshoIfShikibetsuCode().getColumnValue())) {
//            if (特記事項番号_4011.equals(特記事項番号)) {
//                builder.append(new RString("C3042-"));
//                builder.append(特記事項連番);
//                imageName = builder.toRString();
//            }
//            if (特記事項番号_4012.equals(特記事項番号)) {
//                builder.append(new RString("C3043-"));
//                builder.append(特記事項連番);
//                imageName = builder.toRString();
//            }
//            if (特記事項番号_402.equals(特記事項番号)) {
//                builder.append(new RString("C3044-"));
//                builder.append(特記事項連番);
//                imageName = builder.toRString();
//            }
//            if (特記事項番号_403.equals(特記事項番号)) {
//                builder.append(new RString("C3045-"));
//                builder.append(特記事項連番);
//                imageName = builder.toRString();
//            }
//            if (特記事項番号_404.equals(特記事項番号)) {
//                builder.append(new RString("C3046-"));
//                builder.append(特記事項連番);
//                imageName = builder.toRString();
//            }
//            if (特記事項番号_406.equals(特記事項番号)) {
//                builder.append(new RString("C3047-"));
//                builder.append(特記事項連番);
//                imageName = builder.toRString();
//            }
//            if (特記事項番号_407.equals(特記事項番号)) {
//                builder.append(new RString("C3048-"));
//                builder.append(特記事項連番);
//                imageName = builder.toRString();
//            }
//        }
//        if (KoroshoIfShikibetsuCode.認定ｿﾌﾄ2006_新要介護認定適用区分が未適用.getコード().equals(entity.getKoroshoIfShikibetsuCode().getColumnValue())) {
//            if (特記事項番号_4011.equals(特記事項番号)) {
//                builder.append(new RString("C3042-"));
//                builder.append(特記事項連番);
//                imageName = builder.toRString();
//            }
//            if (特記事項番号_4012.equals(特記事項番号)) {
//                builder.append(new RString("C3043-"));
//                builder.append(特記事項連番);
//                imageName = builder.toRString();
//            }
//            if (特記事項番号_402.equals(特記事項番号)) {
//                builder.append(new RString("C3044-"));
//                builder.append(特記事項連番);
//                imageName = builder.toRString();
//            }
//            if (特記事項番号_403.equals(特記事項番号)) {
//                builder.append(new RString("C3045-"));
//                builder.append(特記事項連番);
//                imageName = builder.toRString();
//            }
//            if (特記事項番号_404.equals(特記事項番号)) {
//                builder.append(new RString("C3046-"));
//                builder.append(特記事項連番);
//                imageName = builder.toRString();
//            }
//            if (特記事項番号_405.equals(特記事項番号)) {
//                builder.append(new RString("C3047-"));
//                builder.append(特記事項連番);
//                imageName = builder.toRString();
//            }
//            if (特記事項番号_406.equals(特記事項番号)) {
//                builder.append(new RString("C3048-"));
//                builder.append(特記事項連番);
//                imageName = builder.toRString();
//            }
//        }
//        return imageName;
//    }
//
//    private RString get特記事項5(RString 特記事項番号, RString 特記事項連番) {
//        RString imageName = RString.EMPTY;
//        RStringBuilder builder = new RStringBuilder();
//        if (KoroshoIfShikibetsuCode.認定ｿﾌﾄ99.getコード().equals(entity.getKoroshoIfShikibetsuCode().getColumnValue())
//                || KoroshoIfShikibetsuCode.認定ｿﾌﾄ2009.getコード().equals(entity.getKoroshoIfShikibetsuCode().getColumnValue())
//                || KoroshoIfShikibetsuCode.認定ｿﾌﾄ2002.getコード().equals(entity.getKoroshoIfShikibetsuCode().getColumnValue())
//                || KoroshoIfShikibetsuCode.認定ｿﾌﾄ2009_SP3.getコード().equals(entity.getKoroshoIfShikibetsuCode().getColumnValue())) {
//            if (特記事項番号_501.equals(特記事項番号)) {
//                builder.append(new RString("C3057-"));
//                builder.append(特記事項連番);
//                imageName = builder.toRString();
//            }
//            if (特記事項番号_502.equals(特記事項番号)) {
//                builder.append(new RString("C3058-"));
//                builder.append(特記事項連番);
//                imageName = builder.toRString();
//            }
//            if (特記事項番号_503.equals(特記事項番号)) {
//                builder.append(new RString("C3059-"));
//                builder.append(特記事項連番);
//                imageName = builder.toRString();
//            }
//            if (特記事項番号_504.equals(特記事項番号)) {
//                builder.append(new RString("C3060-"));
//                builder.append(特記事項連番);
//                imageName = builder.toRString();
//            }
//            if (特記事項番号_505.equals(特記事項番号)) {
//                builder.append(new RString("C3061-"));
//                builder.append(特記事項連番);
//                imageName = builder.toRString();
//            }
//            if (特記事項番号_506.equals(特記事項番号)) {
//                builder.append(new RString("C3062-"));
//                builder.append(特記事項連番);
//                imageName = builder.toRString();
//            }
//        }
//        if (KoroshoIfShikibetsuCode.認定ｿﾌﾄ2006_新要介護認定適用区分が未適用.getコード().equals(entity.getKoroshoIfShikibetsuCode().getColumnValue())) {
//            if (特記事項番号_5011.equals(特記事項番号)) {
//                builder.append(new RString("C3057-"));
//                builder.append(特記事項連番);
//                imageName = builder.toRString();
//            }
//            if (特記事項番号_5012.equals(特記事項番号)) {
//                builder.append(new RString("C3058-"));
//                builder.append(特記事項連番);
//                imageName = builder.toRString();
//            }
//            if (特記事項番号_5013.equals(特記事項番号)) {
//                builder.append(new RString("C3059-"));
//                builder.append(特記事項連番);
//                imageName = builder.toRString();
//            }
//            if (特記事項番号_5014.equals(特記事項番号)) {
//                builder.append(new RString("C3060-"));
//                builder.append(特記事項連番);
//                imageName = builder.toRString();
//            }
//            if (特記事項番号_5021.equals(特記事項番号)) {
//                builder.append(new RString("C3061-"));
//                builder.append(特記事項連番);
//                imageName = builder.toRString();
//            }
//            if (特記事項番号_5022.equals(特記事項番号)) {
//                builder.append(new RString("C3062-"));
//                builder.append(特記事項連番);
//                imageName = builder.toRString();
//            }
//        }
//        return imageName;
//    }
//
//    private RString get特記事項601(RString 特記事項番号, RString 特記事項連番) {
//        RString imageName = RString.EMPTY;
//        RStringBuilder builder = new RStringBuilder();
//        if (特記事項番号_601.equals(特記事項番号)) {
//            builder.append(new RString("C3063-"));
//            builder.append(特記事項連番);
//            imageName = builder.toRString();
//        }
//        if (特記事項番号_602.equals(特記事項番号)) {
//            builder.append(new RString("C3064-"));
//            builder.append(特記事項連番);
//            imageName = builder.toRString();
//        }
//        if (特記事項番号_603.equals(特記事項番号)) {
//            builder.append(new RString("C3065-"));
//            builder.append(特記事項連番);
//            imageName = builder.toRString();
//        }
//        if (特記事項番号_604.equals(特記事項番号)) {
//            builder.append(new RString("C3066-"));
//            builder.append(特記事項連番);
//            imageName = builder.toRString();
//        }
//        if (特記事項番号_611.equals(特記事項番号)) {
//            builder.append(new RString("C3073-"));
//            builder.append(特記事項連番);
//            imageName = builder.toRString();
//        }
//        if (特記事項番号_612.equals(特記事項番号)) {
//            builder.append(new RString("C3074-"));
//            builder.append(特記事項連番);
//            imageName = builder.toRString();
//        }
//        return imageName;
//    }
//
//    private RString get特記事項6(RString 特記事項番号, RString 特記事項連番) {
//        RString imageName = RString.EMPTY;
//        RStringBuilder builder = new RStringBuilder();
//        builder.append(get特記事項601(特記事項番号, 特記事項連番));
//        if (KoroshoIfShikibetsuCode.認定ｿﾌﾄ99.getコード().equals(entity.getKoroshoIfShikibetsuCode().getColumnValue())
//                || KoroshoIfShikibetsuCode.認定ｿﾌﾄ2009.getコード().equals(entity.getKoroshoIfShikibetsuCode().getColumnValue())
//                || KoroshoIfShikibetsuCode.認定ｿﾌﾄ2002.getコード().equals(entity.getKoroshoIfShikibetsuCode().getColumnValue())
//                || KoroshoIfShikibetsuCode.認定ｿﾌﾄ2009_SP3.getコード().equals(entity.getKoroshoIfShikibetsuCode().getColumnValue())) {
//            if (特記事項番号_605.equals(特記事項番号)) {
//                builder.append(new RString("C3067-"));
//                builder.append(特記事項連番);
//                imageName = builder.toRString();
//            }
//            if (特記事項番号_606.equals(特記事項番号)) {
//                builder.append(new RString("C3068-"));
//                builder.append(特記事項連番);
//                imageName = builder.toRString();
//            }
//            if (特記事項番号_607.equals(特記事項番号)) {
//                builder.append(new RString("C3069-"));
//                builder.append(特記事項連番);
//                imageName = builder.toRString();
//            }
//            if (特記事項番号_608.equals(特記事項番号)) {
//                builder.append(new RString("C3070-"));
//                builder.append(特記事項連番);
//                imageName = builder.toRString();
//            }
//            if (特記事項番号_609.equals(特記事項番号)) {
//                builder.append(new RString("C3071-"));
//                builder.append(特記事項連番);
//                imageName = builder.toRString();
//            }
//            if (特記事項番号_610.equals(特記事項番号)) {
//                builder.append(new RString("C3072-"));
//                builder.append(特記事項連番);
//                imageName = builder.toRString();
//            }
//        }
//        if (KoroshoIfShikibetsuCode.認定ｿﾌﾄ2006_新要介護認定適用区分が未適用.getコード().equals(entity.getKoroshoIfShikibetsuCode().getColumnValue())) {
//            if (特記事項番号_6051.equals(特記事項番号)) {
//                builder.append(new RString("C3067-"));
//                builder.append(特記事項連番);
//                imageName = builder.toRString();
//            }
//            if (特記事項番号_6052.equals(特記事項番号)) {
//                builder.append(new RString("C3068-"));
//                builder.append(特記事項連番);
//                imageName = builder.toRString();
//            }
//            if (特記事項番号_6053.equals(特記事項番号)) {
//                builder.append(new RString("C3069-"));
//                builder.append(特記事項連番);
//                imageName = builder.toRString();
//            }
//            if (特記事項番号_6054.equals(特記事項番号)) {
//                builder.append(new RString("C3070-"));
//                builder.append(特記事項連番);
//                imageName = builder.toRString();
//            }
//            if (特記事項番号_6055.equals(特記事項番号)) {
//                builder.append(new RString("C3071-"));
//                builder.append(特記事項連番);
//                imageName = builder.toRString();
//            }
//            if (特記事項番号_6056.equals(特記事項番号)) {
//                builder.append(new RString("C3072-"));
//                builder.append(特記事項連番);
//                imageName = builder.toRString();
//            }
//        }
//        return imageName;
//    }

//    private RString 共有ファイルを引き出す(RDateTime イメージID, RString 特記事項番号, RString 特記事項連番) {
//        RStringBuilder builder = new RStringBuilder();
//        RString imagePath = RString.EMPTY;
//        RString fileName = get共有ファイル(特記事項番号, 特記事項連番);
//        if (イメージID != null && !RString.isNullOrEmpty(fileName)) {
//            RString ファイル = builder.append(fileName).append(".png").toRString();
//            if (RString.isNullOrEmpty(getFilePathBak(イメージID, ファイル))) {
//                imagePath = getFilePathBak(イメージID, fileName.replace(".png", "_BAK.png"));
//            }
//        }
//        return imagePath;
//    }
//
//    private RString getFilePathBak(RDateTime sharedFileId, RString sharedFileName) {
//        RString imagePath = Path.combinePath(Path.getUserHomePath(), new RString("app/webapps/db#dbe/WEB-INF/image/"));
//        ReadOnlySharedFileEntryDescriptor descriptor
//                = new ReadOnlySharedFileEntryDescriptor(new FilesystemName(sharedFileName),
//                        sharedFileId);
//        try {
//            SharedFile.copyToLocal(descriptor, new FilesystemPath(imagePath));
//        } catch (Exception e) {
//            return RString.EMPTY;
//        }
//        return Path.combinePath(new RString("/db/dbe/image/"), sharedFileName);
//    }
}
