/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.shiryoshinsakai;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.shiryoshinsakai.ShinsakaiSiryoKyotsuEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.tokkitexta4.TokkiA4Entity;
import jp.co.ndensan.reams.db.dbz.definition.core.chosahyokomoku.NinteichosaKomoku02A;
import jp.co.ndensan.reams.db.dbz.definition.core.chosahyokomoku.NinteichosaKomoku06A;
import jp.co.ndensan.reams.db.dbz.definition.core.chosahyokomoku.NinteichosaKomoku09A;
import jp.co.ndensan.reams.db.dbz.definition.core.chosahyokomoku.NinteichosaKomoku09B;
import jp.co.ndensan.reams.db.dbz.definition.core.chosahyokomoku.NinteichosaKomoku99A;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.KoroshoIfShikibetsuCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.TokkijikoTextImageKubun;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5205NinteichosahyoTokkijikoEntity;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.io.File;
import jp.co.ndensan.reams.uz.uza.io.Path;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;

/**
 * 特記事項帳票の項目編集クラスです。
 */
public class TokkiJiko {

    private static final RString テキスト = new RString("1");
    private static final RString イメージ = new RString("2");
    private static final RString ハイフン = new RString("-");
    private static final RString ファイル名_特記事項 = new RString("C0007.png");
    private static final RString ファイル名_特記事項原本 = new RString("C0007_BAK.png");
    private static final RString ファイルID_C410 = new RString("C410");
    private static final RString BAK = new RString("_BAK");
    private static final RString 拡張子_PNG = new RString(".png");
    private static final int 最大ページ = 6;
    private static final int 最大連番 = 10;
    private static final int SIZE_5 = 5;

    private final ShinsakaiSiryoKyotsuEntity kyotsuEntity;
    private final List<TokkiA4Entity> 短冊テキストリスト;
    private final List<RString> 全画面イメージリスト;
    private final List<TokkiA4Entity> 短冊イメージリスト;
    private final RString imageFileDirectoryPath;

    /**
     * コンストラクタです。
     *
     * @param kyotsuEntity {@link ShinsakaiSiryoKyotsuEntity}
     * @param 特記情報List {@link DbT5205NinteichosahyoTokkijikoEntity}のリスト
     * @param imageFileDirectoryPath 画像ファイルのディレクトリパス
     */
    public TokkiJiko(ShinsakaiSiryoKyotsuEntity kyotsuEntity,
            List<DbT5205NinteichosahyoTokkijikoEntity> 特記情報List,
            RString imageFileDirectoryPath) {
        this.kyotsuEntity = kyotsuEntity;
        this.短冊テキストリスト = create短冊テキストリスト(特記情報List);
        this.全画面イメージリスト = create全画面イメージリスト();
        this.短冊イメージリスト = create短冊イメージリスト(特記情報List);
        this.imageFileDirectoryPath = imageFileDirectoryPath;
    }

    /**
     * 申請書管理番号を取得します。
     *
     * @return 申請書管理番号
     */
    public RString get申請書管理番号() {
        return kyotsuEntity.getShinseishoKanriNo().value();
    }

    /**
     * 保険者番号を取得します。
     *
     * @return 保険者番号
     */
    public RString get保険者番号() {
        return kyotsuEntity.getShoKisaiHokenshaNo();
    }

    /**
     * 被保険者番号を取得します。
     *
     * @return 被保険者番号
     */
    public RString get被保険者番号() {
        return kyotsuEntity.getHihokenshaNo();
    }

    /**
     * 名前を取得します。
     *
     * @return 名前
     */
    public RString get名前() {
        return kyotsuEntity.getHihokenshaName().getColumnValue();
    }

    /**
     * 認定申請年月日を取得します。
     *
     * @return 認定申請年月日
     */
    public FlexibleDate get認定申請年月日() {
        return kyotsuEntity.getNinteiShinseiYMD();
    }

    /**
     * 認定調査実施年月日を取得します。
     *
     * @return 認定調査実施年月日
     */
    public FlexibleDate get認定調査実施年月日() {
        return kyotsuEntity.getNinteichosaJisshiYMD();
    }

    /**
     * 介護認定審査会開催年月日を取得します。
     *
     * @return 介護認定審査会開催年月日
     */
    public FlexibleDate get介護認定審査会開催年月日() {
        return kyotsuEntity.getShinsakaiKaisaiYMD();
    }

    /**
     * 概況特記テキスト_イメージ区分を取得します。
     *
     * @return 概況特記テキスト_イメージ区分
     */
    public RString get概況特記テキスト_イメージ区分() {
        return kyotsuEntity.getGaikyoChosaTextImageKubun();
    }

    /**
     * 概況調査の特記事項テキストを取得します。
     *
     * @return 概況調査の特記事項テキスト
     */
    public RString get概況調査の特記事項テキスト() {
        if (テキスト.equals(kyotsuEntity.getGaikyoChosaTextImageKubun())) {
            return kyotsuEntity.getTokki();
        }
        return RString.EMPTY;
    }

    /**
     * 概況調査の特記事項イメージを取得します。
     *
     * @return 概況調査の特記事項イメージ
     */
    public RString get概況調査の特記事項イメージ() {
        if (イメージ.equals(kyotsuEntity.getGaikyoChosaTextImageKubun())) {
            if (kyotsuEntity.isJimukyoku()) {
                return getFilePath(ファイル名_特記事項原本);
            } else {
                return getFilePath(ファイル名_特記事項);
            }
        }
        return RString.EMPTY;
    }

    private RString getFilePath(RString ファイル名) {
        RString filePath = Path.combinePath(imageFileDirectoryPath, new RString(File.separator), ファイル名);
        if (File.exists(filePath)) {
            return filePath;
        }
        return RString.EMPTY;
    }

    /**
     * 委員用区分を取得します。
     *
     * @return 委員用、「true」は委員です、それ以外、委員ではない
     */
    public boolean is委員用() {
        return !kyotsuEntity.isJimukyoku();
    }

    /**
     * 短冊テキストリストを返します。
     *
     * @return 短冊テキストリスト
     */
    public List<TokkiA4Entity> get短冊テキストリスト() {
        return 短冊テキストリスト;
    }

    public List<RString> get全画面イメージリスト() {
        return 全画面イメージリスト;
    }

    /**
     * 短冊イメージリストを返します。
     *
     * @return 短冊イメージリスト
     */
    public List<TokkiA4Entity> get短冊イメージリスト() {
        return 短冊イメージリスト;
    }

    private List<RString> create全画面イメージリスト() {
        List<RString> filePathList = new ArrayList<>();
        for (int i = 1; i <= 最大ページ; i++) {
            RString tokkiImgPath;
            RStringBuilder fileName = new RStringBuilder();
            fileName.append(ファイルID_C410);
            fileName.append(i);
            if (!kyotsuEntity.isJimukyoku()) {
                fileName.append(BAK);
            }
            fileName.append(拡張子_PNG);
            tokkiImgPath = getFilePath(fileName.toRString());
            if (!RString.isNullOrEmpty(tokkiImgPath)) {
                filePathList.add(tokkiImgPath);
            }
        }
        return filePathList;
    }

    private List<TokkiA4Entity> create短冊テキストリスト(List<DbT5205NinteichosahyoTokkijikoEntity> 特記情報List) {
        List<TokkiA4Entity> 短冊情報リスト = new ArrayList<>();
        for (DbT5205NinteichosahyoTokkijikoEntity entity : 特記情報List) {
            if (TokkijikoTextImageKubun.テキスト.getコード().equals(entity.getTokkijikoTextImageKubun())) {
                TokkiA4Entity 短冊情報 = new TokkiA4Entity();
                短冊情報.set事項番号(get項目番号(kyotsuEntity.getKoroshoIfShikibetsuCode(),
                        entity.getNinteichosaTokkijikoNo(), entity.getNinteichosaTokkijikoRemban()));
                短冊情報.set項目名称(get項目名称(kyotsuEntity.getKoroshoIfShikibetsuCode(), entity.getNinteichosaTokkijikoNo()));
                短冊情報.set特記事項テキスト_イメージ(entity.getTokkiJiko());
            }
        }
        return 短冊情報リスト;
    }

    private List<TokkiA4Entity> create短冊イメージリスト(List<DbT5205NinteichosahyoTokkijikoEntity> 特記情報List) {
        List<TokkiA4Entity> 短冊情報リスト = new ArrayList<>();
        for (DbT5205NinteichosahyoTokkijikoEntity entity : 特記情報List) {
            if (TokkijikoTextImageKubun.イメージ.getコード().equals(entity.getTokkijikoTextImageKubun())) {
                RString imageFileName = getFileNameByRemban(
                        entity.getNinteichosaTokkijikoNo(), entity.getNinteichosaTokkijikoRemban());
                TokkiA4Entity 短冊情報 = new TokkiA4Entity();
                短冊情報.set事項番号(get項目番号(kyotsuEntity.getKoroshoIfShikibetsuCode(),
                        entity.getNinteichosaTokkijikoNo(), entity.getNinteichosaTokkijikoRemban()));
                短冊情報.set項目名称(get項目名称(kyotsuEntity.getKoroshoIfShikibetsuCode(), entity.getNinteichosaTokkijikoNo()));
                短冊情報.set特記事項テキスト_イメージ(getFilePath(imageFileName));
            }
        }
        return 短冊情報リスト;
    }

    private RString get項目番号(Code 厚労省IF識別コード, RString 調査特記事項番号, int 連番) {
        RStringBuilder 項目番号 = new RStringBuilder();
        if (KoroshoIfShikibetsuCode.認定ｿﾌﾄ99.getコード().equals(厚労省IF識別コード.value())) {
            項目番号.append(NinteichosaKomoku99A.getAllBy調査特記事項番(調査特記事項番号).get特記事項番号());
        } else if (KoroshoIfShikibetsuCode.認定ｿﾌﾄ2002.getコード().equals(厚労省IF識別コード.value())) {
            項目番号.append(NinteichosaKomoku02A.getAllBy調査特記事項番(調査特記事項番号).get特記事項番号());
        } else if (KoroshoIfShikibetsuCode.認定ｿﾌﾄ2006_新要介護認定適用区分が未適用.getコード().equals(厚労省IF識別コード.value())) {
            項目番号.append(NinteichosaKomoku06A.getAllBy調査特記事項番(調査特記事項番号).get特記事項番号());
        } else if (KoroshoIfShikibetsuCode.認定ｿﾌﾄ2009.getコード().equals(厚労省IF識別コード.value())) {
            項目番号.append(NinteichosaKomoku09A.getAllBy調査特記事項番(調査特記事項番号).get特記事項番号());
        } else if (KoroshoIfShikibetsuCode.認定ｿﾌﾄ2009_SP3.getコード().equals(厚労省IF識別コード.value())) {
            項目番号.append(NinteichosaKomoku09B.getAllBy調査特記事項番(調査特記事項番号).get特記事項番号());
        }
        if (!RString.isNullOrEmpty(項目番号.toRString())) {
            項目番号.append(ハイフン);
            項目番号.append(連番);
        }
        return 項目番号.toRString();
    }

    private RString get項目名称(Code 厚労省IF識別コード, RString 調査特記事項番号) {
        if (KoroshoIfShikibetsuCode.認定ｿﾌﾄ99.getコード().equals(厚労省IF識別コード.value())) {
            return NinteichosaKomoku99A.getAllBy調査特記事項番(調査特記事項番号).get名称();
        }
        if (KoroshoIfShikibetsuCode.認定ｿﾌﾄ2002.getコード().equals(厚労省IF識別コード.value())) {
            return NinteichosaKomoku02A.getAllBy調査特記事項番(調査特記事項番号).get名称();
        }
        if (KoroshoIfShikibetsuCode.認定ｿﾌﾄ2006_新要介護認定適用区分が未適用.getコード().equals(厚労省IF識別コード.value())) {
            return NinteichosaKomoku06A.getAllBy調査特記事項番(調査特記事項番号).get名称();
        }
        if (KoroshoIfShikibetsuCode.認定ｿﾌﾄ2009.getコード().equals(厚労省IF識別コード.value())) {
            return NinteichosaKomoku09A.getAllBy調査特記事項番(調査特記事項番号).get名称();
        }
        if (KoroshoIfShikibetsuCode.認定ｿﾌﾄ2009_SP3.getコード().equals(厚労省IF識別コード.value())) {
            return NinteichosaKomoku09B.getAllBy調査特記事項番(調査特記事項番号).get名称();
        }
        return RString.EMPTY;
    }

    private RString getFileNameByRemban(RString 特記事項番号, int 特記事項連番) {
        RStringBuilder イメージファイル = new RStringBuilder();
        RString ファイル名 = getファイル名By特記番号(特記事項番号);
        if (!RString.isNullOrEmpty(ファイル名)) {
            イメージファイル.append(ファイル名);
            for (int i = 0; i <= 最大連番; i++) {
                if (i == 特記事項連番) {
                    イメージファイル.append(new RString(特記事項連番).padZeroToLeft(2));
                    break;
                }
            }
            if (kyotsuEntity.isJimukyoku()) {
                イメージファイル.append("_BAK");
            }
            return イメージファイル.append(".png").toRString();
        }
        return RString.EMPTY;
    }

    private RString getファイル名By特記番号(RString 特記番号) {
        if (特記番号.equals(new RString("101"))) {
            return new RString("C3001-");
        } else if (特記番号.equals(new RString("102"))) {
            return new RString("C3006-");
        } else if (特記番号.equals(new RString("103"))) {
            return new RString("C3010-");
        } else if (特記番号.equals(new RString("104"))) {
            return new RString("C3011-");
        } else if (特記番号.equals(new RString("105"))) {
            return new RString("C3012-");
        } else if (特記番号.equals(new RString("106"))) {
            return new RString("C3013-");
        } else if (特記番号.equals(new RString("107"))) {
            return new RString("C3014-");
        } else if (特記番号.equals(new RString("108"))) {
            return new RString("C3015-");
        } else if (特記番号.equals(new RString("109"))) {
            return new RString("C3016-");
        } else if (特記番号.equals(new RString("110"))) {
            return new RString("C3017-");
        } else if (特記番号.equals(new RString("111"))) {
            return new RString("C3018-");
        } else if (特記番号.equals(new RString("112"))) {
            return new RString("C3019-");
        } else if (特記番号.equals(new RString("113"))) {
            return new RString("C3020-");
        }
        return getファイル名By特記番号2(特記番号);
    }

    private RString getファイル名By特記番号2(RString 特記番号) {
        if (特記番号.equals(new RString("201"))) {
            return new RString("C3021-");
        } else if (特記番号.equals(new RString("202"))) {
            return new RString("C3022-");
        } else if (特記番号.equals(new RString("203"))) {
            return new RString("C3023-");
        } else if (特記番号.equals(new RString("204"))) {
            return new RString("C3024-");
        } else if (特記番号.equals(new RString("205"))) {
            return new RString("C3025-");
        } else if (特記番号.equals(new RString("206"))) {
            return new RString("C3026-");
        } else if (特記番号.equals(new RString("207"))) {
            return new RString("C3027-");
        } else if (特記番号.equals(new RString("208"))) {
            return new RString("C3028-");
        } else if (特記番号.equals(new RString("209"))) {
            return new RString("C3029-");
        } else if (特記番号.equals(new RString("210"))) {
            return new RString("C3030-");
        } else if (特記番号.equals(new RString("211"))) {
            return new RString("C3031-");
        } else if (特記番号.equals(new RString("212"))) {
            return new RString("C3032-");
        }
        return getファイル名By特記番号3(特記番号);
    }

    private RString getファイル名By特記番号3(RString 特記番号) {
        if (特記番号.equals(new RString("301"))) {
            return new RString("C3033-");
        } else if (特記番号.equals(new RString("302"))) {
            return new RString("C3034-");
        } else if (特記番号.equals(new RString("303"))) {
            return new RString("C3035-");
        } else if (特記番号.equals(new RString("304"))) {
            return new RString("C3036-");
        } else if (特記番号.equals(new RString("305"))) {
            return new RString("C3037-");
        } else if (特記番号.equals(new RString("306"))) {
            return new RString("C3038-");
        } else if (特記番号.equals(new RString("307"))) {
            return new RString("C3039-");
        } else if (特記番号.equals(new RString("308"))) {
            return new RString("C3040-");
        } else if (特記番号.equals(new RString("309"))) {
            return new RString("C3041-");
        }
        return getファイル名By特記番号4(特記番号);
    }

    private RString getファイル名By特記番号4(RString 特記番号) {
        if (特記番号.equals(new RString("401"))) {
            return new RString("C3042-");
        } else if (特記番号.equals(new RString("402"))) {
            return new RString("C3043-");
        } else if (特記番号.equals(new RString("403"))) {
            return new RString("C3044-");
        } else if (特記番号.equals(new RString("404"))) {
            return new RString("C3045-");
        } else if (特記番号.equals(new RString("405"))) {
            return new RString("C3046-");
        } else if (特記番号.equals(new RString("406"))) {
            return new RString("C3047-");
        } else if (特記番号.equals(new RString("407"))) {
            return new RString("C3048-");
        } else if (特記番号.equals(new RString("408"))) {
            return new RString("C3049-");
        } else if (特記番号.equals(new RString("409"))) {
            return new RString("C3050-");
        } else if (特記番号.equals(new RString("410"))) {
            return new RString("C3051-");
        } else if (特記番号.equals(new RString("411"))) {
            return new RString("C3052-");
        } else if (特記番号.equals(new RString("412"))) {
            return new RString("C3053-");
        } else if (特記番号.equals(new RString("413"))) {
            return new RString("C3054-");
        } else if (特記番号.equals(new RString("414"))) {
            return new RString("C3055-");
        } else if (特記番号.equals(new RString("415"))) {
            return new RString("C3056-");
        }
        return getファイル名By特記番号5(特記番号);
    }

    private RString getファイル名By特記番号5(RString 特記番号) {
        if (特記番号.equals(new RString("501"))) {
            return new RString("C3057-");
        } else if (特記番号.equals(new RString("502"))) {
            return new RString("C3058-");
        } else if (特記番号.equals(new RString("503"))) {
            return new RString("C3059-");
        } else if (特記番号.equals(new RString("504"))) {
            return new RString("C3060-");
        } else if (特記番号.equals(new RString("505"))) {
            return new RString("C3061-");
        } else if (特記番号.equals(new RString("506"))) {
            return new RString("C3062-");
        }
        return getファイル名By特記番号6(特記番号);
    }

    private RString getファイル名By特記番号6(RString 特記番号) {
        if (特記番号.equals(new RString("601"))) {
            return new RString("C3063-");
        } else if (特記番号.equals(new RString("602"))) {
            return new RString("C3064-");
        } else if (特記番号.equals(new RString("603"))) {
            return new RString("C3065-");
        } else if (特記番号.equals(new RString("604"))) {
            return new RString("C3066-");
        } else if (特記番号.equals(new RString("605"))) {
            return new RString("C3067-");
        } else if (特記番号.equals(new RString("606"))) {
            return new RString("C3068-");
        } else if (特記番号.equals(new RString("607"))) {
            return new RString("C3069-");
        } else if (特記番号.equals(new RString("608"))) {
            return new RString("C3070-");
        } else if (特記番号.equals(new RString("609"))) {
            return new RString("C3071-");
        } else if (特記番号.equals(new RString("610"))) {
            return new RString("C3072-");
        } else if (特記番号.equals(new RString("611"))) {
            return new RString("C3073-");
        } else if (特記番号.equals(new RString("612"))) {
            return new RString("C3074-");
        } else if (特記番号.equals(new RString("701"))) {
            return new RString("C3075-");
        } else if (特記番号.equals(new RString("702"))) {
            return new RString("C3076-");
        }
        return RString.EMPTY;
    }

    /**
     * 識別コードは証記載保険者番号（左から5桁）+被保険者番号を設定してください。
     *
     * @return 識別コード
     */
    public RString get識別コード() {
        if (RString.isNullOrEmpty(kyotsuEntity.getShoKisaiHokenshaNo()) || RString.isNullOrEmpty(kyotsuEntity.getHihokenshaNo())) {
            return RString.EMPTY;
        }
        return kyotsuEntity.getShoKisaiHokenshaNo().substring(0, SIZE_5).concat(kyotsuEntity.getHihokenshaNo());
    }
}
