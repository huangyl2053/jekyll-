/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.shiryoshinsakai;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.ichijihanteikekkahyo.TokkiJikou;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.shiryoshinsakai.ShinsakaiSiryoKyotsuEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBE;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbz.definition.core.chosahyokomoku.NinteichosaKomoku02A;
import jp.co.ndensan.reams.db.dbz.definition.core.chosahyokomoku.NinteichosaKomoku06A;
import jp.co.ndensan.reams.db.dbz.definition.core.chosahyokomoku.NinteichosaKomoku09A;
import jp.co.ndensan.reams.db.dbz.definition.core.chosahyokomoku.NinteichosaKomoku09B;
import jp.co.ndensan.reams.db.dbz.definition.core.chosahyokomoku.NinteichosaKomoku99A;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.KoroshoIfShikibetsuCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.TokkijikoTextImageKubun;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5205NinteichosahyoTokkijikoEntity;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.cooperation.FilesystemName;
import jp.co.ndensan.reams.uz.uza.cooperation.FilesystemPath;
import jp.co.ndensan.reams.uz.uza.cooperation.SharedFile;
import jp.co.ndensan.reams.uz.uza.cooperation.descriptor.ReadOnlySharedFileEntryDescriptor;
import jp.co.ndensan.reams.uz.uza.io.Path;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;

/**
 * 事務局特記事項のEntityの編集クラスです。
 *
 * @reamsid_L DBE-0150-190 linghuhang
 */
public class IchijihanteiekkahyoTokkijiko {

    private static final RString ファイルID_C4101 = new RString("C4101.png");
    private static final RString ファイルID_C4101BAK = new RString("C4101_BAK.png");
    private static final RString テキスト全面イメージ = new RString("1");
    private static final RString ハイフン = new RString("-");
    private static final int 最大連番 = 10;
    private final List<DbT5205NinteichosahyoTokkijikoEntity> 特記情報List;
    private final ShinsakaiSiryoKyotsuEntity kyotsuEntity;
    private final RString 特記パターン;
    private final int 最大文字数;
    private int ページ表示行数;

    /**
     * 事務局一次判定結果票Entityの設定。
     *
     * @param 特記情報List 特記情報List
     * @param kyotsuEntity kyotsuEntity
     */
    public IchijihanteiekkahyoTokkijiko(List<DbT5205NinteichosahyoTokkijikoEntity> 特記情報List, ShinsakaiSiryoKyotsuEntity kyotsuEntity) {
        特記パターン = DbBusinessConfig.get(ConfigNameDBE.審査会資料調査特記パターン, RDate.getNowDate(), SubGyomuCode.DBE認定支援);
        最大文字数 = Integer.parseInt(DbBusinessConfig.get(ConfigNameDBE.特記事項行最大文字数, RDate.getNowDate(), SubGyomuCode.DBE認定支援).toString());
        this.特記情報List = 特記情報List;
        this.kyotsuEntity = kyotsuEntity;
        ページ表示行数 = 0;
    }

    /**
     * 特記パターンが2（短冊テキスト＆短冊イメージ＆全面イメージ）の場合、短冊情報リストを取得します。
     *
     * @return 短冊情報リスト
     */
    public List<TokkiJikou> get短冊情報リスト() {
        List<TokkiJikou> 短冊情報リスト = new ArrayList<>();
        if (!テキスト全面イメージ.equals(特記パターン)) {
            for (DbT5205NinteichosahyoTokkijikoEntity entity : 特記情報List) {
                TokkiJikou 短冊情報 = new TokkiJikou();
                短冊情報.set事項番号(entity.getNinteichosaTokkijikoNo());
                短冊情報.set項目名称(get項目名称(kyotsuEntity.getKoroshoIfShikibetsuCode(), entity.getNinteichosaTokkijikoNo()));
                if (TokkijikoTextImageKubun.テキスト.getコード().equals(entity.getTokkijikoTextImageKubun())) {
                    短冊情報.setテキストとイメージ(entity.getTokkiJiko());
                } else {
                    短冊情報.setテキストとイメージ(getFilePath(kyotsuEntity.getImageSharedFileId(),
                            getFilePathByRemban(entity.getNinteichosaTokkijikoNo(), entity.getNinteichosaTokkijikoRemban())));
                }
                短冊情報リスト.add(短冊情報);
                ページ表示行数 = ページ表示行数 + 1;
            }
        }
        return 短冊情報リスト;
    }

    /**
     * 全面特記事項イメージを取得します。
     *
     * @return 全面特記事項イメージを取得します
     */
    public RString getTokkiImg() {
        if (kyotsuEntity.isJimukyoku()) {
            return getFilePath(kyotsuEntity.getImageSharedFileId(), ファイルID_C4101BAK);
        } else {
            return getFilePath(kyotsuEntity.getImageSharedFileId(), ファイルID_C4101);
        }
    }

    /**
     * 全面特記事項テキストを取得します。
     *
     * @return 全面特記事項テキストを取得します
     */
    public RString getTokkiText() {
        if (テキスト全面イメージ.equals(特記パターン)) {
            return getTextByテキスト全面イメージ();
        }
        return RString.EMPTY;
    }

    /**
     * 全面特記事項テキストを取得します。
     *
     * @return 全面特記事項テキストを取得します
     */
    public RString get特記事項テキスト_イメージ区分() {
        for (DbT5205NinteichosahyoTokkijikoEntity entity : 特記情報List) {
            if (TokkijikoTextImageKubun.テキスト.getコード().equals(entity.getTokkijikoTextImageKubun())) {
                return TokkijikoTextImageKubun.テキスト.getコード();
            }
        }
        return TokkijikoTextImageKubun.イメージ.getコード();
    }

    private RString getTextByテキスト全面イメージ() {
        boolean isテキスト = false;
        RStringBuilder テキスト全面 = new RStringBuilder();
        for (DbT5205NinteichosahyoTokkijikoEntity entity : 特記情報List) {
            if (TokkijikoTextImageKubun.テキスト.getコード().equals(entity.getTokkijikoTextImageKubun())) {
                isテキスト = true;
                RStringBuilder テキスト = new RStringBuilder();
                テキスト.append(get特記事項テキスト(
                        kyotsuEntity.getKoroshoIfShikibetsuCode(), entity.getNinteichosaTokkijikoNo(), entity.getNinteichosaTokkijikoRemban()));
                テキスト.append(entity.getTokkiJiko());
                if ((int) (テキスト.length() / 最大文字数) == 2) {
                    テキスト.insert(最大文字数 * 2, System.lineSeparator());
                }
                if (テキスト.length() % 最大文字数 == 0) {
                    テキスト.insert(最大文字数, System.lineSeparator());
                }
                テキスト.append(System.lineSeparator());
                テキスト全面.append(テキスト.toRString());
            }
        }
        if (isテキスト) {
            return テキスト全面.toRString();
        }
        return RString.EMPTY;
    }

    private RString getFilePathByRemban(RString 特記事項番号, int 特記事項連番) {
        RStringBuilder イメージファイル = new RStringBuilder();
        RString ファイル名 = getファイル名By特記番号(特記事項番号);
        if (!RString.isNullOrEmpty(ファイル名)) {
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

    private RString getFilePath(RDateTime sharedFileId, RString filename) {
        RString imagePath = Path.combinePath(Path.getUserHomePath(), new RString("app/webapps/db#dbe/WEB-INF/image/"));
        ReadOnlySharedFileEntryDescriptor descriptor
                = new ReadOnlySharedFileEntryDescriptor(new FilesystemName(filename),
                        sharedFileId);
        try {
            SharedFile.copyToLocal(descriptor, new FilesystemPath(imagePath));
        } catch (Exception e) {
            return RString.EMPTY;
        }
        return Path.combinePath(new RString("/db/dbe/image/"), filename);
    }

    private RString get特記事項テキスト(Code 厚労省IF識別コード, RString 調査特記事項番号, int 特記事項連番) {
        if (KoroshoIfShikibetsuCode.認定ｿﾌﾄ99.getコード().equals(厚労省IF識別コード.value())) {
            RStringBuilder builder = new RStringBuilder();
            NinteichosaKomoku99A 調査特記事項 = NinteichosaKomoku99A.getAllBy調査特記事項番(調査特記事項番号);
            builder.append(調査特記事項.get特記事項番号());
            builder.append(ハイフン);
            builder.append(特記事項連番);
            builder.append(RString.FULL_SPACE);
            builder.append(調査特記事項.get名称());
            return builder.append(RString.FULL_SPACE).toRString();
        } else if (KoroshoIfShikibetsuCode.認定ｿﾌﾄ2002.getコード().equals(厚労省IF識別コード.value())) {
            RStringBuilder builder = new RStringBuilder();
            NinteichosaKomoku02A 調査特記事項 = NinteichosaKomoku02A.getAllBy調査特記事項番(調査特記事項番号);
            builder.append(調査特記事項.get特記事項番号());
            builder.append(ハイフン);
            builder.append(特記事項連番);
            builder.append(RString.FULL_SPACE);
            builder.append(調査特記事項.get名称());
            return builder.append(RString.FULL_SPACE).toRString();
        } else if (KoroshoIfShikibetsuCode.認定ｿﾌﾄ2006_新要介護認定適用区分が未適用.getコード().equals(厚労省IF識別コード.value())) {
            RStringBuilder builder = new RStringBuilder();
            NinteichosaKomoku06A 調査特記事項 = NinteichosaKomoku06A.getAllBy調査特記事項番(調査特記事項番号);
            builder.append(調査特記事項.get特記事項番号());
            builder.append(ハイフン);
            builder.append(特記事項連番);
            builder.append(RString.FULL_SPACE);
            builder.append(調査特記事項.get名称());
            return builder.append(RString.FULL_SPACE).toRString();
        } else if (KoroshoIfShikibetsuCode.認定ｿﾌﾄ2009.getコード().equals(厚労省IF識別コード.value())) {
            RStringBuilder builder = new RStringBuilder();
            NinteichosaKomoku09A 調査特記事項 = NinteichosaKomoku09A.getAllBy調査特記事項番(調査特記事項番号);
            builder.append(調査特記事項.get特記事項番号());
            builder.append(ハイフン);
            builder.append(特記事項連番);
            builder.append(RString.FULL_SPACE);
            builder.append(調査特記事項.get名称());
            return builder.append(RString.FULL_SPACE).toRString();
        } else if (KoroshoIfShikibetsuCode.認定ｿﾌﾄ2009_SP3.getコード().equals(厚労省IF識別コード.value())) {
            RStringBuilder builder = new RStringBuilder();
            NinteichosaKomoku09B 調査特記事項 = NinteichosaKomoku09B.getAllBy調査特記事項番(調査特記事項番号);
            builder.append(調査特記事項.get特記事項番号());
            builder.append(ハイフン);
            builder.append(特記事項連番);
            builder.append(RString.FULL_SPACE);
            builder.append(調査特記事項.get名称());
            return builder.append(RString.FULL_SPACE).toRString();
        }
        return RString.EMPTY;
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
}
