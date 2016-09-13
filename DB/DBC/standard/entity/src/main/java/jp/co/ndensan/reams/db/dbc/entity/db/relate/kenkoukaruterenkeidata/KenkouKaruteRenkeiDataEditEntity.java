/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.kenkoukaruterenkeidata;

import jp.co.ndensan.reams.uz.uza.io.NewLine;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;

/**
 * 健康かるて連携データ作成のEditEntityです。
 *
 * @reamsid_L DBC-5020-030 wangxiaodong
 */
public class KenkouKaruteRenkeiDataEditEntity {

    private static final int 識別コードLENGTH = 12;
    private static final int 年月日LENGTH = 8;
    private static final int 氏名LENGTH = 70;
    private static final int 減額認定証受給者番号LENGTH = 7;
    private static final int 被保険者番号LENGTH = 15;
    private static final int LENGTH_33 = 33;
    private final KenkouKaruteRenkeiDataEntity entity;

    /**
     * コンストラクタです。
     *
     * @param entity KenkouKaruteRenkeiDataEntity
     */
    public KenkouKaruteRenkeiDataEditEntity(KenkouKaruteRenkeiDataEntity entity) {
        this.entity = entity;
    }

    /**
     * WriteLine内容をeditします。
     *
     * @return WriteLine内容
     */
    public RString getWriteLine内容() {
        RStringBuilder builder = new RStringBuilder();
        if (RString.isNullOrEmpty(entity.get識別コード())) {
            builder.append(RString.EMPTY.padRight(RString.HALF_SPACE, 識別コードLENGTH));
        } else if (entity.get識別コード().length() <= 識別コードLENGTH) {
            builder.append(entity.get識別コード().padRight(RString.HALF_SPACE, 識別コードLENGTH));
        } else if (識別コードLENGTH < entity.get識別コード().length()) {
            builder.append(entity.get識別コード().substring(entity.get識別コード().length() - 識別コードLENGTH));
        }
        // TODO QA1689 210バイトを判断するAPIが無い
        if (!RString.isNullOrEmpty(entity.get名称())) {
            builder.append(entity.get名称().padRight(RString.FULL_SPACE, 氏名LENGTH));
        } else {
            builder.append(entity.getカナ名称().padRight(RString.FULL_SPACE, 氏名LENGTH));
        }
        builder.append(get年月日(entity.get生年月日()));
        builder.append(entity.get性別());
        if (!RString.isNullOrEmpty(entity.get被保険者番号())) {
            builder.append(entity.get被保険者番号().padRight(RString.HALF_SPACE, 被保険者番号LENGTH));
        } else {
            builder.append(RString.EMPTY.padRight(RString.FULL_SPACE, 氏名LENGTH));
        }
        builder.append(get年月日(entity.get資格取得年月日()));
        builder.append(get年月日(entity.get資格喪失年月日()));
        if (!RString.isNullOrEmpty(entity.get要介護認定状態区分コード())) {
            builder.append(entity.get要介護認定状態区分コード());
        } else {
            builder.append(RString.EMPTY.padRight(RString.HALF_SPACE, 2));
        }
        builder.append(RString.EMPTY.padRight(RString.FULL_SPACE, 減額認定証受給者番号LENGTH));
        builder.append(get年月日(entity.get認定年月日()));
        builder.append(get年月日(entity.get認定有効期間開始年月日()));
        builder.append(get年月日(entity.get認定有効期間終了年月日()));
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
