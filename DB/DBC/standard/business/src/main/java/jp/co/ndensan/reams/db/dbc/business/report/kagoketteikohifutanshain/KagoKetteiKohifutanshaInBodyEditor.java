/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.kagoketteikohifutanshain;

import jp.co.ndensan.reams.db.dbc.entity.db.relate.kagoketteikohifutanshain.KagoKetteiKohifutanshaChohyoEntity;
import jp.co.ndensan.reams.db.dbc.entity.report.source.kagoketteikohifutanshain.KagoKetteiKohifutanshaInSource;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.ExpandedInformation;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.IDbColumnMappable;
import jp.co.ndensan.reams.uz.uza.util.editor.DecimalFormatter;

/**
 *
 * 誤決定通知書情報取込一覧表（公費負担者分）帳票BodyEditor
 *
 * @reamsid_L DBC-0980-510 surun
 */
public class KagoKetteiKohifutanshaInBodyEditor implements IKagoKetteiKohifutanshaInEditor {

    private final KagoKetteiKohifutanshaChohyoEntity 帳票出力対象データ;
    private final boolean 集計Flag;
    private static final Code DATA_3 = new Code("0003");
    private static final RString 被保険者番号 = new RString("被保険者番号");
    private final int index;

    /**
     * コンストラクタです
     *
     * @param 帳票出力対象データ KagoKetteiKohifutanshaChohyoEntity
     * @param 集計Flag boolean
     * @param index int
     */
    public KagoKetteiKohifutanshaInBodyEditor(KagoKetteiKohifutanshaChohyoEntity 帳票出力対象データ,
            boolean 集計Flag, int index) {
        this.帳票出力対象データ = 帳票出力対象データ;
        this.集計Flag = 集計Flag;
        this.index = index;
    }

    @Override
    public KagoKetteiKohifutanshaInSource edit(KagoKetteiKohifutanshaInSource source) {
        edit明細(source);
        if (集計Flag) {
            edit集計(source);
        }
        source.shikibetuCode = 帳票出力対象データ.get識別コード();
        return source;
    }

    private void edit明細(KagoKetteiKohifutanshaInSource source) {
        source.listUpper_1 = new RString(index);
        source.listUpper_2 = doパターン54(帳票出力対象データ.get取扱年月());
        source.listUpper_3 = getColumnValue(帳票出力対象データ.get事業者番号());
        source.listUpper_4 = 帳票出力対象データ.get公費受給者番号();
        source.listUpper_5 = 帳票出力対象データ.get公費受給者名();
        source.listUpper_6 = doパターン54(帳票出力対象データ.getサービ提供年月());
        source.listUpper_7 = getColumnValue(帳票出力対象データ.getサービス種類コード());
        source.listUpper_8 = 帳票出力対象データ.getサービス種類名();
        source.listUpper_9 = DecimalFormatter.toコンマ区切りRString(帳票出力対象データ.get単位数(), 0);
        source.listLower_1 = 帳票出力対象データ.get事業者名();
        source.listLower_2 = getColumnValue(帳票出力対象データ.get被保険者番号());
        source.拡張情報 = new ExpandedInformation(DATA_3, 被保険者番号, source.listLower_2);
        source.listLower_3 = getColumnValue(帳票出力対象データ.get過誤申立事由コード());
        source.listLower_4 = 帳票出力対象データ.get過誤申立事由();
        source.listLower_5 = DecimalFormatter.toコンマ区切りRString(帳票出力対象データ.get公費負担額(), 0);
    }

    private void edit集計(KagoKetteiKohifutanshaInSource source) {

        source.kaigoKyufuhiKensu
                = DecimalFormatter.toコンマ区切りRString(new Decimal(帳票出力対象データ.get介護給付費の件数()), 0);
        source.kaigoKyufuhiTanisu
                = DecimalFormatter.toコンマ区切りRString(帳票出力対象データ.get介護給付費の単位数(), 0);
        source.kaigoKyufuhiFutangaku
                = DecimalFormatter.toコンマ区切りRString(帳票出力対象データ.get介護給付費の負担額(), 0);
        source.kogakuServicehiKensu
                = DecimalFormatter.toコンマ区切りRString(new Decimal(帳票出力対象データ.get高額介護サービス費の件数()), 0);
        source.kogakuServicehiTanisu
                = DecimalFormatter.toコンマ区切りRString(帳票出力対象データ.get高額介護サービス費の単位数(), 0);
        source.kogakuServicehiFutangaku
                = DecimalFormatter.toコンマ区切りRString(帳票出力対象データ.get高額介護サービス費の負担額(), 0);
        source.tokuteiNyushoshaKaigohiKensu
                = DecimalFormatter.toコンマ区切りRString(new Decimal(帳票出力対象データ.get特定入所者介護費等の件数()), 0);
        source.tokuteiNyushoshaKaigohiTanisu
                = DecimalFormatter.toコンマ区切りRString(帳票出力対象データ.get特定入所者介護費等の単位数(), 0);
        source.tokuteiNyushoshaKaigohiFutangaku
                = DecimalFormatter.toコンマ区切りRString(帳票出力対象データ.get特定入所者介護費等の負担額(), 0);

    }

    private RString doパターン54(FlexibleYearMonth 年月) {
        if (null == 年月) {
            return RString.EMPTY;
        }
        return 年月.wareki().separator(Separator.PERIOD).fillType(FillType.BLANK).toDateString();
    }

    private RString getColumnValue(IDbColumnMappable column) {
        if (null == column) {
            return RString.EMPTY;
        }
        return column.getColumnValue();
    }
}
