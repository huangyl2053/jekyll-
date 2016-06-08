/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.core.hihokensha;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dba.entity.db.relate.shikakuido.NayoseJuminJohoEntity;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.kojin.IKojin;
import jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.JuminJotai;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Separator;

/**
 * 広域内市町村間転出・転入のビジネスクラスです。
 *
 * @reamsid_L DBA-1300-020 dingyi
 */
public class JuminJohoCreator {

    private static final RString 半角コロン = new RString(":");
    private static final RString 半角空白 = new RString(" ");
    private static final RString 全角空白 = new RString("　");
    private static final RString ゼロ = new RString("0");
    private static final int 半角１５桁 = 15;
    private static final int 半角６桁 = 6;
    private static final int 半角８桁 = 8;
    private static final int 全角４桁 = 4;
    private static final int 文字列３ = 3;
    private static final int 文字列４ = 4;

    /**
     * 住民情報作成処理です。
     *
     * @param kojin 個人情報
     * @return 住民情報を表す文字列
     */
    public RString create住民情報(IKojin kojin) {
        requireNonNull(kojin, UrSystemErrorMessages.値がnull.getReplacedMessage("個人情報"));

        ShikibetsuCode 識別コード = kojin.get識別コード();
        LasdecCode 市町村コード = kojin.get現全国地方公共団体コード();
        JuminJotai 住民状態 = kojin.get住民状態();
        RString 生年月日;
        AtenaKanaMeisho カナ氏名;
        if (kojin.is日本人()) {
            生年月日 = kojin.get生年月日().toFlexibleDate().wareki()
                    .eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE).fillType(FillType.NONE).toDateString();
            カナ氏名 = kojin.get日本人氏名().getKana();
        } else {
            生年月日 = kojin.get生年月日().toFlexibleDate().seireki().separator(Separator.JAPANESE).fillType(FillType.ZERO).toDateString();
            カナ氏名 = kojin.get外国人氏名().get外国人氏名カナ();
        }
        return get住民情報Format(識別コード.getColumnValue(), 市町村コード.getColumnValue(),
                住民状態.住民状態略称(), 生年月日, カナ氏名.getColumnValue());
    }

    /**
     * 住民情報List作成処理です。
     *
     * @param kojinList 個人情報リスト
     * @return 住民情報を表す文字列リスト
     */
    public List<RString> create住民情報List(List<IKojin> kojinList) {
        requireNonNull(kojinList, UrSystemErrorMessages.値がnull.getReplacedMessage("個人情報リスト"));
        List<RString> 住民情報を表す文字列リスト = new ArrayList<>();
        for (IKojin 個人情報 : kojinList) {
            RString 住民情報を表す文字列 = create住民情報(個人情報);
            住民情報を表す文字列リスト.add(住民情報を表す文字列);
        }
        return 住民情報を表す文字列リスト;
    }

    /**
     * 住民情報文字列の変更処理です。
     *
     * @param kojinStr 住民情報を表す文字列
     * @return 名寄せ住民情報
     * @throws IllegalArgumentException 文字列の変換に失敗した場合、エラーを発生させる
     */
    public NayoseJuminJohoEntity encode住民情報文字列(RString kojinStr) throws IllegalArgumentException {
        requireNonNull(kojinStr, UrSystemErrorMessages.値がnull.getReplacedMessage("住民情報文字列"));
        NayoseJuminJohoEntity 名寄せ住民情報 = new NayoseJuminJohoEntity();
        List<RString> 文字列 = kojinStr.trim().split(半角コロン.toString());
        RString 識別コード = 文字列.get(0).trim();
        RString 市町村コード = 文字列.get(1).trim();
        RString 住民状態 = 文字列.get(2).trim();
        RString 生年月日 = 文字列.get(文字列３).trim();
        RString カナ氏名 = 文字列.get(文字列４).trim();
        名寄せ住民情報.setShikibetsuCode(RString.isNullOrEmpty(識別コード) ? ShikibetsuCode.EMPTY : new ShikibetsuCode(識別コード));
        名寄せ住民情報.setLasdecCode(RString.isNullOrEmpty(市町村コード) ? LasdecCode.EMPTY : new LasdecCode(市町村コード));
        名寄せ住民情報.setJuminJotai(RString.isNullOrEmpty(住民状態) ? JuminJotai.未定義 : JuminJotai.valueOf(住民状態.toString()));
        名寄せ住民情報.setSeinengappi(RString.isNullOrEmpty(生年月日) ? FlexibleDate.EMPTY : new FlexibleDate(生年月日));
        名寄せ住民情報.setKanaMeisho(RString.isNullOrEmpty(カナ氏名) ? AtenaKanaMeisho.EMPTY : new AtenaKanaMeisho(カナ氏名));

        return 名寄せ住民情報;
    }

    private RString get住民情報Format(RString 識別コード, RString 市町村コード, RString 住民状態略称, RString 生年月日, RString カナ氏名) {
        if (RString.isNullOrEmpty(識別コード)) {
            識別コード = 半角空白.padRight(半角空白, 半角１５桁);
        } else {
            識別コード = 識別コード.trim().padRight(ゼロ, 半角１５桁);
        }
        if (RString.isNullOrEmpty(市町村コード)) {
            市町村コード = 半角空白.padRight(半角空白, 半角６桁);
        } else {
            市町村コード = 市町村コード.padRight(ゼロ, 半角６桁);
        }
        if (RString.isNullOrEmpty(住民状態略称)) {
            住民状態略称 = 全角空白.padRight(全角空白, 全角４桁);
        } else {
            住民状態略称 = 住民状態略称.trim().padRight(全角空白, 全角４桁);
        }
        if (RString.isNullOrEmpty(生年月日)) {
            生年月日 = 全角空白.concat(半角空白.padRight(半角空白, 半角８桁));
        }
        return 識別コード.concat(半角コロン).concat(市町村コード).concat(半角コロン).concat(住民状態略称).concat(半角コロン).concat(生年月日)
                .concat(半角コロン).concat(カナ氏名);
    }

}
