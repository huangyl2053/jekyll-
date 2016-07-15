/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.ninteichosahoshushokai;

import jp.co.ndensan.reams.db.dbe.definition.batchprm.ninteichosahoshushokai.NinteiChosaHoshuShokaiProcessParameter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.ninteichosahoshushokai.NinteiChosaHoshuShokaiCsvEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.ninteichosahoshushokai.NinteiChosaHoshuShokaiCsvNoMiEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.ninteichosahoshushokai.NinteiChosaHoshuShokaiRelateEntity;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ChosaKubun;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ChosaJisshiBashoCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.NinteiChousaIraiKubunCode;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 認定調査報酬照会の帳票とcsvのパラメータを作成します。
 *
 * @reamsid_L DBE-1940-020 jinjue
 */
public final class NinteiChosaHoshuShokaiChange {

    private static final RString MARU = new RString("○");
    private static RString 調査_再 = new RString("初");
    private static RString ninteichosaItakusakiCode = RString.EMPTY;
    private static int 件数_値;
    private static final int 頁_件数 = 25;
    private static final int ONE = 1;
    private static final int ZERO = 0;

    private NinteiChosaHoshuShokaiChange() {
    }

    /**
     * 認定調査報酬照会の帳票のパラメータを作成します。
     *
     * @param entity 認定調査報酬照会情報
     * @param parameter 認定調査報酬照会のprocessのパラメータ
     * @param 番号 番号
     * @param 件数 件数
     * @return 認定調査報酬照会の帳票のパラメータ
     */
    public static NinteiChosaHoshuShokaiCsvEntity createShokaiData(NinteiChosaHoshuShokaiRelateEntity entity,
            NinteiChosaHoshuShokaiProcessParameter parameter, int 番号, int 件数) {

        RString 在宅_新 = RString.EMPTY;
        RString 在宅_継 = RString.EMPTY;
        RString 施設_新 = RString.EMPTY;
        RString 施設_継 = RString.EMPTY;
        if (!NinteiChousaIraiKubunCode.初回.getコード().equals(entity.get認定調査依頼区分コード().value())) {
            調査_再 = new RString("再");
        }
        if (ChosaKubun.新規調査.getコード().equals(entity.get認定調査区分コード().value())
                && ChosaJisshiBashoCode.自宅内.getコード().equals(entity.get認定調査実施場所コード().value())) {
            在宅_新 = MARU;
        }
        if (ChosaKubun.再調査.getコード().equals(entity.get認定調査区分コード().value())
                && ChosaJisshiBashoCode.自宅内.getコード().equals(entity.get認定調査実施場所コード().value())) {
            在宅_継 = MARU;
        }
        if (ChosaKubun.新規調査.getコード().equals(entity.get認定調査区分コード().value())
                && !ChosaJisshiBashoCode.自宅内.getコード().equals(entity.get認定調査実施場所コード().value())) {
            施設_新 = MARU;
        }
        if (ChosaKubun.再調査.getコード().equals(entity.get認定調査区分コード().value())
                && !ChosaJisshiBashoCode.自宅内.getコード().equals(entity.get認定調査実施場所コード().value())) {
            施設_継 = MARU;
        }
        NinteiChosaHoshuShokaiCsvEntity data = new NinteiChosaHoshuShokaiCsvEntity(entity.get認定調査委託先コード(), entity.get事業者名称(),
                entity.get認定調査員コード(), entity.get調査員氏名(), new RDate(entity.get認定調査依頼年月日().toString()),
                new RDate(entity.get認定調査実施年月日().toString()), new RDate(entity.get認定調査受領年月日().toString()),
                調査_再, entity.get証記載保険者番号(), entity.get被保険者番号(), entity.get被保険者氏名().getColumnValue(),
                在宅_新, 在宅_継, 施設_新, 施設_継, new RString(Integer.toString(entity.get認定調査委託料())), ZERO, ZERO,
                ZERO, ZERO, parameter.get調査依頼日開始().wareki().toDateString(),
                parameter.get調査依頼日終了().wareki().toDateString(), 番号, ZERO);
        件数_値 = entity.get件数();
        if (件数_値 - ONE <= 件数 && 番号 % 頁_件数 == ONE) {
            data.set施設_再合計(entity.get施設再調査());
            data.set在宅_初合計(entity.get在宅初回());
            data.set在宅_再合計(entity.get在宅再調査());
            data.set認定調査委託料(entity.get委託料合計());
            data.set施設_初合計(entity.get施設初回());
        }
        ninteichosaItakusakiCode = entity.get認定調査委託先コード();
        return data;
    }

    /**
     * 認定調査報酬照会のcsvのパラメータを作成します。
     *
     * @param entity 認定調査報酬照会情報
     * @return 認定調査報酬照会のcsvのパラメータ
     */
    public static NinteiChosaHoshuShokaiCsvNoMiEntity createData(NinteiChosaHoshuShokaiRelateEntity entity) {
        RString 在宅_新 = RString.EMPTY;
        RString 在宅_継 = RString.EMPTY;
        RString 施設_新 = RString.EMPTY;
        RString 施設_継 = RString.EMPTY;
        if (NinteiChousaIraiKubunCode.初回.getコード().equals(entity.get認定調査依頼区分コード().value())) {
            調査_再 = new RString("再");
        }
        if (ChosaKubun.新規調査.getコード().equals(entity.get認定調査区分コード().value())
                && ChosaJisshiBashoCode.自宅内.getコード().equals(entity.get認定調査実施場所コード().value())) {
            在宅_新 = MARU;
        }
        if (ChosaKubun.再調査.getコード().equals(entity.get認定調査区分コード().value())
                && ChosaJisshiBashoCode.自宅内.getコード().equals(entity.get認定調査実施場所コード().value())) {
            在宅_継 = MARU;
        }
        if (ChosaKubun.新規調査.getコード().equals(entity.get認定調査区分コード().value())
                && !ChosaJisshiBashoCode.自宅内.getコード().equals(entity.get認定調査実施場所コード().value())) {
            施設_新 = MARU;
        }
        if (ChosaKubun.再調査.getコード().equals(entity.get認定調査区分コード().value())
                && !ChosaJisshiBashoCode.自宅内.getコード().equals(entity.get認定調査実施場所コード().value())) {
            施設_継 = MARU;
        }
        Decimal 委託料 = new Decimal(entity.get認定調査委託料());
        NinteiChosaHoshuShokaiCsvNoMiEntity data = new NinteiChosaHoshuShokaiCsvNoMiEntity(entity.get認定調査委託先コード(), entity.get事業者名称(),
                entity.get認定調査員コード(), entity.get調査員氏名(), new RDate(entity.get認定調査依頼年月日().toString()),
                new RDate(entity.get認定調査実施年月日().toString()), new RDate(entity.get認定調査受領年月日().toString()),
                調査_再, entity.get証記載保険者番号(), entity.get被保険者番号(), entity.get被保険者氏名().getColumnValue(),
                在宅_新, 在宅_継, 施設_新, 施設_継, new RString(委託料.toString()));
        return data;
    }
}
