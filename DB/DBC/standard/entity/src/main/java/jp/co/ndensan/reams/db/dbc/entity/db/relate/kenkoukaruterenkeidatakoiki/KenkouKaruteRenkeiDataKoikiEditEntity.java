/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.kenkoukaruterenkeidatakoiki;

import jp.co.ndensan.reams.uz.uza.io.NewLine;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;

/**
 * 健康かるて連携データ作成（広域用）のEditEntityです。
 *
 * @reamsid_L DBC-5020-011 wangxiaodong
 */
public class KenkouKaruteRenkeiDataKoikiEditEntity {

    private static final int 識別コードLENGTH = 12;
    private static final int 年月日LENGTH = 8;
    private static final int 氏名LENGTH = 70;
    private static final int 減額認定証受給者番号LENGTH = 7;
    private static final int 被保険者番号LENGTH = 15;
    private static final int LENGTH_33 = 33;
    private final KenkoKaruteRenkeiKoikiTempTableEntity entity;

    /**
     * コンストラクタです。
     *
     * @param entity KenkoKaruteRenkeiKoikiTempTableEntity
     */
    public KenkouKaruteRenkeiDataKoikiEditEntity(KenkoKaruteRenkeiKoikiTempTableEntity entity) {
        this.entity = entity;
    }

    /**
     * WriteLine内容をeditします。
     *
     * @return WriteLine内容
     */
    public RString getWriteLine内容() {
        RStringBuilder builder = new RStringBuilder();
        if (RString.isNullOrEmpty(entity.getShikibetsuCode())) {
            builder.append(RString.EMPTY.padRight(RString.HALF_SPACE, 識別コードLENGTH));
        } else if (entity.getShikibetsuCode().length() <= 識別コードLENGTH) {
            builder.append(entity.getShikibetsuCode().padRight(RString.HALF_SPACE, 識別コードLENGTH));
        } else if (識別コードLENGTH < entity.getShikibetsuCode().length()) {
            builder.append(entity.getShikibetsuCode().substring(entity.getShikibetsuCode().length() - 識別コードLENGTH));
        }
        // TODO QA1689 210バイトを判断するAPIが無い
        if (!RString.isNullOrEmpty(entity.getMeisho())) {
            builder.append(entity.getMeisho().padRight(RString.FULL_SPACE, 氏名LENGTH));
        } else {
            builder.append(entity.getKanaMeisho().padRight(RString.FULL_SPACE, 氏名LENGTH));
        }
        builder.append(get年月日(entity.getSeinengappiYMD()));
        builder.append(entity.getSeibetsuCode());
        if (!RString.isNullOrEmpty(entity.getHihokenshaNo())) {
            builder.append(entity.getHihokenshaNo().padRight(RString.HALF_SPACE, 被保険者番号LENGTH));
        } else {
            builder.append(RString.EMPTY.padRight(RString.FULL_SPACE, 氏名LENGTH));
        }
        builder.append(get年月日(entity.getShikakuShutokuYMD()));
        builder.append(get年月日(entity.getShikakuSoshitsuYMD()));
        if (!RString.isNullOrEmpty(entity.getYokaigoJotaiKubunCode())) {
            builder.append(entity.getYokaigoJotaiKubunCode());
        } else {
            builder.append(RString.EMPTY.padRight(RString.HALF_SPACE, 2));
        }
        builder.append(RString.EMPTY.padRight(RString.FULL_SPACE, 減額認定証受給者番号LENGTH));
        builder.append(get年月日(entity.getNinteiYMD()));
        builder.append(get年月日(entity.getNinteiYukoKikanKaishiYMD()));
        builder.append(get年月日(entity.getNinteiYukoKikanShuryoYMD()));
        builder.append(RString.EMPTY.padRight(RString.HALF_SPACE, LENGTH_33));
        builder.append(RDate.getNowDate().toString());
        builder.append(NewLine.CRLF);
        return builder.toRString();
    }

    private RString get年月日(FlexibleDate 年月日) {
        if (年月日 == null || 年月日.isEmpty()) {
            return RString.EMPTY.padRight(RString.HALF_SPACE, 年月日LENGTH);
        }
        return new RString(年月日.toString());
    }
}
