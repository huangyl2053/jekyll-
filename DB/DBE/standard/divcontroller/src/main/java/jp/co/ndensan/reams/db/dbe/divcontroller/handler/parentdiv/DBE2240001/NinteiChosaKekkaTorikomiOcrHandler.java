/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE2240001;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.core.gaikyochosahyouservicejyouk.GaikyoChosahyouServiceJyouk02A;
import jp.co.ndensan.reams.db.dbe.definition.core.gaikyochosahyouservicejyouk.GaikyoChosahyouServiceJyouk06A;
import jp.co.ndensan.reams.db.dbe.definition.core.gaikyochosahyouservicejyouk.GaikyoChosahyouServiceJyouk09A;
import jp.co.ndensan.reams.db.dbe.definition.core.gaikyochosahyouservicejyouk.GaikyoChosahyouServiceJyouk09B;
import jp.co.ndensan.reams.db.dbe.definition.core.gaikyochosahyouservicejyouk.GaikyoChosahyouServiceJyouk99A;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2240001.NinteiChosaKekkaTorikomiOcrDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2240001.NinteiTorokuData;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2240001.dgTorikomiKekka_Row;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBE;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.business.core.basic.NinteichosahyoServiceJokyo;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.KoroshoIfShikibetsuCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.NinteiShinseiShinseijiKubunCode;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.io.Encode;
import jp.co.ndensan.reams.uz.uza.io.NewLine;
import jp.co.ndensan.reams.uz.uza.io.Path;
import jp.co.ndensan.reams.uz.uza.io.csv.CsvListReader;
import jp.co.ndensan.reams.uz.uza.io.csv.CsvReader;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 認定調査結果取込み（OCR）のコントローラクラスです。
 *
 * @reamsid_L DBE-1540-010 dongyabin
 */
public class NinteiChosaKekkaTorikomiOcrHandler {

    private static final RString 空白 = RString.EMPTY;
    private static final RString CSV_WRITER_DELIMITER = new RString(",");
    private static final RString チェックNG = new RString("NG");
    private static final RString ファイル名 = new RString("OCRCHOSA.CSV");
    private final NinteiChosaKekkaTorikomiOcrDiv div;
    private List<RString> サービスの状況_99A;
    private List<RString> サービスの状況_02A;
    private List<RString> サービスの状況_06A;
    private List<RString> サービスの状況_09A;
    private List<RString> サービスの状況_09B;

    /**
     * コンストラクタです。
     *
     * @param div 画面情報
     */
    public NinteiChosaKekkaTorikomiOcrHandler(NinteiChosaKekkaTorikomiOcrDiv div) {
        this.div = div;
    }

    /**
     * 「調査票OCRを取込」ボタンを押します。
     *
     * @return List<NinteiTorokuData>
     */
    public List<NinteiTorokuData> onClick_BtnChosahyoTorikomi() {
        return getCSVファイル();
    }

    /**
     * 画面一覧を設定します。
     *
     * @param dB更新用 dB更新用
     */
    public void set画面一覧(List<NinteiTorokuData> dB更新用) {
        int 連番 = 0;
        int エラー件数 = 0;
        List<dgTorikomiKekka_Row> rowList = new ArrayList<>();
        for (NinteiTorokuData data : dB更新用) {
            連番++;
            dgTorikomiKekka_Row row = new dgTorikomiKekka_Row(new RString(連番),
                    data.getOK_NG(),
                    data.get保険者(),
                    data.get被保険者番号(),
                    dateFormat(data.get申請日()),
                    NinteiShinseiShinseijiKubunCode.toValue(data.get申請区分()).get名称(),
                    dateFormat(data.get実施日時()),
                    FlexibleDate.getNowDate().wareki().toDateString(),
                    data.get証記載保険者番号());
            rowList.add(row);
            if (チェックNG.equals(data.getOK_NG())) {
                エラー件数++;
            }
        }
        div.getTxtError().setValue(new Decimal(エラー件数));
        div.getDgTorikomiKekka().setDataSource(rowList);
    }

    /**
     * (認定調査票（概況調査）サービスの状況を更新します。
     *
     * @param サービスの状況List サービスの状況List
     * @param data csvと画面データ
     * @return サービスの状況List
     */
    public List<NinteichosahyoServiceJokyo> updateDbT5207(List<NinteichosahyoServiceJokyo> サービスの状況List, NinteiTorokuData data) {
        if (KoroshoIfShikibetsuCode.認定ｿﾌﾄ99.getコード().equals(data.get厚労省IF識別コード())) {
            サービスの状況_99A = new ArrayList<>();
            サービスの状況List = setDbT5207_99A(サービスの状況List, data);
            サービスの状況List = set新規サービスの状況_99A(サービスの状況List, data);
        }
        if (KoroshoIfShikibetsuCode.認定ｿﾌﾄ2002.getコード().equals(data.get厚労省IF識別コード())) {
            サービスの状況_02A = new ArrayList<>();
            サービスの状況List = setDbT5207_02A(サービスの状況List, data);
            サービスの状況List = set新規サービスの状況_02A(サービスの状況List, data);
        }
        if (KoroshoIfShikibetsuCode.認定ｿﾌﾄ2006_新要介護認定適用区分が未適用.getコード().equals(data.get厚労省IF識別コード())) {
            サービスの状況_06A = new ArrayList<>();
            サービスの状況List = setDbT5207_06A(サービスの状況List, data);
            サービスの状況List = set新規サービスの状況_06A(サービスの状況List, data);
        }
        if (KoroshoIfShikibetsuCode.認定ｿﾌﾄ2009.getコード().equals(data.get厚労省IF識別コード())) {
            サービスの状況_09A = new ArrayList<>();
            サービスの状況List = setDbT5207_09A(サービスの状況List, data);
            サービスの状況List = set新規サービスの状況_09A(サービスの状況List, data);
        }
        if (KoroshoIfShikibetsuCode.認定ｿﾌﾄ2009_SP3.getコード().equals(data.get厚労省IF識別コード())) {
            サービスの状況_09B = new ArrayList<>();
            サービスの状況List = setDbT5207_09B(サービスの状況List, data);
            サービスの状況List = set新規サービスの状況_09B(サービスの状況List, data);
        }
        return サービスの状況List;
    }

    private List<NinteichosahyoServiceJokyo> setDbT5207_99A(List<NinteichosahyoServiceJokyo> サービスの状況List, NinteiTorokuData data) {
        for (int i = 0; i < サービスの状況List.size(); i++) {
            NinteichosahyoServiceJokyo joho = サービスの状況List.get(i);
            if (GaikyoChosahyouServiceJyouk99A.訪問介護.get連番().equals(new RString(joho.get連番()))) {
                joho = joho.createBuilderForEdit().setサービスの状況(getサービスの状況を変換(data.get訪問介護_ﾎｰﾑﾍﾙﾌﾟｻｰﾋﾞｽの回数())).build();
                サービスの状況_99A.add(GaikyoChosahyouServiceJyouk99A.訪問介護.get連番());
                サービスの状況List.set(i, joho.modifiedModel());
            }
            if (GaikyoChosahyouServiceJyouk99A.訪問入浴介護.get連番().equals(new RString(joho.get連番()))) {
                joho = joho.createBuilderForEdit().setサービスの状況(getサービスの状況を変換(data.get訪問入浴介護の回数())).build();
                サービスの状況_99A.add(GaikyoChosahyouServiceJyouk99A.訪問入浴介護.get連番());
                サービスの状況List.set(i, joho.modifiedModel());
            }
            if (GaikyoChosahyouServiceJyouk99A.訪問看護.get連番().equals(new RString(joho.get連番()))) {
                joho = joho.createBuilderForEdit().setサービスの状況(getサービスの状況を変換(data.get訪問看護の回数())).build();
                サービスの状況_99A.add(GaikyoChosahyouServiceJyouk99A.訪問看護.get連番());
                サービスの状況List.set(i, joho.modifiedModel());
            }
            if (GaikyoChosahyouServiceJyouk99A.訪問リハビリ.get連番().equals(new RString(joho.get連番()))) {
                joho = joho.createBuilderForEdit().setサービスの状況(getサービスの状況を変換(data.get訪問ﾘﾊﾋﾞﾘﾃｰｼｮﾝの回数())).build();
                サービスの状況_99A.add(GaikyoChosahyouServiceJyouk99A.訪問リハビリ.get連番());
                サービスの状況List.set(i, joho.modifiedModel());
            }
            if (GaikyoChosahyouServiceJyouk99A.居宅療養管理指導.get連番().equals(new RString(joho.get連番()))) {
                joho = joho.createBuilderForEdit().setサービスの状況(getサービスの状況を変換(data.get居宅療養管理指導の回数())).build();
                サービスの状況_99A.add(GaikyoChosahyouServiceJyouk99A.居宅療養管理指導.get連番());
                サービスの状況List.set(i, joho.modifiedModel());
            }
            if (GaikyoChosahyouServiceJyouk99A.通所介護.get連番().equals(new RString(joho.get連番()))) {
                joho = joho.createBuilderForEdit().setサービスの状況(getサービスの状況を変換(data.get通所看護_ﾃﾞｲｻｰﾋﾞｽの回数())).build();
                サービスの状況_99A.add(GaikyoChosahyouServiceJyouk99A.通所介護.get連番());
                サービスの状況List.set(i, joho.modifiedModel());
            }
            if (GaikyoChosahyouServiceJyouk99A.通所リハビリ.get連番().equals(new RString(joho.get連番()))) {
                joho = joho.createBuilderForEdit().setサービスの状況(getサービスの状況を変換(data.get通所ﾘﾊﾋﾞﾘﾃｰｼｮﾝの回数())).build();
                サービスの状況_99A.add(GaikyoChosahyouServiceJyouk99A.通所リハビリ.get連番());
                サービスの状況List.set(i, joho.modifiedModel());
            }
            if (GaikyoChosahyouServiceJyouk99A.福祉用具貸与.get連番().equals(new RString(joho.get連番()))) {
                joho = joho.createBuilderForEdit().setサービスの状況(getサービスの状況を変換(data.get福祉用具貸与の品目())).build();
                サービスの状況_99A.add(GaikyoChosahyouServiceJyouk99A.福祉用具貸与.get連番());
                サービスの状況List.set(i, joho.modifiedModel());
            }
            if (GaikyoChosahyouServiceJyouk99A.短期入所生活介護.get連番().equals(new RString(joho.get連番()))) {
                joho = joho.createBuilderForEdit().setサービスの状況(getサービスの状況を変換(data.get短期入所生活介護の日数())).build();
                サービスの状況_99A.add(GaikyoChosahyouServiceJyouk99A.短期入所生活介護.get連番());
                サービスの状況List.set(i, joho.modifiedModel());
            }
            if (GaikyoChosahyouServiceJyouk99A.短期入所療養介護.get連番().equals(new RString(joho.get連番()))) {
                joho = joho.createBuilderForEdit().setサービスの状況(getサービスの状況を変換(data.get短期入所療養介護の日数())).build();
                サービスの状況_99A.add(GaikyoChosahyouServiceJyouk99A.短期入所療養介護.get連番());
                サービスの状況List.set(i, joho.modifiedModel());
            }
            if (GaikyoChosahyouServiceJyouk99A.認知症対応型共同生活介護.get連番().equals(new RString(joho.get連番()))) {
                joho = joho.createBuilderForEdit().setサービスの状況(getサービスの状況を変換(data.get認知症対応型共同生活介護の日数())).build();
                サービスの状況_99A.add(GaikyoChosahyouServiceJyouk99A.認知症対応型共同生活介護.get連番());
                サービスの状況List.set(i, joho.modifiedModel());
            }
            if (GaikyoChosahyouServiceJyouk99A.特定施設入所者生活介護.get連番().equals(new RString(joho.get連番()))) {
                joho = joho.createBuilderForEdit().setサービスの状況(getサービスの状況を変換(data.get特定施設入所者生活介護の日数())).build();
                サービスの状況_99A.add(GaikyoChosahyouServiceJyouk99A.特定施設入所者生活介護.get連番());
                サービスの状況List.set(i, joho.modifiedModel());
            }
            if (GaikyoChosahyouServiceJyouk99A.福祉用具購入.get連番().equals(new RString(joho.get連番()))) {
                joho = joho.createBuilderForEdit().setサービスの状況(getサービスの状況を変換(data.get福祉用具購入の品目())).build();
                サービスの状況_99A.add(GaikyoChosahyouServiceJyouk99A.福祉用具購入.get連番());
                サービスの状況List.set(i, joho.modifiedModel());
            }
        }
        return サービスの状況List;
    }

    private List<NinteichosahyoServiceJokyo> set新規サービスの状況_99A(List<NinteichosahyoServiceJokyo> サービスの状況List, NinteiTorokuData data) {
        if (!サービスの状況_99A.contains(GaikyoChosahyouServiceJyouk99A.訪問介護.get連番())) {
            NinteichosahyoServiceJokyo joho = new NinteichosahyoServiceJokyo(new ShinseishoKanriNo(
                    data.get申請書管理番号()), data.get認定調査依頼履歴番号(),
                    getサービスの状況を変換(GaikyoChosahyouServiceJyouk99A.訪問介護.get連番()));
            joho = joho.createBuilderForEdit().setサービスの状況(getサービスの状況を変換(data.get訪問介護_ﾎｰﾑﾍﾙﾌﾟｻｰﾋﾞｽの回数())).build();
            joho = joho.createBuilderForEdit().set厚労省IF識別コード(new Code(data.get厚労省IF識別コード())).build();
            サービスの状況List.add(joho);
        }
        if (!サービスの状況_99A.contains(GaikyoChosahyouServiceJyouk99A.訪問入浴介護.get連番())) {
            NinteichosahyoServiceJokyo joho = new NinteichosahyoServiceJokyo(new ShinseishoKanriNo(
                    data.get申請書管理番号()), data.get認定調査依頼履歴番号(),
                    getサービスの状況を変換(GaikyoChosahyouServiceJyouk99A.訪問入浴介護.get連番()));
            joho = joho.createBuilderForEdit().setサービスの状況(getサービスの状況を変換(data.get訪問入浴介護の回数())).build();
            joho = joho.createBuilderForEdit().set厚労省IF識別コード(new Code(data.get厚労省IF識別コード())).build();
            サービスの状況List.add(joho);
        }
        if (!サービスの状況_99A.contains(GaikyoChosahyouServiceJyouk99A.訪問看護.get連番())) {
            NinteichosahyoServiceJokyo joho = new NinteichosahyoServiceJokyo(new ShinseishoKanriNo(
                    data.get申請書管理番号()), data.get認定調査依頼履歴番号(),
                    getサービスの状況を変換(GaikyoChosahyouServiceJyouk99A.訪問看護.get連番()));
            joho = joho.createBuilderForEdit().setサービスの状況(getサービスの状況を変換(data.get訪問介護_ﾎｰﾑﾍﾙﾌﾟｻｰﾋﾞｽの回数())).build();
            joho = joho.createBuilderForEdit().set厚労省IF識別コード(new Code(data.get厚労省IF識別コード())).build();
            サービスの状況List.add(joho);
        }
        if (!サービスの状況_99A.contains(GaikyoChosahyouServiceJyouk99A.訪問リハビリ.get連番())) {
            NinteichosahyoServiceJokyo joho = new NinteichosahyoServiceJokyo(new ShinseishoKanriNo(
                    data.get申請書管理番号()), data.get認定調査依頼履歴番号(),
                    getサービスの状況を変換(GaikyoChosahyouServiceJyouk99A.訪問リハビリ.get連番()));
            joho = joho.createBuilderForEdit().setサービスの状況(getサービスの状況を変換(data.get訪問ﾘﾊﾋﾞﾘﾃｰｼｮﾝの回数())).build();
            joho = joho.createBuilderForEdit().set厚労省IF識別コード(new Code(data.get厚労省IF識別コード())).build();
            サービスの状況List.add(joho);
        }
        if (!サービスの状況_99A.contains(GaikyoChosahyouServiceJyouk99A.居宅療養管理指導.get連番())) {
            NinteichosahyoServiceJokyo joho = new NinteichosahyoServiceJokyo(new ShinseishoKanriNo(
                    data.get申請書管理番号()), data.get認定調査依頼履歴番号(),
                    getサービスの状況を変換(GaikyoChosahyouServiceJyouk99A.居宅療養管理指導.get連番()));
            joho = joho.createBuilderForEdit().setサービスの状況(getサービスの状況を変換(data.get居宅療養管理指導の回数())).build();
            joho = joho.createBuilderForEdit().set厚労省IF識別コード(new Code(data.get厚労省IF識別コード())).build();
            サービスの状況List.add(joho);
        }
        if (!サービスの状況_99A.contains(GaikyoChosahyouServiceJyouk99A.通所介護.get連番())) {
            NinteichosahyoServiceJokyo joho = new NinteichosahyoServiceJokyo(new ShinseishoKanriNo(
                    data.get申請書管理番号()), data.get認定調査依頼履歴番号(),
                    getサービスの状況を変換(GaikyoChosahyouServiceJyouk99A.通所介護.get連番()));
            joho = joho.createBuilderForEdit().setサービスの状況(getサービスの状況を変換(data.get通所看護_ﾃﾞｲｻｰﾋﾞｽの回数())).build();
            joho = joho.createBuilderForEdit().set厚労省IF識別コード(new Code(data.get厚労省IF識別コード())).build();
            サービスの状況List.add(joho);
        }
        if (!サービスの状況_99A.contains(GaikyoChosahyouServiceJyouk99A.通所リハビリ.get連番())) {
            NinteichosahyoServiceJokyo joho = new NinteichosahyoServiceJokyo(new ShinseishoKanriNo(
                    data.get申請書管理番号()), data.get認定調査依頼履歴番号(),
                    getサービスの状況を変換(GaikyoChosahyouServiceJyouk99A.通所リハビリ.get連番()));
            joho = joho.createBuilderForEdit().setサービスの状況(getサービスの状況を変換(data.get通所ﾘﾊﾋﾞﾘﾃｰｼｮﾝの回数())).build();
            joho = joho.createBuilderForEdit().set厚労省IF識別コード(new Code(data.get厚労省IF識別コード())).build();
            サービスの状況List.add(joho);
        }
        if (!サービスの状況_99A.contains(GaikyoChosahyouServiceJyouk99A.福祉用具貸与.get連番())) {
            NinteichosahyoServiceJokyo joho = new NinteichosahyoServiceJokyo(new ShinseishoKanriNo(
                    data.get申請書管理番号()), data.get認定調査依頼履歴番号(),
                    getサービスの状況を変換(GaikyoChosahyouServiceJyouk99A.福祉用具貸与.get連番()));
            joho = joho.createBuilderForEdit().setサービスの状況(getサービスの状況を変換(data.get福祉用具貸与の品目())).build();
            joho = joho.createBuilderForEdit().set厚労省IF識別コード(new Code(data.get厚労省IF識別コード())).build();
            サービスの状況List.add(joho);
        }
        if (!サービスの状況_99A.contains(GaikyoChosahyouServiceJyouk99A.短期入所生活介護.get連番())) {
            NinteichosahyoServiceJokyo joho = new NinteichosahyoServiceJokyo(new ShinseishoKanriNo(
                    data.get申請書管理番号()), data.get認定調査依頼履歴番号(),
                    getサービスの状況を変換(GaikyoChosahyouServiceJyouk99A.短期入所生活介護.get連番()));
            joho = joho.createBuilderForEdit().setサービスの状況(getサービスの状況を変換(data.get短期入所生活介護の日数())).build();
            joho = joho.createBuilderForEdit().set厚労省IF識別コード(new Code(data.get厚労省IF識別コード())).build();
            サービスの状況List.add(joho);
        }
        if (!サービスの状況_99A.contains(GaikyoChosahyouServiceJyouk99A.短期入所療養介護.get連番())) {
            NinteichosahyoServiceJokyo joho = new NinteichosahyoServiceJokyo(new ShinseishoKanriNo(
                    data.get申請書管理番号()), data.get認定調査依頼履歴番号(),
                    getサービスの状況を変換(GaikyoChosahyouServiceJyouk99A.短期入所療養介護.get連番()));
            joho = joho.createBuilderForEdit().setサービスの状況(getサービスの状況を変換(data.get短期入所療養介護の日数())).build();
            joho = joho.createBuilderForEdit().set厚労省IF識別コード(new Code(data.get厚労省IF識別コード())).build();
            サービスの状況List.add(joho);
        }
        if (!サービスの状況_99A.contains(GaikyoChosahyouServiceJyouk99A.認知症対応型共同生活介護.get連番())) {
            NinteichosahyoServiceJokyo joho = new NinteichosahyoServiceJokyo(new ShinseishoKanriNo(
                    data.get申請書管理番号()), data.get認定調査依頼履歴番号(),
                    getサービスの状況を変換(GaikyoChosahyouServiceJyouk99A.認知症対応型共同生活介護.get連番()));
            joho = joho.createBuilderForEdit().setサービスの状況(getサービスの状況を変換(data.get認知症対応型共同生活介護の日数())).build();
            joho = joho.createBuilderForEdit().set厚労省IF識別コード(new Code(data.get厚労省IF識別コード())).build();
            サービスの状況List.add(joho);
        }
        if (!サービスの状況_99A.contains(GaikyoChosahyouServiceJyouk99A.特定施設入所者生活介護.get連番())) {
            NinteichosahyoServiceJokyo joho = new NinteichosahyoServiceJokyo(new ShinseishoKanriNo(
                    data.get申請書管理番号()), data.get認定調査依頼履歴番号(),
                    getサービスの状況を変換(GaikyoChosahyouServiceJyouk99A.特定施設入所者生活介護.get連番()));
            joho = joho.createBuilderForEdit().setサービスの状況(getサービスの状況を変換(data.get特定施設入所者生活介護の日数())).build();
            joho = joho.createBuilderForEdit().set厚労省IF識別コード(new Code(data.get厚労省IF識別コード())).build();
            サービスの状況List.add(joho);
        }
        if (!サービスの状況_99A.contains(GaikyoChosahyouServiceJyouk99A.福祉用具購入.get連番())) {
            NinteichosahyoServiceJokyo joho = new NinteichosahyoServiceJokyo(new ShinseishoKanriNo(
                    data.get申請書管理番号()), data.get認定調査依頼履歴番号(),
                    getサービスの状況を変換(GaikyoChosahyouServiceJyouk99A.福祉用具購入.get連番()));
            joho = joho.createBuilderForEdit().setサービスの状況(getサービスの状況を変換(data.get福祉用具購入の品目())).build();
            joho = joho.createBuilderForEdit().set厚労省IF識別コード(new Code(data.get厚労省IF識別コード())).build();
            サービスの状況List.add(joho);
        }
        return サービスの状況List;
    }

    private List<NinteichosahyoServiceJokyo> setDbT5207_02A(List<NinteichosahyoServiceJokyo> サービスの状況List, NinteiTorokuData data) {
        for (int i = 0; i < サービスの状況List.size(); i++) {
            NinteichosahyoServiceJokyo joho = サービスの状況List.get(i);
            if (GaikyoChosahyouServiceJyouk02A.訪問介護.get連番().equals(new RString(joho.get連番()))) {
                joho = joho.createBuilderForEdit().setサービスの状況(getサービスの状況を変換(data.get訪問介護_ﾎｰﾑﾍﾙﾌﾟｻｰﾋﾞｽの回数())).build();
                サービスの状況_02A.add(GaikyoChosahyouServiceJyouk02A.訪問介護.get連番());
                サービスの状況List.set(i, joho.modifiedModel());
            }
            if (GaikyoChosahyouServiceJyouk02A.訪問入浴介護.get連番().equals(new RString(joho.get連番()))) {
                joho = joho.createBuilderForEdit().setサービスの状況(getサービスの状況を変換(data.get訪問入浴介護の回数())).build();
                サービスの状況_02A.add(GaikyoChosahyouServiceJyouk02A.訪問入浴介護.get連番());
                サービスの状況List.set(i, joho.modifiedModel());
            }
            if (GaikyoChosahyouServiceJyouk02A.訪問看護.get連番().equals(new RString(joho.get連番()))) {
                joho = joho.createBuilderForEdit().setサービスの状況(getサービスの状況を変換(data.get訪問看護の回数())).build();
                サービスの状況_02A.add(GaikyoChosahyouServiceJyouk02A.訪問看護.get連番());
                サービスの状況List.set(i, joho.modifiedModel());
            }
            if (GaikyoChosahyouServiceJyouk02A.訪問リハビリ.get連番().equals(new RString(joho.get連番()))) {
                joho = joho.createBuilderForEdit().setサービスの状況(getサービスの状況を変換(data.get訪問ﾘﾊﾋﾞﾘﾃｰｼｮﾝの回数())).build();
                サービスの状況_02A.add(GaikyoChosahyouServiceJyouk02A.訪問リハビリ.get連番());
                サービスの状況List.set(i, joho.modifiedModel());
            }
            if (GaikyoChosahyouServiceJyouk02A.居宅療養管理指導.get連番().equals(new RString(joho.get連番()))) {
                joho = joho.createBuilderForEdit().setサービスの状況(getサービスの状況を変換(data.get居宅療養管理指導の回数())).build();
                サービスの状況_02A.add(GaikyoChosahyouServiceJyouk02A.居宅療養管理指導.get連番());
                サービスの状況List.set(i, joho.modifiedModel());
            }
            if (GaikyoChosahyouServiceJyouk02A.通所介護.get連番().equals(new RString(joho.get連番()))) {
                joho = joho.createBuilderForEdit().setサービスの状況(getサービスの状況を変換(data.get通所看護_ﾃﾞｲｻｰﾋﾞｽの回数())).build();
                サービスの状況_02A.add(GaikyoChosahyouServiceJyouk02A.通所介護.get連番());
                サービスの状況List.set(i, joho.modifiedModel());
            }
            if (GaikyoChosahyouServiceJyouk02A.通所リハビリ.get連番().equals(new RString(joho.get連番()))) {
                joho = joho.createBuilderForEdit().setサービスの状況(getサービスの状況を変換(data.get通所ﾘﾊﾋﾞﾘﾃｰｼｮﾝの回数())).build();
                サービスの状況_02A.add(GaikyoChosahyouServiceJyouk02A.通所リハビリ.get連番());
                サービスの状況List.set(i, joho.modifiedModel());
            }
            if (GaikyoChosahyouServiceJyouk02A.福祉用具貸与.get連番().equals(new RString(joho.get連番()))) {
                joho = joho.createBuilderForEdit().setサービスの状況(getサービスの状況を変換(data.get福祉用具貸与の品目())).build();
                サービスの状況_02A.add(GaikyoChosahyouServiceJyouk02A.福祉用具貸与.get連番());
                サービスの状況List.set(i, joho.modifiedModel());
            }
            if (GaikyoChosahyouServiceJyouk02A.短期入所生活介護.get連番().equals(new RString(joho.get連番()))) {
                joho = joho.createBuilderForEdit().setサービスの状況(getサービスの状況を変換(data.get短期入所生活介護の日数())).build();
                サービスの状況_02A.add(GaikyoChosahyouServiceJyouk02A.短期入所生活介護.get連番());
                サービスの状況List.set(i, joho.modifiedModel());
            }
            if (GaikyoChosahyouServiceJyouk02A.短期入所療養介護.get連番().equals(new RString(joho.get連番()))) {
                joho = joho.createBuilderForEdit().setサービスの状況(getサービスの状況を変換(data.get短期入所療養介護の日数())).build();
                サービスの状況_02A.add(GaikyoChosahyouServiceJyouk02A.短期入所療養介護.get連番());
                サービスの状況List.set(i, joho.modifiedModel());
            }
            if (GaikyoChosahyouServiceJyouk02A.認知症対応型共同生活介護.get連番().equals(new RString(joho.get連番()))) {
                joho = joho.createBuilderForEdit().setサービスの状況(getサービスの状況を変換(data.get認知症対応型共同生活介護の日数())).build();
                サービスの状況_02A.add(GaikyoChosahyouServiceJyouk02A.認知症対応型共同生活介護.get連番());
                サービスの状況List.set(i, joho.modifiedModel());
            }
            if (GaikyoChosahyouServiceJyouk02A.特定施設入所者生活介護.get連番().equals(new RString(joho.get連番()))) {
                joho = joho.createBuilderForEdit().setサービスの状況(getサービスの状況を変換(data.get特定施設入所者生活介護の日数())).build();
                サービスの状況_02A.add(GaikyoChosahyouServiceJyouk02A.特定施設入所者生活介護.get連番());
                サービスの状況List.set(i, joho.modifiedModel());
            }
            if (GaikyoChosahyouServiceJyouk02A.福祉用具購入.get連番().equals(new RString(joho.get連番()))) {
                joho = joho.createBuilderForEdit().setサービスの状況(getサービスの状況を変換(data.get福祉用具購入の品目())).build();
                サービスの状況_02A.add(GaikyoChosahyouServiceJyouk02A.福祉用具購入.get連番());
                サービスの状況List.set(i, joho.modifiedModel());
            }
        }
        return サービスの状況List;
    }

    private List<NinteichosahyoServiceJokyo> set新規サービスの状況_02A(List<NinteichosahyoServiceJokyo> サービスの状況List, NinteiTorokuData data) {
        if (!サービスの状況_02A.contains(GaikyoChosahyouServiceJyouk02A.訪問介護.get連番())) {
            NinteichosahyoServiceJokyo joho = new NinteichosahyoServiceJokyo(new ShinseishoKanriNo(
                    data.get申請書管理番号()), data.get認定調査依頼履歴番号(),
                    getサービスの状況を変換(GaikyoChosahyouServiceJyouk02A.訪問介護.get連番()));
            joho = joho.createBuilderForEdit().setサービスの状況(getサービスの状況を変換(data.get訪問介護_ﾎｰﾑﾍﾙﾌﾟｻｰﾋﾞｽの回数())).build();
            joho = joho.createBuilderForEdit().set厚労省IF識別コード(new Code(data.get厚労省IF識別コード())).build();
            サービスの状況List.add(joho);
        }
        if (!サービスの状況_02A.contains(GaikyoChosahyouServiceJyouk02A.訪問入浴介護.get連番())) {
            NinteichosahyoServiceJokyo joho = new NinteichosahyoServiceJokyo(new ShinseishoKanriNo(
                    data.get申請書管理番号()), data.get認定調査依頼履歴番号(),
                    getサービスの状況を変換(GaikyoChosahyouServiceJyouk02A.訪問入浴介護.get連番()));
            joho = joho.createBuilderForEdit().setサービスの状況(getサービスの状況を変換(data.get訪問入浴介護の回数())).build();
            joho = joho.createBuilderForEdit().set厚労省IF識別コード(new Code(data.get厚労省IF識別コード())).build();
            サービスの状況List.add(joho);
        }
        if (!サービスの状況_02A.contains(GaikyoChosahyouServiceJyouk02A.訪問看護.get連番())) {
            NinteichosahyoServiceJokyo joho = new NinteichosahyoServiceJokyo(new ShinseishoKanriNo(
                    data.get申請書管理番号()), data.get認定調査依頼履歴番号(),
                    getサービスの状況を変換(GaikyoChosahyouServiceJyouk02A.訪問看護.get連番()));
            joho = joho.createBuilderForEdit().setサービスの状況(getサービスの状況を変換(data.get訪問介護_ﾎｰﾑﾍﾙﾌﾟｻｰﾋﾞｽの回数())).build();
            joho = joho.createBuilderForEdit().set厚労省IF識別コード(new Code(data.get厚労省IF識別コード())).build();
            サービスの状況List.add(joho);
        }
        if (!サービスの状況_02A.contains(GaikyoChosahyouServiceJyouk02A.訪問リハビリ.get連番())) {
            NinteichosahyoServiceJokyo joho = new NinteichosahyoServiceJokyo(new ShinseishoKanriNo(
                    data.get申請書管理番号()), data.get認定調査依頼履歴番号(),
                    getサービスの状況を変換(GaikyoChosahyouServiceJyouk02A.訪問リハビリ.get連番()));
            joho = joho.createBuilderForEdit().setサービスの状況(getサービスの状況を変換(data.get訪問ﾘﾊﾋﾞﾘﾃｰｼｮﾝの回数())).build();
            joho = joho.createBuilderForEdit().set厚労省IF識別コード(new Code(data.get厚労省IF識別コード())).build();
            サービスの状況List.add(joho);
        }
        if (!サービスの状況_02A.contains(GaikyoChosahyouServiceJyouk02A.居宅療養管理指導.get連番())) {
            NinteichosahyoServiceJokyo joho = new NinteichosahyoServiceJokyo(new ShinseishoKanriNo(
                    data.get申請書管理番号()), data.get認定調査依頼履歴番号(),
                    getサービスの状況を変換(GaikyoChosahyouServiceJyouk02A.居宅療養管理指導.get連番()));
            joho = joho.createBuilderForEdit().setサービスの状況(getサービスの状況を変換(data.get居宅療養管理指導の回数())).build();
            joho = joho.createBuilderForEdit().set厚労省IF識別コード(new Code(data.get厚労省IF識別コード())).build();
            サービスの状況List.add(joho);
        }
        if (!サービスの状況_02A.contains(GaikyoChosahyouServiceJyouk02A.通所介護.get連番())) {
            NinteichosahyoServiceJokyo joho = new NinteichosahyoServiceJokyo(new ShinseishoKanriNo(
                    data.get申請書管理番号()), data.get認定調査依頼履歴番号(),
                    getサービスの状況を変換(GaikyoChosahyouServiceJyouk02A.通所介護.get連番()));
            joho = joho.createBuilderForEdit().setサービスの状況(getサービスの状況を変換(data.get通所看護_ﾃﾞｲｻｰﾋﾞｽの回数())).build();
            joho = joho.createBuilderForEdit().set厚労省IF識別コード(new Code(data.get厚労省IF識別コード())).build();
            サービスの状況List.add(joho);
        }
        if (!サービスの状況_02A.contains(GaikyoChosahyouServiceJyouk02A.通所リハビリ.get連番())) {
            NinteichosahyoServiceJokyo joho = new NinteichosahyoServiceJokyo(new ShinseishoKanriNo(
                    data.get申請書管理番号()), data.get認定調査依頼履歴番号(),
                    getサービスの状況を変換(GaikyoChosahyouServiceJyouk02A.通所リハビリ.get連番()));
            joho = joho.createBuilderForEdit().setサービスの状況(getサービスの状況を変換(data.get通所ﾘﾊﾋﾞﾘﾃｰｼｮﾝの回数())).build();
            joho = joho.createBuilderForEdit().set厚労省IF識別コード(new Code(data.get厚労省IF識別コード())).build();
            サービスの状況List.add(joho);
        }
        if (!サービスの状況_02A.contains(GaikyoChosahyouServiceJyouk02A.福祉用具貸与.get連番())) {
            NinteichosahyoServiceJokyo joho = new NinteichosahyoServiceJokyo(new ShinseishoKanriNo(
                    data.get申請書管理番号()), data.get認定調査依頼履歴番号(),
                    getサービスの状況を変換(GaikyoChosahyouServiceJyouk02A.福祉用具貸与.get連番()));
            joho = joho.createBuilderForEdit().setサービスの状況(getサービスの状況を変換(data.get福祉用具貸与の品目())).build();
            joho = joho.createBuilderForEdit().set厚労省IF識別コード(new Code(data.get厚労省IF識別コード())).build();
            サービスの状況List.add(joho);
        }
        if (!サービスの状況_02A.contains(GaikyoChosahyouServiceJyouk02A.短期入所生活介護.get連番())) {
            NinteichosahyoServiceJokyo joho = new NinteichosahyoServiceJokyo(new ShinseishoKanriNo(
                    data.get申請書管理番号()), data.get認定調査依頼履歴番号(),
                    getサービスの状況を変換(GaikyoChosahyouServiceJyouk02A.短期入所生活介護.get連番()));
            joho = joho.createBuilderForEdit().setサービスの状況(getサービスの状況を変換(data.get短期入所生活介護の日数())).build();
            joho = joho.createBuilderForEdit().set厚労省IF識別コード(new Code(data.get厚労省IF識別コード())).build();
            サービスの状況List.add(joho);
        }
        if (!サービスの状況_02A.contains(GaikyoChosahyouServiceJyouk02A.短期入所療養介護.get連番())) {
            NinteichosahyoServiceJokyo joho = new NinteichosahyoServiceJokyo(new ShinseishoKanriNo(
                    data.get申請書管理番号()), data.get認定調査依頼履歴番号(),
                    getサービスの状況を変換(GaikyoChosahyouServiceJyouk02A.短期入所療養介護.get連番()));
            joho = joho.createBuilderForEdit().setサービスの状況(getサービスの状況を変換(data.get短期入所療養介護の日数())).build();
            joho = joho.createBuilderForEdit().set厚労省IF識別コード(new Code(data.get厚労省IF識別コード())).build();
            サービスの状況List.add(joho);
        }
        if (!サービスの状況_02A.contains(GaikyoChosahyouServiceJyouk02A.認知症対応型共同生活介護.get連番())) {
            NinteichosahyoServiceJokyo joho = new NinteichosahyoServiceJokyo(new ShinseishoKanriNo(
                    data.get申請書管理番号()), data.get認定調査依頼履歴番号(),
                    getサービスの状況を変換(GaikyoChosahyouServiceJyouk02A.認知症対応型共同生活介護.get連番()));
            joho = joho.createBuilderForEdit().setサービスの状況(getサービスの状況を変換(data.get認知症対応型共同生活介護の日数())).build();
            joho = joho.createBuilderForEdit().set厚労省IF識別コード(new Code(data.get厚労省IF識別コード())).build();
            サービスの状況List.add(joho);
        }
        if (!サービスの状況_02A.contains(GaikyoChosahyouServiceJyouk02A.特定施設入所者生活介護.get連番())) {
            NinteichosahyoServiceJokyo joho = new NinteichosahyoServiceJokyo(new ShinseishoKanriNo(
                    data.get申請書管理番号()), data.get認定調査依頼履歴番号(),
                    getサービスの状況を変換(GaikyoChosahyouServiceJyouk02A.特定施設入所者生活介護.get連番()));
            joho = joho.createBuilderForEdit().setサービスの状況(getサービスの状況を変換(data.get特定施設入所者生活介護の日数())).build();
            joho = joho.createBuilderForEdit().set厚労省IF識別コード(new Code(data.get厚労省IF識別コード())).build();
            サービスの状況List.add(joho);
        }
        if (!サービスの状況_02A.contains(GaikyoChosahyouServiceJyouk02A.福祉用具購入.get連番())) {
            NinteichosahyoServiceJokyo joho = new NinteichosahyoServiceJokyo(new ShinseishoKanriNo(
                    data.get申請書管理番号()), data.get認定調査依頼履歴番号(),
                    getサービスの状況を変換(GaikyoChosahyouServiceJyouk02A.福祉用具購入.get連番()));
            joho = joho.createBuilderForEdit().setサービスの状況(getサービスの状況を変換(data.get福祉用具購入の品目())).build();
            joho = joho.createBuilderForEdit().set厚労省IF識別コード(new Code(data.get厚労省IF識別コード())).build();
            サービスの状況List.add(joho);
        }
        return サービスの状況List;
    }

    private List<NinteichosahyoServiceJokyo> setDbT5207_06A(List<NinteichosahyoServiceJokyo> サービスの状況List, NinteiTorokuData data) {
        for (int i = 0; i < サービスの状況List.size(); i++) {
            NinteichosahyoServiceJokyo joho = サービスの状況List.get(i);
            if (GaikyoChosahyouServiceJyouk06A.訪問介護.get連番().equals(new RString(joho.get連番()))) {
                joho = joho.createBuilderForEdit().setサービスの状況(getサービスの状況を変換(data.get訪問介護_ﾎｰﾑﾍﾙﾌﾟｻｰﾋﾞｽの回数())).build();
                サービスの状況_06A.add(GaikyoChosahyouServiceJyouk06A.訪問介護.get連番());
                サービスの状況List.set(i, joho.modifiedModel());
            }
            if (GaikyoChosahyouServiceJyouk06A.訪問入浴介護.get連番().equals(new RString(joho.get連番()))) {
                joho = joho.createBuilderForEdit().setサービスの状況(getサービスの状況を変換(data.get訪問入浴介護の回数())).build();
                サービスの状況_06A.add(GaikyoChosahyouServiceJyouk06A.訪問入浴介護.get連番());
                サービスの状況List.set(i, joho.modifiedModel());
            }
            if (GaikyoChosahyouServiceJyouk06A.訪問看護.get連番().equals(new RString(joho.get連番()))) {
                joho = joho.createBuilderForEdit().setサービスの状況(getサービスの状況を変換(data.get訪問看護の回数())).build();
                サービスの状況_06A.add(GaikyoChosahyouServiceJyouk06A.訪問看護.get連番());
                サービスの状況List.set(i, joho.modifiedModel());
            }
            if (GaikyoChosahyouServiceJyouk06A.訪問リハビリ.get連番().equals(new RString(joho.get連番()))) {
                joho = joho.createBuilderForEdit().setサービスの状況(getサービスの状況を変換(data.get訪問ﾘﾊﾋﾞﾘﾃｰｼｮﾝの回数())).build();
                サービスの状況_06A.add(GaikyoChosahyouServiceJyouk06A.訪問リハビリ.get連番());
                サービスの状況List.set(i, joho.modifiedModel());
            }
            if (GaikyoChosahyouServiceJyouk06A.居宅療養管理指導.get連番().equals(new RString(joho.get連番()))) {
                joho = joho.createBuilderForEdit().setサービスの状況(getサービスの状況を変換(data.get居宅療養管理指導の回数())).build();
                サービスの状況_06A.add(GaikyoChosahyouServiceJyouk06A.居宅療養管理指導.get連番());
                サービスの状況List.set(i, joho.modifiedModel());
            }
            if (GaikyoChosahyouServiceJyouk06A.通所介護.get連番().equals(new RString(joho.get連番()))) {
                joho = joho.createBuilderForEdit().setサービスの状況(getサービスの状況を変換(data.get通所看護_ﾃﾞｲｻｰﾋﾞｽの回数())).build();
                サービスの状況_06A.add(GaikyoChosahyouServiceJyouk06A.通所介護.get連番());
                サービスの状況List.set(i, joho.modifiedModel());
            }
            if (GaikyoChosahyouServiceJyouk06A.通所リハビリ.get連番().equals(new RString(joho.get連番()))) {
                joho = joho.createBuilderForEdit().setサービスの状況(getサービスの状況を変換(data.get通所ﾘﾊﾋﾞﾘﾃｰｼｮﾝの回数())).build();
                サービスの状況_06A.add(GaikyoChosahyouServiceJyouk06A.通所リハビリ.get連番());
                サービスの状況List.set(i, joho.modifiedModel());
            }
            if (GaikyoChosahyouServiceJyouk06A.福祉用具貸与.get連番().equals(new RString(joho.get連番()))) {
                joho = joho.createBuilderForEdit().setサービスの状況(getサービスの状況を変換(data.get福祉用具貸与の品目())).build();
                サービスの状況_06A.add(GaikyoChosahyouServiceJyouk06A.福祉用具貸与.get連番());
                サービスの状況List.set(i, joho.modifiedModel());
            }
            if (GaikyoChosahyouServiceJyouk06A.短期入所生活介護.get連番().equals(new RString(joho.get連番()))) {
                joho = joho.createBuilderForEdit().setサービスの状況(getサービスの状況を変換(data.get短期入所生活介護の日数())).build();
                サービスの状況_06A.add(GaikyoChosahyouServiceJyouk06A.短期入所生活介護.get連番());
                サービスの状況List.set(i, joho.modifiedModel());
            }
            if (GaikyoChosahyouServiceJyouk06A.短期入所療養介護.get連番().equals(new RString(joho.get連番()))) {
                joho = joho.createBuilderForEdit().setサービスの状況(getサービスの状況を変換(data.get短期入所療養介護の日数())).build();
                サービスの状況_06A.add(GaikyoChosahyouServiceJyouk06A.短期入所療養介護.get連番());
                サービスの状況List.set(i, joho.modifiedModel());
            }
            if (GaikyoChosahyouServiceJyouk06A.認知症対応型共同生活介護.get連番().equals(new RString(joho.get連番()))) {
                joho = joho.createBuilderForEdit().setサービスの状況(getサービスの状況を変換(data.get認知症対応型共同生活介護の日数())).build();
                サービスの状況_06A.add(GaikyoChosahyouServiceJyouk06A.認知症対応型共同生活介護.get連番());
                サービスの状況List.set(i, joho.modifiedModel());
            }
            if (GaikyoChosahyouServiceJyouk06A.特定施設入所者生活介護.get連番().equals(new RString(joho.get連番()))) {
                joho = joho.createBuilderForEdit().setサービスの状況(getサービスの状況を変換(data.get特定施設入所者生活介護の日数())).build();
                サービスの状況_06A.add(GaikyoChosahyouServiceJyouk06A.特定施設入所者生活介護.get連番());
                サービスの状況List.set(i, joho.modifiedModel());
            }
            if (GaikyoChosahyouServiceJyouk06A.福祉用具購入.get連番().equals(new RString(joho.get連番()))) {
                joho = joho.createBuilderForEdit().setサービスの状況(getサービスの状況を変換(data.get福祉用具購入の品目())).build();
                サービスの状況_06A.add(GaikyoChosahyouServiceJyouk06A.福祉用具購入.get連番());
                サービスの状況List.set(i, joho.modifiedModel());
            }
            if (GaikyoChosahyouServiceJyouk06A.夜間対応型訪問介護.get連番().equals(new RString(joho.get連番()))) {
                joho = joho.createBuilderForEdit().setサービスの状況(getサービスの状況を変換(data.get夜間対応型訪問介護の日数())).build();
                サービスの状況_06A.add(GaikyoChosahyouServiceJyouk06A.夜間対応型訪問介護.get連番());
                サービスの状況List.set(i, joho.modifiedModel());
            }
            if (GaikyoChosahyouServiceJyouk06A.認知症対応型通所介護.get連番().equals(new RString(joho.get連番()))) {
                joho = joho.createBuilderForEdit().setサービスの状況(getサービスの状況を変換(data.get認知症対応型通所介護の日数())).build();
                サービスの状況_06A.add(GaikyoChosahyouServiceJyouk06A.認知症対応型通所介護.get連番());
                サービスの状況List.set(i, joho.modifiedModel());
            }
            if (GaikyoChosahyouServiceJyouk06A.小規模多機能型居宅介護.get連番().equals(new RString(joho.get連番()))) {
                joho = joho.createBuilderForEdit().setサービスの状況(getサービスの状況を変換(data.get小規模多機能型居宅介護の日数())).build();
                サービスの状況_06A.add(GaikyoChosahyouServiceJyouk06A.小規模多機能型居宅介護.get連番());
                サービスの状況List.set(i, joho.modifiedModel());
            }
            if (GaikyoChosahyouServiceJyouk06A.地域密着型特定施設入居者生活介護.get連番().equals(new RString(joho.get連番()))) {
                joho = joho.createBuilderForEdit().setサービスの状況(getサービスの状況を変換(data.get地域密着型特定施設入居者生活介護の日数())).build();
                サービスの状況_06A.add(GaikyoChosahyouServiceJyouk06A.地域密着型特定施設入居者生活介護.get連番());
                サービスの状況List.set(i, joho.modifiedModel());
            }
            サービスの状況List.set(i, setDbT5207_06A_bak(joho, data));
        }
        return サービスの状況List;
    }

    private NinteichosahyoServiceJokyo setDbT5207_06A_bak(NinteichosahyoServiceJokyo joho, NinteiTorokuData data) {
        if (GaikyoChosahyouServiceJyouk06A.地域密着型介護老人福祉施設入所者生活介護.get連番().equals(new RString(joho.get連番()))) {
            joho = joho.createBuilderForEdit().setサービスの状況(getサービスの状況を変換(data.get地域密着型特定施設入居者生活介護の日数()))
                    .build().modifiedModel();
            サービスの状況_06A.add(GaikyoChosahyouServiceJyouk06A.地域密着型介護老人福祉施設入所者生活介護.get連番());
        }
        return joho;
    }

    private List<NinteichosahyoServiceJokyo> set新規サービスの状況_06A(List<NinteichosahyoServiceJokyo> サービスの状況List, NinteiTorokuData data) {
        if (!サービスの状況_06A.contains(GaikyoChosahyouServiceJyouk09A.訪問介護.get連番())) {
            NinteichosahyoServiceJokyo joho = new NinteichosahyoServiceJokyo(new ShinseishoKanriNo(
                    data.get申請書管理番号()), data.get認定調査依頼履歴番号(),
                    getサービスの状況を変換(GaikyoChosahyouServiceJyouk09A.訪問介護.get連番()));
            joho = joho.createBuilderForEdit().setサービスの状況(getサービスの状況を変換(data.get訪問介護_ﾎｰﾑﾍﾙﾌﾟｻｰﾋﾞｽの回数())).build();
            joho = joho.createBuilderForEdit().set厚労省IF識別コード(new Code(data.get厚労省IF識別コード())).build();
            サービスの状況List.add(joho);
        }
        if (!サービスの状況_06A.contains(GaikyoChosahyouServiceJyouk09A.訪問入浴介護.get連番())) {
            NinteichosahyoServiceJokyo joho = new NinteichosahyoServiceJokyo(new ShinseishoKanriNo(
                    data.get申請書管理番号()), data.get認定調査依頼履歴番号(),
                    getサービスの状況を変換(GaikyoChosahyouServiceJyouk09A.訪問入浴介護.get連番()));
            joho = joho.createBuilderForEdit().setサービスの状況(getサービスの状況を変換(data.get訪問入浴介護の回数())).build();
            joho = joho.createBuilderForEdit().set厚労省IF識別コード(new Code(data.get厚労省IF識別コード())).build();
            サービスの状況List.add(joho);
        }
        if (!サービスの状況_06A.contains(GaikyoChosahyouServiceJyouk09A.訪問看護.get連番())) {
            NinteichosahyoServiceJokyo joho = new NinteichosahyoServiceJokyo(new ShinseishoKanriNo(
                    data.get申請書管理番号()), data.get認定調査依頼履歴番号(),
                    getサービスの状況を変換(GaikyoChosahyouServiceJyouk09A.訪問看護.get連番()));
            joho = joho.createBuilderForEdit().setサービスの状況(getサービスの状況を変換(data.get訪問介護_ﾎｰﾑﾍﾙﾌﾟｻｰﾋﾞｽの回数())).build();
            joho = joho.createBuilderForEdit().set厚労省IF識別コード(new Code(data.get厚労省IF識別コード())).build();
            サービスの状況List.add(joho);
        }
        if (!サービスの状況_06A.contains(GaikyoChosahyouServiceJyouk09A.訪問リハビリ.get連番())) {
            NinteichosahyoServiceJokyo joho = new NinteichosahyoServiceJokyo(new ShinseishoKanriNo(
                    data.get申請書管理番号()), data.get認定調査依頼履歴番号(),
                    getサービスの状況を変換(GaikyoChosahyouServiceJyouk09A.訪問リハビリ.get連番()));
            joho = joho.createBuilderForEdit().setサービスの状況(getサービスの状況を変換(data.get訪問ﾘﾊﾋﾞﾘﾃｰｼｮﾝの回数())).build();
            joho = joho.createBuilderForEdit().set厚労省IF識別コード(new Code(data.get厚労省IF識別コード())).build();
            サービスの状況List.add(joho);
        }
        if (!サービスの状況_06A.contains(GaikyoChosahyouServiceJyouk09A.居宅療養管理指導.get連番())) {
            NinteichosahyoServiceJokyo joho = new NinteichosahyoServiceJokyo(new ShinseishoKanriNo(
                    data.get申請書管理番号()), data.get認定調査依頼履歴番号(),
                    getサービスの状況を変換(GaikyoChosahyouServiceJyouk09A.居宅療養管理指導.get連番()));
            joho = joho.createBuilderForEdit().setサービスの状況(getサービスの状況を変換(data.get居宅療養管理指導の回数())).build();
            joho = joho.createBuilderForEdit().set厚労省IF識別コード(new Code(data.get厚労省IF識別コード())).build();
            サービスの状況List.add(joho);
        }
        if (!サービスの状況_06A.contains(GaikyoChosahyouServiceJyouk09A.通所介護.get連番())) {
            NinteichosahyoServiceJokyo joho = new NinteichosahyoServiceJokyo(new ShinseishoKanriNo(
                    data.get申請書管理番号()), data.get認定調査依頼履歴番号(),
                    getサービスの状況を変換(GaikyoChosahyouServiceJyouk09A.通所介護.get連番()));
            joho = joho.createBuilderForEdit().setサービスの状況(getサービスの状況を変換(data.get通所看護_ﾃﾞｲｻｰﾋﾞｽの回数())).build();
            joho = joho.createBuilderForEdit().set厚労省IF識別コード(new Code(data.get厚労省IF識別コード())).build();
            サービスの状況List.add(joho);
        }
        if (!サービスの状況_06A.contains(GaikyoChosahyouServiceJyouk09A.通所リハビリ.get連番())) {
            NinteichosahyoServiceJokyo joho = new NinteichosahyoServiceJokyo(new ShinseishoKanriNo(
                    data.get申請書管理番号()), data.get認定調査依頼履歴番号(),
                    getサービスの状況を変換(GaikyoChosahyouServiceJyouk09A.通所リハビリ.get連番()));
            joho = joho.createBuilderForEdit().setサービスの状況(getサービスの状況を変換(data.get通所ﾘﾊﾋﾞﾘﾃｰｼｮﾝの回数())).build();
            joho = joho.createBuilderForEdit().set厚労省IF識別コード(new Code(data.get厚労省IF識別コード())).build();
            サービスの状況List.add(joho);
        }
        if (!サービスの状況_06A.contains(GaikyoChosahyouServiceJyouk09A.福祉用具貸与.get連番())) {
            NinteichosahyoServiceJokyo joho = new NinteichosahyoServiceJokyo(new ShinseishoKanriNo(
                    data.get申請書管理番号()), data.get認定調査依頼履歴番号(),
                    getサービスの状況を変換(GaikyoChosahyouServiceJyouk09A.福祉用具貸与.get連番()));
            joho = joho.createBuilderForEdit().setサービスの状況(getサービスの状況を変換(data.get福祉用具貸与の品目())).build();
            joho = joho.createBuilderForEdit().set厚労省IF識別コード(new Code(data.get厚労省IF識別コード())).build();
            サービスの状況List.add(joho);
        }
        if (!サービスの状況_06A.contains(GaikyoChosahyouServiceJyouk09A.短期入所生活介護.get連番())) {
            NinteichosahyoServiceJokyo joho = new NinteichosahyoServiceJokyo(new ShinseishoKanriNo(
                    data.get申請書管理番号()), data.get認定調査依頼履歴番号(),
                    getサービスの状況を変換(GaikyoChosahyouServiceJyouk09A.短期入所生活介護.get連番()));
            joho = joho.createBuilderForEdit().setサービスの状況(getサービスの状況を変換(data.get短期入所生活介護の日数())).build();
            joho = joho.createBuilderForEdit().set厚労省IF識別コード(new Code(data.get厚労省IF識別コード())).build();
            サービスの状況List.add(joho);
        }
        if (!サービスの状況_06A.contains(GaikyoChosahyouServiceJyouk09A.短期入所療養介護.get連番())) {
            NinteichosahyoServiceJokyo joho = new NinteichosahyoServiceJokyo(new ShinseishoKanriNo(
                    data.get申請書管理番号()), data.get認定調査依頼履歴番号(),
                    getサービスの状況を変換(GaikyoChosahyouServiceJyouk09A.短期入所療養介護.get連番()));
            joho = joho.createBuilderForEdit().setサービスの状況(getサービスの状況を変換(data.get短期入所療養介護の日数())).build();
            joho = joho.createBuilderForEdit().set厚労省IF識別コード(new Code(data.get厚労省IF識別コード())).build();
            サービスの状況List.add(joho);
        }
        if (!サービスの状況_06A.contains(GaikyoChosahyouServiceJyouk09A.認知症対応型共同生活介護.get連番())) {
            NinteichosahyoServiceJokyo joho = new NinteichosahyoServiceJokyo(new ShinseishoKanriNo(
                    data.get申請書管理番号()), data.get認定調査依頼履歴番号(),
                    getサービスの状況を変換(GaikyoChosahyouServiceJyouk09A.認知症対応型共同生活介護.get連番()));
            joho = joho.createBuilderForEdit().setサービスの状況(getサービスの状況を変換(data.get認知症対応型共同生活介護の日数())).build();
            joho = joho.createBuilderForEdit().set厚労省IF識別コード(new Code(data.get厚労省IF識別コード())).build();
            サービスの状況List.add(joho);
        }
        if (!サービスの状況_06A.contains(GaikyoChosahyouServiceJyouk09A.特定施設入所者生活介護.get連番())) {
            NinteichosahyoServiceJokyo joho = new NinteichosahyoServiceJokyo(new ShinseishoKanriNo(
                    data.get申請書管理番号()), data.get認定調査依頼履歴番号(),
                    getサービスの状況を変換(GaikyoChosahyouServiceJyouk09A.特定施設入所者生活介護.get連番()));
            joho = joho.createBuilderForEdit().setサービスの状況(getサービスの状況を変換(data.get特定施設入所者生活介護の日数())).build();
            joho = joho.createBuilderForEdit().set厚労省IF識別コード(new Code(data.get厚労省IF識別コード())).build();
            サービスの状況List.add(joho);
        }
        if (!サービスの状況_06A.contains(GaikyoChosahyouServiceJyouk09A.福祉用具購入.get連番())) {
            NinteichosahyoServiceJokyo joho = new NinteichosahyoServiceJokyo(new ShinseishoKanriNo(
                    data.get申請書管理番号()), data.get認定調査依頼履歴番号(),
                    getサービスの状況を変換(GaikyoChosahyouServiceJyouk09A.福祉用具購入.get連番()));
            joho = joho.createBuilderForEdit().setサービスの状況(getサービスの状況を変換(data.get福祉用具購入の品目())).build();
            joho = joho.createBuilderForEdit().set厚労省IF識別コード(new Code(data.get厚労省IF識別コード())).build();
            サービスの状況List.add(joho);
        }
        if (!サービスの状況_06A.contains(GaikyoChosahyouServiceJyouk09A.夜間対応型訪問介護.get連番())) {
            NinteichosahyoServiceJokyo joho = new NinteichosahyoServiceJokyo(new ShinseishoKanriNo(
                    data.get申請書管理番号()), data.get認定調査依頼履歴番号(),
                    getサービスの状況を変換(GaikyoChosahyouServiceJyouk09A.夜間対応型訪問介護.get連番()));
            joho = joho.createBuilderForEdit().setサービスの状況(getサービスの状況を変換(data.get夜間対応型訪問介護の日数())).build();
            joho = joho.createBuilderForEdit().set厚労省IF識別コード(new Code(data.get厚労省IF識別コード())).build();
            サービスの状況List.add(joho);
        }
        if (!サービスの状況_06A.contains(GaikyoChosahyouServiceJyouk09A.認知症対応型通所介護.get連番())) {
            NinteichosahyoServiceJokyo joho = new NinteichosahyoServiceJokyo(new ShinseishoKanriNo(
                    data.get申請書管理番号()), data.get認定調査依頼履歴番号(),
                    getサービスの状況を変換(GaikyoChosahyouServiceJyouk09A.認知症対応型通所介護.get連番()));
            joho = joho.createBuilderForEdit().setサービスの状況(getサービスの状況を変換(data.get認知症対応型通所介護の日数())).build();
            joho = joho.createBuilderForEdit().set厚労省IF識別コード(new Code(data.get厚労省IF識別コード())).build();
            サービスの状況List.add(joho);
        }
        if (!サービスの状況_06A.contains(GaikyoChosahyouServiceJyouk09A.小規模多機能型居宅介護.get連番())) {
            NinteichosahyoServiceJokyo joho = new NinteichosahyoServiceJokyo(new ShinseishoKanriNo(
                    data.get申請書管理番号()), data.get認定調査依頼履歴番号(),
                    getサービスの状況を変換(GaikyoChosahyouServiceJyouk09A.小規模多機能型居宅介護.get連番()));
            joho = joho.createBuilderForEdit().setサービスの状況(getサービスの状況を変換(data.get小規模多機能型居宅介護の日数())).build();
            joho = joho.createBuilderForEdit().set厚労省IF識別コード(new Code(data.get厚労省IF識別コード())).build();
            サービスの状況List.add(joho);
        }
        if (!サービスの状況_06A.contains(GaikyoChosahyouServiceJyouk09A.地域密着型特定施設入居者生活介護.get連番())) {
            NinteichosahyoServiceJokyo joho = new NinteichosahyoServiceJokyo(new ShinseishoKanriNo(
                    data.get申請書管理番号()), data.get認定調査依頼履歴番号(),
                    getサービスの状況を変換(GaikyoChosahyouServiceJyouk09A.地域密着型特定施設入居者生活介護.get連番()));
            joho = joho.createBuilderForEdit().setサービスの状況(getサービスの状況を変換(data.get地域密着型特定施設入居者生活介護の日数())).build();
            joho = joho.createBuilderForEdit().set厚労省IF識別コード(new Code(data.get厚労省IF識別コード())).build();
            サービスの状況List.add(joho);
        }
        if (!サービスの状況_06A.contains(GaikyoChosahyouServiceJyouk09A.地域密着型介護老人福祉施設入所者生活介護.get連番())) {
            NinteichosahyoServiceJokyo joho = new NinteichosahyoServiceJokyo(new ShinseishoKanriNo(
                    data.get申請書管理番号()), data.get認定調査依頼履歴番号(),
                    getサービスの状況を変換(GaikyoChosahyouServiceJyouk09A.地域密着型介護老人福祉施設入所者生活介護.get連番()));
            joho = joho.createBuilderForEdit().setサービスの状況(getサービスの状況を変換(data.get地域密着型特定施設入居者生活介護の日数())).build();
            joho = joho.createBuilderForEdit().set厚労省IF識別コード(new Code(data.get厚労省IF識別コード())).build();
            サービスの状況List.add(joho);
        }
        return サービスの状況List;
    }

    private List<NinteichosahyoServiceJokyo> setDbT5207_09A(List<NinteichosahyoServiceJokyo> サービスの状況List, NinteiTorokuData data) {
        for (int i = 0; i < サービスの状況List.size(); i++) {
            NinteichosahyoServiceJokyo joho = サービスの状況List.get(i);
            if (GaikyoChosahyouServiceJyouk09A.訪問介護.get連番().equals(new RString(joho.get連番()))) {
                joho = joho.createBuilderForEdit().setサービスの状況(getサービスの状況を変換(data.get訪問介護_ﾎｰﾑﾍﾙﾌﾟｻｰﾋﾞｽの回数())).build();
                サービスの状況_09A.add(GaikyoChosahyouServiceJyouk09A.訪問介護.get連番());
                サービスの状況List.set(i, joho.modifiedModel());
            }
            if (GaikyoChosahyouServiceJyouk09A.訪問入浴介護.get連番().equals(new RString(joho.get連番()))) {
                joho = joho.createBuilderForEdit().setサービスの状況(getサービスの状況を変換(data.get訪問入浴介護の回数())).build();
                サービスの状況_09A.add(GaikyoChosahyouServiceJyouk09A.訪問入浴介護.get連番());
                サービスの状況List.set(i, joho.modifiedModel());
            }
            if (GaikyoChosahyouServiceJyouk09A.訪問看護.get連番().equals(new RString(joho.get連番()))) {
                joho = joho.createBuilderForEdit().setサービスの状況(getサービスの状況を変換(data.get訪問看護の回数())).build();
                サービスの状況_09A.add(GaikyoChosahyouServiceJyouk09A.訪問看護.get連番());
                サービスの状況List.set(i, joho.modifiedModel());
            }
            if (GaikyoChosahyouServiceJyouk09A.訪問リハビリ.get連番().equals(new RString(joho.get連番()))) {
                joho = joho.createBuilderForEdit().setサービスの状況(getサービスの状況を変換(data.get訪問ﾘﾊﾋﾞﾘﾃｰｼｮﾝの回数())).build();
                サービスの状況_09A.add(GaikyoChosahyouServiceJyouk09A.訪問リハビリ.get連番());
                サービスの状況List.set(i, joho.modifiedModel());
            }
            if (GaikyoChosahyouServiceJyouk09A.居宅療養管理指導.get連番().equals(new RString(joho.get連番()))) {
                joho = joho.createBuilderForEdit().setサービスの状況(getサービスの状況を変換(data.get居宅療養管理指導の回数())).build();
                サービスの状況_09A.add(GaikyoChosahyouServiceJyouk09A.居宅療養管理指導.get連番());
                サービスの状況List.set(i, joho.modifiedModel());
            }
            if (GaikyoChosahyouServiceJyouk09A.通所介護.get連番().equals(new RString(joho.get連番()))) {
                joho = joho.createBuilderForEdit().setサービスの状況(getサービスの状況を変換(data.get通所看護_ﾃﾞｲｻｰﾋﾞｽの回数())).build();
                サービスの状況_09A.add(GaikyoChosahyouServiceJyouk09A.通所介護.get連番());
                サービスの状況List.set(i, joho.modifiedModel());
            }
            if (GaikyoChosahyouServiceJyouk09A.通所リハビリ.get連番().equals(new RString(joho.get連番()))) {
                joho = joho.createBuilderForEdit().setサービスの状況(getサービスの状況を変換(data.get通所ﾘﾊﾋﾞﾘﾃｰｼｮﾝの回数())).build();
                サービスの状況_09A.add(GaikyoChosahyouServiceJyouk09A.通所リハビリ.get連番());
                サービスの状況List.set(i, joho.modifiedModel());
            }
            if (GaikyoChosahyouServiceJyouk09A.福祉用具貸与.get連番().equals(new RString(joho.get連番()))) {
                joho = joho.createBuilderForEdit().setサービスの状況(getサービスの状況を変換(data.get福祉用具貸与の品目())).build();
                サービスの状況_09A.add(GaikyoChosahyouServiceJyouk09A.福祉用具貸与.get連番());
                サービスの状況List.set(i, joho.modifiedModel());
            }
            if (GaikyoChosahyouServiceJyouk09A.短期入所生活介護.get連番().equals(new RString(joho.get連番()))) {
                joho = joho.createBuilderForEdit().setサービスの状況(getサービスの状況を変換(data.get短期入所生活介護の日数())).build();
                サービスの状況_09A.add(GaikyoChosahyouServiceJyouk09A.短期入所生活介護.get連番());
                サービスの状況List.set(i, joho.modifiedModel());
            }
            if (GaikyoChosahyouServiceJyouk09A.短期入所療養介護.get連番().equals(new RString(joho.get連番()))) {
                joho = joho.createBuilderForEdit().setサービスの状況(getサービスの状況を変換(data.get短期入所療養介護の日数())).build();
                サービスの状況_09A.add(GaikyoChosahyouServiceJyouk09A.短期入所療養介護.get連番());
                サービスの状況List.set(i, joho.modifiedModel());
            }
            if (GaikyoChosahyouServiceJyouk09A.認知症対応型共同生活介護.get連番().equals(new RString(joho.get連番()))) {
                joho = joho.createBuilderForEdit().setサービスの状況(getサービスの状況を変換(data.get認知症対応型共同生活介護の日数())).build();
                サービスの状況_09A.add(GaikyoChosahyouServiceJyouk09A.認知症対応型共同生活介護.get連番());
                サービスの状況List.set(i, joho.modifiedModel());
            }
            if (GaikyoChosahyouServiceJyouk09A.特定施設入所者生活介護.get連番().equals(new RString(joho.get連番()))) {
                joho = joho.createBuilderForEdit().setサービスの状況(getサービスの状況を変換(data.get特定施設入所者生活介護の日数())).build();
                サービスの状況_09A.add(GaikyoChosahyouServiceJyouk09A.特定施設入所者生活介護.get連番());
                サービスの状況List.set(i, joho.modifiedModel());
            }
            if (GaikyoChosahyouServiceJyouk09A.福祉用具購入.get連番().equals(new RString(joho.get連番()))) {
                joho = joho.createBuilderForEdit().setサービスの状況(getサービスの状況を変換(data.get福祉用具購入の品目())).build();
                サービスの状況_09A.add(GaikyoChosahyouServiceJyouk09A.福祉用具購入.get連番());
                サービスの状況List.set(i, joho.modifiedModel());
            }
            if (GaikyoChosahyouServiceJyouk09A.夜間対応型訪問介護.get連番().equals(new RString(joho.get連番()))) {
                joho = joho.createBuilderForEdit().setサービスの状況(getサービスの状況を変換(data.get夜間対応型訪問介護の日数())).build();
                サービスの状況_09A.add(GaikyoChosahyouServiceJyouk09A.夜間対応型訪問介護.get連番());
                サービスの状況List.set(i, joho.modifiedModel());
            }
            if (GaikyoChosahyouServiceJyouk09A.認知症対応型通所介護.get連番().equals(new RString(joho.get連番()))) {
                joho = joho.createBuilderForEdit().setサービスの状況(getサービスの状況を変換(data.get認知症対応型通所介護の日数())).build();
                サービスの状況_09A.add(GaikyoChosahyouServiceJyouk09A.認知症対応型通所介護.get連番());
                サービスの状況List.set(i, joho.modifiedModel());
            }
            if (GaikyoChosahyouServiceJyouk09A.小規模多機能型居宅介護.get連番().equals(new RString(joho.get連番()))) {
                joho = joho.createBuilderForEdit().setサービスの状況(getサービスの状況を変換(data.get小規模多機能型居宅介護の日数())).build();
                サービスの状況_09A.add(GaikyoChosahyouServiceJyouk09A.小規模多機能型居宅介護.get連番());
                サービスの状況List.set(i, joho.modifiedModel());
            }
            if (GaikyoChosahyouServiceJyouk09A.地域密着型特定施設入居者生活介護.get連番().equals(new RString(joho.get連番()))) {
                joho = joho.createBuilderForEdit().setサービスの状況(getサービスの状況を変換(data.get地域密着型特定施設入居者生活介護の日数())).build();
                サービスの状況_09A.add(GaikyoChosahyouServiceJyouk09A.地域密着型特定施設入居者生活介護.get連番());
                サービスの状況List.set(i, joho.modifiedModel());
            }
            サービスの状況List.set(i, setDbT5207_09A_bak(joho, data));
        }
        return サービスの状況List;
    }

    private NinteichosahyoServiceJokyo setDbT5207_09A_bak(NinteichosahyoServiceJokyo joho, NinteiTorokuData data) {
        if (GaikyoChosahyouServiceJyouk09A.地域密着型介護老人福祉施設入所者生活介護.get連番().equals(new RString(joho.get連番()))) {
            joho = joho.createBuilderForEdit().setサービスの状況(getサービスの状況を変換(data.
                    get地域密着型特定施設入居者生活介護の日数())).build().modifiedModel();
            サービスの状況_09A.add(GaikyoChosahyouServiceJyouk09A.地域密着型介護老人福祉施設入所者生活介護.get連番());
        }
        return joho;
    }

    private List<NinteichosahyoServiceJokyo> set新規サービスの状況_09A(List<NinteichosahyoServiceJokyo> サービスの状況List, NinteiTorokuData data) {
        if (!サービスの状況_09A.contains(GaikyoChosahyouServiceJyouk09A.訪問介護.get連番())) {
            NinteichosahyoServiceJokyo joho = new NinteichosahyoServiceJokyo(new ShinseishoKanriNo(
                    data.get申請書管理番号()), data.get認定調査依頼履歴番号(),
                    getサービスの状況を変換(GaikyoChosahyouServiceJyouk09A.訪問介護.get連番()));
            joho = joho.createBuilderForEdit().setサービスの状況(getサービスの状況を変換(data.get訪問介護_ﾎｰﾑﾍﾙﾌﾟｻｰﾋﾞｽの回数())).build();
            joho = joho.createBuilderForEdit().set厚労省IF識別コード(new Code(data.get厚労省IF識別コード())).build();
            サービスの状況List.add(joho);
        }
        if (!サービスの状況_09A.contains(GaikyoChosahyouServiceJyouk09A.訪問入浴介護.get連番())) {
            NinteichosahyoServiceJokyo joho = new NinteichosahyoServiceJokyo(new ShinseishoKanriNo(
                    data.get申請書管理番号()), data.get認定調査依頼履歴番号(),
                    getサービスの状況を変換(GaikyoChosahyouServiceJyouk09A.訪問入浴介護.get連番()));
            joho = joho.createBuilderForEdit().setサービスの状況(getサービスの状況を変換(data.get訪問入浴介護の回数())).build();
            joho = joho.createBuilderForEdit().set厚労省IF識別コード(new Code(data.get厚労省IF識別コード())).build();
            サービスの状況List.add(joho);
        }
        if (!サービスの状況_09A.contains(GaikyoChosahyouServiceJyouk09A.訪問看護.get連番())) {
            NinteichosahyoServiceJokyo joho = new NinteichosahyoServiceJokyo(new ShinseishoKanriNo(
                    data.get申請書管理番号()), data.get認定調査依頼履歴番号(),
                    getサービスの状況を変換(GaikyoChosahyouServiceJyouk09A.訪問看護.get連番()));
            joho = joho.createBuilderForEdit().setサービスの状況(getサービスの状況を変換(data.get訪問介護_ﾎｰﾑﾍﾙﾌﾟｻｰﾋﾞｽの回数())).build();
            joho = joho.createBuilderForEdit().set厚労省IF識別コード(new Code(data.get厚労省IF識別コード())).build();
            サービスの状況List.add(joho);
        }
        if (!サービスの状況_09A.contains(GaikyoChosahyouServiceJyouk09A.訪問リハビリ.get連番())) {
            NinteichosahyoServiceJokyo joho = new NinteichosahyoServiceJokyo(new ShinseishoKanriNo(
                    data.get申請書管理番号()), data.get認定調査依頼履歴番号(),
                    getサービスの状況を変換(GaikyoChosahyouServiceJyouk09A.訪問リハビリ.get連番()));
            joho = joho.createBuilderForEdit().setサービスの状況(getサービスの状況を変換(data.get訪問ﾘﾊﾋﾞﾘﾃｰｼｮﾝの回数())).build();
            joho = joho.createBuilderForEdit().set厚労省IF識別コード(new Code(data.get厚労省IF識別コード())).build();
            サービスの状況List.add(joho);
        }
        if (!サービスの状況_09A.contains(GaikyoChosahyouServiceJyouk09A.居宅療養管理指導.get連番())) {
            NinteichosahyoServiceJokyo joho = new NinteichosahyoServiceJokyo(new ShinseishoKanriNo(
                    data.get申請書管理番号()), data.get認定調査依頼履歴番号(),
                    getサービスの状況を変換(GaikyoChosahyouServiceJyouk09A.居宅療養管理指導.get連番()));
            joho = joho.createBuilderForEdit().setサービスの状況(getサービスの状況を変換(data.get居宅療養管理指導の回数())).build();
            joho = joho.createBuilderForEdit().set厚労省IF識別コード(new Code(data.get厚労省IF識別コード())).build();
            サービスの状況List.add(joho);
        }
        if (!サービスの状況_09A.contains(GaikyoChosahyouServiceJyouk09A.通所介護.get連番())) {
            NinteichosahyoServiceJokyo joho = new NinteichosahyoServiceJokyo(new ShinseishoKanriNo(
                    data.get申請書管理番号()), data.get認定調査依頼履歴番号(),
                    getサービスの状況を変換(GaikyoChosahyouServiceJyouk09A.通所介護.get連番()));
            joho = joho.createBuilderForEdit().setサービスの状況(getサービスの状況を変換(data.get通所看護_ﾃﾞｲｻｰﾋﾞｽの回数())).build();
            joho = joho.createBuilderForEdit().set厚労省IF識別コード(new Code(data.get厚労省IF識別コード())).build();
            サービスの状況List.add(joho);
        }
        if (!サービスの状況_09A.contains(GaikyoChosahyouServiceJyouk09A.通所リハビリ.get連番())) {
            NinteichosahyoServiceJokyo joho = new NinteichosahyoServiceJokyo(new ShinseishoKanriNo(
                    data.get申請書管理番号()), data.get認定調査依頼履歴番号(),
                    getサービスの状況を変換(GaikyoChosahyouServiceJyouk09A.通所リハビリ.get連番()));
            joho = joho.createBuilderForEdit().setサービスの状況(getサービスの状況を変換(data.get通所ﾘﾊﾋﾞﾘﾃｰｼｮﾝの回数())).build();
            joho = joho.createBuilderForEdit().set厚労省IF識別コード(new Code(data.get厚労省IF識別コード())).build();
            サービスの状況List.add(joho);
        }
        if (!サービスの状況_09A.contains(GaikyoChosahyouServiceJyouk09A.福祉用具貸与.get連番())) {
            NinteichosahyoServiceJokyo joho = new NinteichosahyoServiceJokyo(new ShinseishoKanriNo(
                    data.get申請書管理番号()), data.get認定調査依頼履歴番号(),
                    getサービスの状況を変換(GaikyoChosahyouServiceJyouk09A.福祉用具貸与.get連番()));
            joho = joho.createBuilderForEdit().setサービスの状況(getサービスの状況を変換(data.get福祉用具貸与の品目())).build();
            joho = joho.createBuilderForEdit().set厚労省IF識別コード(new Code(data.get厚労省IF識別コード())).build();
            サービスの状況List.add(joho);
        }
        if (!サービスの状況_09A.contains(GaikyoChosahyouServiceJyouk09A.短期入所生活介護.get連番())) {
            NinteichosahyoServiceJokyo joho = new NinteichosahyoServiceJokyo(new ShinseishoKanriNo(
                    data.get申請書管理番号()), data.get認定調査依頼履歴番号(),
                    getサービスの状況を変換(GaikyoChosahyouServiceJyouk09A.短期入所生活介護.get連番()));
            joho = joho.createBuilderForEdit().setサービスの状況(getサービスの状況を変換(data.get短期入所生活介護の日数())).build();
            joho = joho.createBuilderForEdit().set厚労省IF識別コード(new Code(data.get厚労省IF識別コード())).build();
            サービスの状況List.add(joho);
        }
        if (!サービスの状況_09A.contains(GaikyoChosahyouServiceJyouk09A.短期入所療養介護.get連番())) {
            NinteichosahyoServiceJokyo joho = new NinteichosahyoServiceJokyo(new ShinseishoKanriNo(
                    data.get申請書管理番号()), data.get認定調査依頼履歴番号(),
                    getサービスの状況を変換(GaikyoChosahyouServiceJyouk09A.短期入所療養介護.get連番()));
            joho = joho.createBuilderForEdit().setサービスの状況(getサービスの状況を変換(data.get短期入所療養介護の日数())).build();
            joho = joho.createBuilderForEdit().set厚労省IF識別コード(new Code(data.get厚労省IF識別コード())).build();
            サービスの状況List.add(joho);
        }
        if (!サービスの状況_09A.contains(GaikyoChosahyouServiceJyouk09A.認知症対応型共同生活介護.get連番())) {
            NinteichosahyoServiceJokyo joho = new NinteichosahyoServiceJokyo(new ShinseishoKanriNo(
                    data.get申請書管理番号()), data.get認定調査依頼履歴番号(),
                    getサービスの状況を変換(GaikyoChosahyouServiceJyouk09A.認知症対応型共同生活介護.get連番()));
            joho = joho.createBuilderForEdit().setサービスの状況(getサービスの状況を変換(data.get認知症対応型共同生活介護の日数())).build();
            joho = joho.createBuilderForEdit().set厚労省IF識別コード(new Code(data.get厚労省IF識別コード())).build();
            サービスの状況List.add(joho);
        }
        if (!サービスの状況_09A.contains(GaikyoChosahyouServiceJyouk09A.特定施設入所者生活介護.get連番())) {
            NinteichosahyoServiceJokyo joho = new NinteichosahyoServiceJokyo(new ShinseishoKanriNo(
                    data.get申請書管理番号()), data.get認定調査依頼履歴番号(),
                    getサービスの状況を変換(GaikyoChosahyouServiceJyouk09A.特定施設入所者生活介護.get連番()));
            joho = joho.createBuilderForEdit().setサービスの状況(getサービスの状況を変換(data.get特定施設入所者生活介護の日数())).build();
            joho = joho.createBuilderForEdit().set厚労省IF識別コード(new Code(data.get厚労省IF識別コード())).build();
            サービスの状況List.add(joho);
        }
        if (!サービスの状況_09A.contains(GaikyoChosahyouServiceJyouk09A.福祉用具購入.get連番())) {
            NinteichosahyoServiceJokyo joho = new NinteichosahyoServiceJokyo(new ShinseishoKanriNo(
                    data.get申請書管理番号()), data.get認定調査依頼履歴番号(),
                    getサービスの状況を変換(GaikyoChosahyouServiceJyouk09A.福祉用具購入.get連番()));
            joho = joho.createBuilderForEdit().setサービスの状況(getサービスの状況を変換(data.get福祉用具購入の品目())).build();
            joho = joho.createBuilderForEdit().set厚労省IF識別コード(new Code(data.get厚労省IF識別コード())).build();
            サービスの状況List.add(joho);
        }
        if (!サービスの状況_09A.contains(GaikyoChosahyouServiceJyouk09A.夜間対応型訪問介護.get連番())) {
            NinteichosahyoServiceJokyo joho = new NinteichosahyoServiceJokyo(new ShinseishoKanriNo(
                    data.get申請書管理番号()), data.get認定調査依頼履歴番号(),
                    getサービスの状況を変換(GaikyoChosahyouServiceJyouk09A.夜間対応型訪問介護.get連番()));
            joho = joho.createBuilderForEdit().setサービスの状況(getサービスの状況を変換(data.get夜間対応型訪問介護の日数())).build();
            joho = joho.createBuilderForEdit().set厚労省IF識別コード(new Code(data.get厚労省IF識別コード())).build();
            サービスの状況List.add(joho);
        }
        if (!サービスの状況_09A.contains(GaikyoChosahyouServiceJyouk09A.認知症対応型通所介護.get連番())) {
            NinteichosahyoServiceJokyo joho = new NinteichosahyoServiceJokyo(new ShinseishoKanriNo(
                    data.get申請書管理番号()), data.get認定調査依頼履歴番号(),
                    getサービスの状況を変換(GaikyoChosahyouServiceJyouk09A.認知症対応型通所介護.get連番()));
            joho = joho.createBuilderForEdit().setサービスの状況(getサービスの状況を変換(data.get認知症対応型通所介護の日数())).build();
            joho = joho.createBuilderForEdit().set厚労省IF識別コード(new Code(data.get厚労省IF識別コード())).build();
            サービスの状況List.add(joho);
        }
        if (!サービスの状況_09A.contains(GaikyoChosahyouServiceJyouk09A.小規模多機能型居宅介護.get連番())) {
            NinteichosahyoServiceJokyo joho = new NinteichosahyoServiceJokyo(new ShinseishoKanriNo(
                    data.get申請書管理番号()), data.get認定調査依頼履歴番号(),
                    getサービスの状況を変換(GaikyoChosahyouServiceJyouk09A.小規模多機能型居宅介護.get連番()));
            joho = joho.createBuilderForEdit().setサービスの状況(getサービスの状況を変換(data.get小規模多機能型居宅介護の日数())).build();
            joho = joho.createBuilderForEdit().set厚労省IF識別コード(new Code(data.get厚労省IF識別コード())).build();
            サービスの状況List.add(joho);
        }
        if (!サービスの状況_09A.contains(GaikyoChosahyouServiceJyouk09A.地域密着型特定施設入居者生活介護.get連番())) {
            NinteichosahyoServiceJokyo joho = new NinteichosahyoServiceJokyo(new ShinseishoKanriNo(
                    data.get申請書管理番号()), data.get認定調査依頼履歴番号(),
                    getサービスの状況を変換(GaikyoChosahyouServiceJyouk09A.地域密着型特定施設入居者生活介護.get連番()));
            joho = joho.createBuilderForEdit().setサービスの状況(getサービスの状況を変換(data.get地域密着型特定施設入居者生活介護の日数())).build();
            joho = joho.createBuilderForEdit().set厚労省IF識別コード(new Code(data.get厚労省IF識別コード())).build();
            サービスの状況List.add(joho);
        }
        if (!サービスの状況_09A.contains(GaikyoChosahyouServiceJyouk09A.地域密着型介護老人福祉施設入所者生活介護.get連番())) {
            NinteichosahyoServiceJokyo joho = new NinteichosahyoServiceJokyo(new ShinseishoKanriNo(
                    data.get申請書管理番号()), data.get認定調査依頼履歴番号(),
                    getサービスの状況を変換(GaikyoChosahyouServiceJyouk09A.地域密着型介護老人福祉施設入所者生活介護.get連番()));
            joho = joho.createBuilderForEdit().setサービスの状況(getサービスの状況を変換(data.get地域密着型特定施設入居者生活介護の日数())).build();
            joho = joho.createBuilderForEdit().set厚労省IF識別コード(new Code(data.get厚労省IF識別コード())).build();
            サービスの状況List.add(joho);
        }
        return サービスの状況List;
    }

    private List<NinteichosahyoServiceJokyo> setDbT5207_09B(List<NinteichosahyoServiceJokyo> サービスの状況List, NinteiTorokuData data) {
        for (int i = 0; i < サービスの状況List.size(); i++) {
            NinteichosahyoServiceJokyo joho = サービスの状況List.get(i);
            if (GaikyoChosahyouServiceJyouk09B.訪問介護.get連番().equals(new RString(joho.get連番()))) {
                joho = joho.createBuilderForEdit().setサービスの状況(getサービスの状況を変換(data.get訪問介護_ﾎｰﾑﾍﾙﾌﾟｻｰﾋﾞｽの回数())).build();
                サービスの状況_09B.add(GaikyoChosahyouServiceJyouk09B.訪問介護.get連番());
                サービスの状況List.set(i, joho.modifiedModel());
            }
            if (GaikyoChosahyouServiceJyouk09B.訪問入浴介護.get連番().equals(new RString(joho.get連番()))) {
                joho = joho.createBuilderForEdit().setサービスの状況(getサービスの状況を変換(data.get訪問入浴介護の回数())).build();
                サービスの状況_09B.add(GaikyoChosahyouServiceJyouk09B.訪問入浴介護.get連番());
                サービスの状況List.set(i, joho.modifiedModel());
            }
            if (GaikyoChosahyouServiceJyouk09B.訪問看護.get連番().equals(new RString(joho.get連番()))) {
                joho = joho.createBuilderForEdit().setサービスの状況(getサービスの状況を変換(data.get訪問看護の回数())).build();
                サービスの状況_09B.add(GaikyoChosahyouServiceJyouk09B.訪問看護.get連番());
                サービスの状況List.set(i, joho.modifiedModel());
            }
            if (GaikyoChosahyouServiceJyouk09B.訪問リハビリ.get連番().equals(new RString(joho.get連番()))) {
                joho = joho.createBuilderForEdit().setサービスの状況(getサービスの状況を変換(data.get訪問ﾘﾊﾋﾞﾘﾃｰｼｮﾝの回数())).build();
                サービスの状況_09B.add(GaikyoChosahyouServiceJyouk09B.訪問リハビリ.get連番());
                サービスの状況List.set(i, joho.modifiedModel());
            }
            if (GaikyoChosahyouServiceJyouk09B.居宅療養管理指導.get連番().equals(new RString(joho.get連番()))) {
                joho = joho.createBuilderForEdit().setサービスの状況(getサービスの状況を変換(data.get居宅療養管理指導の回数())).build();
                サービスの状況_09B.add(GaikyoChosahyouServiceJyouk09B.居宅療養管理指導.get連番());
                サービスの状況List.set(i, joho.modifiedModel());
            }
            if (GaikyoChosahyouServiceJyouk09B.通所介護.get連番().equals(new RString(joho.get連番()))) {
                joho = joho.createBuilderForEdit().setサービスの状況(getサービスの状況を変換(data.get通所看護_ﾃﾞｲｻｰﾋﾞｽの回数())).build();
                サービスの状況_09B.add(GaikyoChosahyouServiceJyouk09B.通所介護.get連番());
                サービスの状況List.set(i, joho.modifiedModel());
            }
            if (GaikyoChosahyouServiceJyouk09B.通所リハビリ.get連番().equals(new RString(joho.get連番()))) {
                joho = joho.createBuilderForEdit().setサービスの状況(getサービスの状況を変換(data.get通所ﾘﾊﾋﾞﾘﾃｰｼｮﾝの回数())).build();
                サービスの状況_09B.add(GaikyoChosahyouServiceJyouk09B.通所リハビリ.get連番());
                サービスの状況List.set(i, joho.modifiedModel());
            }
            if (GaikyoChosahyouServiceJyouk09B.福祉用具貸与.get連番().equals(new RString(joho.get連番()))) {
                joho = joho.createBuilderForEdit().setサービスの状況(getサービスの状況を変換(data.get福祉用具貸与の品目())).build();
                サービスの状況_09B.add(GaikyoChosahyouServiceJyouk09B.福祉用具貸与.get連番());
                サービスの状況List.set(i, joho.modifiedModel());
            }
            if (GaikyoChosahyouServiceJyouk09B.短期入所生活介護.get連番().equals(new RString(joho.get連番()))) {
                joho = joho.createBuilderForEdit().setサービスの状況(getサービスの状況を変換(data.get短期入所生活介護の日数())).build();
                サービスの状況_09B.add(GaikyoChosahyouServiceJyouk09B.短期入所生活介護.get連番());
                サービスの状況List.set(i, joho.modifiedModel());
            }
            if (GaikyoChosahyouServiceJyouk09B.短期入所療養介護.get連番().equals(new RString(joho.get連番()))) {
                joho = joho.createBuilderForEdit().setサービスの状況(getサービスの状況を変換(data.get短期入所療養介護の日数())).build();
                サービスの状況_09B.add(GaikyoChosahyouServiceJyouk09B.短期入所療養介護.get連番());
                サービスの状況List.set(i, joho.modifiedModel());
            }
            if (GaikyoChosahyouServiceJyouk09B.認知症対応型共同生活介護.get連番().equals(new RString(joho.get連番()))) {
                joho = joho.createBuilderForEdit().setサービスの状況(getサービスの状況を変換(data.get認知症対応型共同生活介護の日数())).build();
                サービスの状況_09B.add(GaikyoChosahyouServiceJyouk09B.認知症対応型共同生活介護.get連番());
                サービスの状況List.set(i, joho.modifiedModel());
            }
            if (GaikyoChosahyouServiceJyouk09B.特定施設入所者生活介護.get連番().equals(new RString(joho.get連番()))) {
                joho = joho.createBuilderForEdit().setサービスの状況(getサービスの状況を変換(data.get特定施設入所者生活介護の日数())).build();
                サービスの状況_09B.add(GaikyoChosahyouServiceJyouk09B.特定施設入所者生活介護.get連番());
                サービスの状況List.set(i, joho.modifiedModel());
            }
            if (GaikyoChosahyouServiceJyouk09B.福祉用具購入.get連番().equals(new RString(joho.get連番()))) {
                joho = joho.createBuilderForEdit().setサービスの状況(getサービスの状況を変換(data.get福祉用具購入の品目())).build();
                サービスの状況_09B.add(GaikyoChosahyouServiceJyouk09B.福祉用具購入.get連番());
                サービスの状況List.set(i, joho.modifiedModel());
            }
            if (GaikyoChosahyouServiceJyouk09B.夜間対応型訪問介護.get連番().equals(new RString(joho.get連番()))) {
                joho = joho.createBuilderForEdit().setサービスの状況(getサービスの状況を変換(data.get夜間対応型訪問介護の日数())).build();
                サービスの状況_09B.add(GaikyoChosahyouServiceJyouk09B.夜間対応型訪問介護.get連番());
                サービスの状況List.set(i, joho.modifiedModel());
            }
            if (GaikyoChosahyouServiceJyouk09B.認知症対応型通所介護.get連番().equals(new RString(joho.get連番()))) {
                joho = joho.createBuilderForEdit().setサービスの状況(getサービスの状況を変換(data.get認知症対応型通所介護の日数())).build();
                サービスの状況_09B.add(GaikyoChosahyouServiceJyouk09B.認知症対応型通所介護.get連番());
                サービスの状況List.set(i, joho.modifiedModel());
            }
            if (GaikyoChosahyouServiceJyouk09B.小規模多機能型居宅介護.get連番().equals(new RString(joho.get連番()))) {
                joho = joho.createBuilderForEdit().setサービスの状況(getサービスの状況を変換(data.get小規模多機能型居宅介護の日数())).build();
                サービスの状況_09B.add(GaikyoChosahyouServiceJyouk09B.小規模多機能型居宅介護.get連番());
                サービスの状況List.set(i, joho.modifiedModel());
            }
            if (GaikyoChosahyouServiceJyouk09B.地域密着型特定施設入居者生活介護.get連番().equals(new RString(joho.get連番()))) {
                joho = joho.createBuilderForEdit().setサービスの状況(getサービスの状況を変換(data.get地域密着型特定施設入居者生活介護の日数())).build();
                サービスの状況_09B.add(GaikyoChosahyouServiceJyouk09B.地域密着型特定施設入居者生活介護.get連番());
                サービスの状況List.set(i, joho.modifiedModel());
            }
            サービスの状況List.set(i, setDbT5207_09B_bak(joho, data));
        }
        return サービスの状況List;
    }

    private NinteichosahyoServiceJokyo setDbT5207_09B_bak(NinteichosahyoServiceJokyo joho, NinteiTorokuData data) {
        if (GaikyoChosahyouServiceJyouk09B.地域密着型介護老人福祉施設入所者生活介護.get連番().equals(new RString(joho.get連番()))) {
            joho = joho.createBuilderForEdit().setサービスの状況(getサービスの状況を変換(data.
                    get地域密着型特定施設入居者生活介護の日数())).build().modifiedModel();
            サービスの状況_09B.add(GaikyoChosahyouServiceJyouk09B.地域密着型介護老人福祉施設入所者生活介護.get連番());
        }
        if (GaikyoChosahyouServiceJyouk09B.定期巡回_随時対応型訪問介護看護.get連番().equals(new RString(joho.get連番()))) {
            joho = joho.createBuilderForEdit().setサービスの状況(getサービスの状況を変換(data.
                    get定期巡回_随時対応型訪問介護看護())).build().modifiedModel();
            サービスの状況_09B.add(GaikyoChosahyouServiceJyouk09B.定期巡回_随時対応型訪問介護看護.get連番());
        }
        if (GaikyoChosahyouServiceJyouk09B.看護小規模多機能型居宅介護.get連番().equals(new RString(joho.get連番()))) {
            joho = joho.createBuilderForEdit().setサービスの状況(getサービスの状況を変換(data.get看護小規模多機能型居宅介護())).build().modifiedModel();
            サービスの状況_09B.add(GaikyoChosahyouServiceJyouk09B.看護小規模多機能型居宅介護.get連番());
        }
        return joho;
    }

    private List<NinteichosahyoServiceJokyo> set新規サービスの状況_09B(List<NinteichosahyoServiceJokyo> サービスの状況List, NinteiTorokuData data) {
        if (!サービスの状況_09B.contains(GaikyoChosahyouServiceJyouk09B.訪問介護.get連番())) {
            NinteichosahyoServiceJokyo joho = new NinteichosahyoServiceJokyo(new ShinseishoKanriNo(
                    data.get申請書管理番号()), data.get認定調査依頼履歴番号(),
                    getサービスの状況を変換(GaikyoChosahyouServiceJyouk09B.訪問介護.get連番()));
            joho = joho.createBuilderForEdit().setサービスの状況(getサービスの状況を変換(data.get訪問介護_ﾎｰﾑﾍﾙﾌﾟｻｰﾋﾞｽの回数())).build();
            joho = joho.createBuilderForEdit().set厚労省IF識別コード(new Code(data.get厚労省IF識別コード())).build();
            サービスの状況List.add(joho);
        }
        if (!サービスの状況_09B.contains(GaikyoChosahyouServiceJyouk09B.訪問入浴介護.get連番())) {
            NinteichosahyoServiceJokyo joho = new NinteichosahyoServiceJokyo(new ShinseishoKanriNo(
                    data.get申請書管理番号()), data.get認定調査依頼履歴番号(),
                    getサービスの状況を変換(GaikyoChosahyouServiceJyouk09B.訪問入浴介護.get連番()));
            joho = joho.createBuilderForEdit().setサービスの状況(getサービスの状況を変換(data.get訪問入浴介護の回数())).build();
            joho = joho.createBuilderForEdit().set厚労省IF識別コード(new Code(data.get厚労省IF識別コード())).build();
            サービスの状況List.add(joho);
        }
        if (!サービスの状況_09B.contains(GaikyoChosahyouServiceJyouk09B.訪問看護.get連番())) {
            NinteichosahyoServiceJokyo joho = new NinteichosahyoServiceJokyo(new ShinseishoKanriNo(
                    data.get申請書管理番号()), data.get認定調査依頼履歴番号(),
                    getサービスの状況を変換(GaikyoChosahyouServiceJyouk09B.訪問看護.get連番()));
            joho = joho.createBuilderForEdit().setサービスの状況(getサービスの状況を変換(data.get訪問介護_ﾎｰﾑﾍﾙﾌﾟｻｰﾋﾞｽの回数())).build();
            joho = joho.createBuilderForEdit().set厚労省IF識別コード(new Code(data.get厚労省IF識別コード())).build();
            サービスの状況List.add(joho);
        }
        if (!サービスの状況_09B.contains(GaikyoChosahyouServiceJyouk09B.訪問リハビリ.get連番())) {
            NinteichosahyoServiceJokyo joho = new NinteichosahyoServiceJokyo(new ShinseishoKanriNo(
                    data.get申請書管理番号()), data.get認定調査依頼履歴番号(),
                    getサービスの状況を変換(GaikyoChosahyouServiceJyouk09B.訪問リハビリ.get連番()));
            joho = joho.createBuilderForEdit().setサービスの状況(getサービスの状況を変換(data.get訪問ﾘﾊﾋﾞﾘﾃｰｼｮﾝの回数())).build();
            joho = joho.createBuilderForEdit().set厚労省IF識別コード(new Code(data.get厚労省IF識別コード())).build();
            サービスの状況List.add(joho);
        }
        if (!サービスの状況_09B.contains(GaikyoChosahyouServiceJyouk09B.居宅療養管理指導.get連番())) {
            NinteichosahyoServiceJokyo joho = new NinteichosahyoServiceJokyo(new ShinseishoKanriNo(
                    data.get申請書管理番号()), data.get認定調査依頼履歴番号(),
                    getサービスの状況を変換(GaikyoChosahyouServiceJyouk09B.居宅療養管理指導.get連番()));
            joho = joho.createBuilderForEdit().setサービスの状況(getサービスの状況を変換(data.get居宅療養管理指導の回数())).build();
            joho = joho.createBuilderForEdit().set厚労省IF識別コード(new Code(data.get厚労省IF識別コード())).build();
            サービスの状況List.add(joho);
        }
        if (!サービスの状況_09B.contains(GaikyoChosahyouServiceJyouk09B.通所介護.get連番())) {
            NinteichosahyoServiceJokyo joho = new NinteichosahyoServiceJokyo(new ShinseishoKanriNo(
                    data.get申請書管理番号()), data.get認定調査依頼履歴番号(),
                    getサービスの状況を変換(GaikyoChosahyouServiceJyouk09B.通所介護.get連番()));
            joho = joho.createBuilderForEdit().setサービスの状況(getサービスの状況を変換(data.get通所看護_ﾃﾞｲｻｰﾋﾞｽの回数())).build();
            joho = joho.createBuilderForEdit().set厚労省IF識別コード(new Code(data.get厚労省IF識別コード())).build();
            サービスの状況List.add(joho);
        }
        if (!サービスの状況_09B.contains(GaikyoChosahyouServiceJyouk09B.通所リハビリ.get連番())) {
            NinteichosahyoServiceJokyo joho = new NinteichosahyoServiceJokyo(new ShinseishoKanriNo(
                    data.get申請書管理番号()), data.get認定調査依頼履歴番号(),
                    getサービスの状況を変換(GaikyoChosahyouServiceJyouk09B.通所リハビリ.get連番()));
            joho = joho.createBuilderForEdit().setサービスの状況(getサービスの状況を変換(data.get通所ﾘﾊﾋﾞﾘﾃｰｼｮﾝの回数())).build();
            joho = joho.createBuilderForEdit().set厚労省IF識別コード(new Code(data.get厚労省IF識別コード())).build();
            サービスの状況List.add(joho);
        }
        if (!サービスの状況_09B.contains(GaikyoChosahyouServiceJyouk09B.福祉用具貸与.get連番())) {
            NinteichosahyoServiceJokyo joho = new NinteichosahyoServiceJokyo(new ShinseishoKanriNo(
                    data.get申請書管理番号()), data.get認定調査依頼履歴番号(),
                    getサービスの状況を変換(GaikyoChosahyouServiceJyouk09B.福祉用具貸与.get連番()));
            joho = joho.createBuilderForEdit().setサービスの状況(getサービスの状況を変換(data.get福祉用具貸与の品目())).build();
            joho = joho.createBuilderForEdit().set厚労省IF識別コード(new Code(data.get厚労省IF識別コード())).build();
            サービスの状況List.add(joho);
        }
        if (!サービスの状況_09B.contains(GaikyoChosahyouServiceJyouk09B.短期入所生活介護.get連番())) {
            NinteichosahyoServiceJokyo joho = new NinteichosahyoServiceJokyo(new ShinseishoKanriNo(
                    data.get申請書管理番号()), data.get認定調査依頼履歴番号(),
                    getサービスの状況を変換(GaikyoChosahyouServiceJyouk09B.短期入所生活介護.get連番()));
            joho = joho.createBuilderForEdit().setサービスの状況(getサービスの状況を変換(data.get短期入所生活介護の日数())).build();
            joho = joho.createBuilderForEdit().set厚労省IF識別コード(new Code(data.get厚労省IF識別コード())).build();
            サービスの状況List.add(joho);
        }
        if (!サービスの状況_09B.contains(GaikyoChosahyouServiceJyouk09B.短期入所療養介護.get連番())) {
            NinteichosahyoServiceJokyo joho = new NinteichosahyoServiceJokyo(new ShinseishoKanriNo(
                    data.get申請書管理番号()), data.get認定調査依頼履歴番号(),
                    getサービスの状況を変換(GaikyoChosahyouServiceJyouk09B.短期入所療養介護.get連番()));
            joho = joho.createBuilderForEdit().setサービスの状況(getサービスの状況を変換(data.get短期入所療養介護の日数())).build();
            joho = joho.createBuilderForEdit().set厚労省IF識別コード(new Code(data.get厚労省IF識別コード())).build();
            サービスの状況List.add(joho);
        }
        if (!サービスの状況_09B.contains(GaikyoChosahyouServiceJyouk09B.認知症対応型共同生活介護.get連番())) {
            NinteichosahyoServiceJokyo joho = new NinteichosahyoServiceJokyo(new ShinseishoKanriNo(
                    data.get申請書管理番号()), data.get認定調査依頼履歴番号(),
                    getサービスの状況を変換(GaikyoChosahyouServiceJyouk09B.認知症対応型共同生活介護.get連番()));
            joho = joho.createBuilderForEdit().setサービスの状況(getサービスの状況を変換(data.get認知症対応型共同生活介護の日数())).build();
            joho = joho.createBuilderForEdit().set厚労省IF識別コード(new Code(data.get厚労省IF識別コード())).build();
            サービスの状況List.add(joho);
        }
        if (!サービスの状況_09B.contains(GaikyoChosahyouServiceJyouk09B.特定施設入所者生活介護.get連番())) {
            NinteichosahyoServiceJokyo joho = new NinteichosahyoServiceJokyo(new ShinseishoKanriNo(
                    data.get申請書管理番号()), data.get認定調査依頼履歴番号(),
                    getサービスの状況を変換(GaikyoChosahyouServiceJyouk09B.特定施設入所者生活介護.get連番()));
            joho = joho.createBuilderForEdit().setサービスの状況(getサービスの状況を変換(data.get特定施設入所者生活介護の日数())).build();
            joho = joho.createBuilderForEdit().set厚労省IF識別コード(new Code(data.get厚労省IF識別コード())).build();
            サービスの状況List.add(joho);
        }
        if (!サービスの状況_09B.contains(GaikyoChosahyouServiceJyouk09B.福祉用具購入.get連番())) {
            NinteichosahyoServiceJokyo joho = new NinteichosahyoServiceJokyo(new ShinseishoKanriNo(
                    data.get申請書管理番号()), data.get認定調査依頼履歴番号(),
                    getサービスの状況を変換(GaikyoChosahyouServiceJyouk09B.福祉用具購入.get連番()));
            joho = joho.createBuilderForEdit().setサービスの状況(getサービスの状況を変換(data.get福祉用具購入の品目())).build();
            joho = joho.createBuilderForEdit().set厚労省IF識別コード(new Code(data.get厚労省IF識別コード())).build();
            サービスの状況List.add(joho);
        }
        if (!サービスの状況_09B.contains(GaikyoChosahyouServiceJyouk09B.夜間対応型訪問介護.get連番())) {
            NinteichosahyoServiceJokyo joho = new NinteichosahyoServiceJokyo(new ShinseishoKanriNo(
                    data.get申請書管理番号()), data.get認定調査依頼履歴番号(),
                    getサービスの状況を変換(GaikyoChosahyouServiceJyouk09B.夜間対応型訪問介護.get連番()));
            joho = joho.createBuilderForEdit().setサービスの状況(getサービスの状況を変換(data.get夜間対応型訪問介護の日数())).build();
            joho = joho.createBuilderForEdit().set厚労省IF識別コード(new Code(data.get厚労省IF識別コード())).build();
            サービスの状況List.add(joho);
        }
        if (!サービスの状況_09B.contains(GaikyoChosahyouServiceJyouk09B.認知症対応型通所介護.get連番())) {
            NinteichosahyoServiceJokyo joho = new NinteichosahyoServiceJokyo(new ShinseishoKanriNo(
                    data.get申請書管理番号()), data.get認定調査依頼履歴番号(),
                    getサービスの状況を変換(GaikyoChosahyouServiceJyouk09B.認知症対応型通所介護.get連番()));
            joho = joho.createBuilderForEdit().setサービスの状況(getサービスの状況を変換(data.get認知症対応型通所介護の日数())).build();
            joho = joho.createBuilderForEdit().set厚労省IF識別コード(new Code(data.get厚労省IF識別コード())).build();
            サービスの状況List.add(joho);
        }
        if (!サービスの状況_09B.contains(GaikyoChosahyouServiceJyouk09B.小規模多機能型居宅介護.get連番())) {
            NinteichosahyoServiceJokyo joho = new NinteichosahyoServiceJokyo(new ShinseishoKanriNo(
                    data.get申請書管理番号()), data.get認定調査依頼履歴番号(),
                    getサービスの状況を変換(GaikyoChosahyouServiceJyouk09B.小規模多機能型居宅介護.get連番()));
            joho = joho.createBuilderForEdit().setサービスの状況(getサービスの状況を変換(data.get小規模多機能型居宅介護の日数())).build();
            joho = joho.createBuilderForEdit().set厚労省IF識別コード(new Code(data.get厚労省IF識別コード())).build();
            サービスの状況List.add(joho);
        }
        if (!サービスの状況_09B.contains(GaikyoChosahyouServiceJyouk09B.地域密着型特定施設入居者生活介護.get連番())) {
            NinteichosahyoServiceJokyo joho = new NinteichosahyoServiceJokyo(new ShinseishoKanriNo(
                    data.get申請書管理番号()), data.get認定調査依頼履歴番号(),
                    getサービスの状況を変換(GaikyoChosahyouServiceJyouk09B.地域密着型特定施設入居者生活介護.get連番()));
            joho = joho.createBuilderForEdit().setサービスの状況(getサービスの状況を変換(data.get地域密着型特定施設入居者生活介護の日数())).build();
            joho = joho.createBuilderForEdit().set厚労省IF識別コード(new Code(data.get厚労省IF識別コード())).build();
            サービスの状況List.add(joho);
        }
        if (!サービスの状況_09B.contains(GaikyoChosahyouServiceJyouk09B.地域密着型介護老人福祉施設入所者生活介護.get連番())) {
            NinteichosahyoServiceJokyo joho = new NinteichosahyoServiceJokyo(new ShinseishoKanriNo(
                    data.get申請書管理番号()), data.get認定調査依頼履歴番号(),
                    getサービスの状況を変換(GaikyoChosahyouServiceJyouk09B.地域密着型介護老人福祉施設入所者生活介護.get連番()));
            joho = joho.createBuilderForEdit().setサービスの状況(getサービスの状況を変換(data.get地域密着型特定施設入居者生活介護の日数())).build();
            joho = joho.createBuilderForEdit().set厚労省IF識別コード(new Code(data.get厚労省IF識別コード())).build();
            サービスの状況List.add(joho);
        }
        return set新規サービスの状況_09B_Bak(サービスの状況List, data);
    }

    private List<NinteichosahyoServiceJokyo> set新規サービスの状況_09B_Bak(List<NinteichosahyoServiceJokyo> サービスの状況List, NinteiTorokuData data) {
        if (!サービスの状況_09B.contains(GaikyoChosahyouServiceJyouk09B.定期巡回_随時対応型訪問介護看護.get連番())) {
            NinteichosahyoServiceJokyo joho = new NinteichosahyoServiceJokyo(new ShinseishoKanriNo(
                    data.get申請書管理番号()), data.get認定調査依頼履歴番号(),
                    getサービスの状況を変換(GaikyoChosahyouServiceJyouk09B.定期巡回_随時対応型訪問介護看護.get連番()));
            joho = joho.createBuilderForEdit().setサービスの状況(getサービスの状況を変換(data.get定期巡回_随時対応型訪問介護看護())).build();
            joho = joho.createBuilderForEdit().set厚労省IF識別コード(new Code(data.get厚労省IF識別コード())).build();
            サービスの状況List.add(joho);
        }
        if (!サービスの状況_09B.contains(GaikyoChosahyouServiceJyouk09B.看護小規模多機能型居宅介護.get連番())) {
            NinteichosahyoServiceJokyo joho = new NinteichosahyoServiceJokyo(new ShinseishoKanriNo(
                    data.get申請書管理番号()), data.get認定調査依頼履歴番号(),
                    getサービスの状況を変換(GaikyoChosahyouServiceJyouk09B.看護小規模多機能型居宅介護.get連番()));
            joho = joho.createBuilderForEdit().setサービスの状況(getサービスの状況を変換(data.get看護小規模多機能型居宅介護())).build();
            joho = joho.createBuilderForEdit().set厚労省IF識別コード(new Code(data.get厚労省IF識別コード())).build();
            サービスの状況List.add(joho);
        }
        return サービスの状況List;
    }

    private int getサービスの状況を変換(RString サービスの状況_TMP) {
        return Integer.parseInt(サービスの状況_TMP.toString());
    }

    private RString dateFormat(RString date) {
        if (RString.isNullOrEmpty(date)) {
            return 空白;
        }
        return new RDate(date.toString()).wareki().toDateString();
    }

    private List<NinteiTorokuData> getCSVファイル() {
        RString imagePath = Path.combinePath(Path.getRootPath(空白), DbBusinessConfig
                .get(ConfigNameDBE.OCRアップロード用ファイル格納パス, RDate.getNowDate(), SubGyomuCode.DBE認定支援));
        RString csvReaderPath = Path.combinePath(imagePath, ファイル名);
        CsvReader csvReader = new CsvReader.InstanceBuilder(csvReaderPath, NinteiTorokuData.class)
                .setDelimiter(CSV_WRITER_DELIMITER).setEncode(Encode.UTF_8)
                .hasHeader(false).setNewLine(NewLine.CRLF).build();
        return readCsvFile(csvReader, csvReaderPath);
    }

    private List<NinteiTorokuData> readCsvFile(CsvReader csvReader, RString csvReaderPath) {
        CsvListReader read = new CsvListReader.InstanceBuilder(csvReaderPath).build();
        List<NinteiTorokuData> csvEntityList = new ArrayList<>();
        while (true) {
            NinteiTorokuData entity = (NinteiTorokuData) csvReader.readLine();
            if (entity != null) {
                entity.set項目数(read.readLine().size());
                csvEntityList.add(entity);
            } else {
                break;
            }
        }
        csvReader.close();
        read.close();
        return csvEntityList;
    }
}
