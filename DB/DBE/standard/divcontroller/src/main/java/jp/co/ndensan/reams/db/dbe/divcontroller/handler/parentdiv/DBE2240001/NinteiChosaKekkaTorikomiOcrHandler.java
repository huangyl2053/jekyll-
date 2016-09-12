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

    /**
     * DB更新用データの設定します。
     *
     * @param csvData csvData
     * @return NinteiTorokuData
     */
    public NinteiTorokuData setDB更新用データ(NinteiTorokuData csvData) {
        NinteiTorokuData data = new NinteiTorokuData();
        data.setOK_NG(csvData.getOK_NG());
        data.set保険者番号(csvData.get保険者番号());
        data.set申請日(csvData.get申請日());
        data.set被保険者番号(csvData.get被保険者番号());
        data.set実施日時(csvData.get実施日時());
        data.set実施場所コード(csvData.get実施場所コード());
        data.set記入者氏名_コード(csvData.get記入者氏名_コード());
        data.set所属機関_コード(csvData.get所属機関_コード());
        data.set現在のサービス区分コード(csvData.get現在のサービス区分コード());
        data.set訪問介護_ﾎｰﾑﾍﾙﾌﾟｻｰﾋﾞｽの回数(csvData.get訪問介護_ﾎｰﾑﾍﾙﾌﾟｻｰﾋﾞｽの回数());
        data.set訪問入浴介護の回数(csvData.get訪問入浴介護の回数());
        data.set訪問看護の回数(csvData.get訪問看護の回数());
        data.set訪問ﾘﾊﾋﾞﾘﾃｰｼｮﾝの回数(csvData.get訪問ﾘﾊﾋﾞﾘﾃｰｼｮﾝの回数());
        data.set居宅療養管理指導の回数(csvData.get居宅療養管理指導の回数());
        data.set通所看護_ﾃﾞｲｻｰﾋﾞｽの回数(csvData.get通所看護_ﾃﾞｲｻｰﾋﾞｽの回数());
        data.set通所ﾘﾊﾋﾞﾘﾃｰｼｮﾝの回数(csvData.get通所ﾘﾊﾋﾞﾘﾃｰｼｮﾝの回数());
        data.set短期入所生活介護の日数(csvData.get短期入所生活介護の日数());
        data.set短期入所療養介護の日数(csvData.get短期入所療養介護の日数());
        data.set特定施設入所者生活介護の日数(csvData.get特定施設入所者生活介護の日数());
        data.set福祉用具貸与の品目(csvData.get福祉用具貸与の品目());
        data.set福祉用具購入の品目(csvData.get福祉用具購入の品目());
        data.set住宅改修のあり_なし(csvData.get住宅改修のあり_なし());
        data.set夜間対応型訪問介護の日数(csvData.get夜間対応型訪問介護の日数());
        data.set認知症対応型通所介護の日数(csvData.get認知症対応型通所介護の日数());
        data.set小規模多機能型居宅介護の日数(csvData.get小規模多機能型居宅介護の日数());
        data.set認知症対応型共同生活介護の日数(csvData.get認知症対応型共同生活介護の日数());
        data.set地域密着型特定施設入居者生活介護の日数(csvData.get地域密着型特定施設入居者生活介護の日数());
        data.set地域密着型介護老人福祉施設入居者生活介護の日数(csvData.get地域密着型介護老人福祉施設入居者生活介護の日数());
        data.set看護小規模多機能型居宅介護(csvData.get看護小規模多機能型居宅介護());
        data.set定期巡回_随時対応型訪問介護看護(csvData.get定期巡回_随時対応型訪問介護看護());
        data.set施設利用の有無(csvData.get施設利用の有無());
        data.set麻痺_ない(csvData.get麻痺_ない());
        data.set麻痺_左上肢(csvData.get麻痺_左上肢());
        data.set麻痺_右上肢(csvData.get麻痺_右上肢());
        data.set麻痺_左下肢(csvData.get麻痺_左下肢());
        data.set麻痺_右下肢(csvData.get麻痺_右下肢());
        data.set麻痺_その他(csvData.get麻痺_その他());
        data.set拘縮_ない(csvData.get拘縮_ない());
        data.set拘縮_肩関節(csvData.get拘縮_肩関節());
        data.set拘縮_股関節(csvData.get拘縮_股関節());
        data.set拘縮_膝関節(csvData.get拘縮_膝関節());
        data.set拘縮_その他(csvData.get拘縮_その他());
        data.set寝返り(csvData.get寝返り());
        data.set起き上がり(csvData.get起き上がり());
        data.set座位保持(csvData.get座位保持());
        data.set両足での立位(csvData.get両足での立位());
        data.set歩行(csvData.get歩行());
        data.set立ち上がり(csvData.get立ち上がり());
        data.set片足での立位(csvData.get片足での立位());
        data.set洗身(csvData.get洗身());
        data.setつめ切り(csvData.getつめ切り());
        data.set視力(csvData.get視力());
        data.set聴力(csvData.get聴力());
        data.set移乗(csvData.get移乗());
        data.set移動(csvData.get移動());
        data.setえん下(csvData.getえん下());
        data.set食事摂取(csvData.get食事摂取());
        data.set排尿(csvData.get排尿());
        data.set排便(csvData.get排便());
        data.set口腔清潔(csvData.get口腔清潔());
        data.set洗顔(csvData.get洗顔());
        data.set整髪(csvData.get整髪());
        data.set上衣の着脱(csvData.get上衣の着脱());
        data.setズボン等の着脱(csvData.getズボン等の着脱());
        data.set外出頻度(csvData.get外出頻度());
        data.set意思の疎通(csvData.get意思の疎通());
        data.set毎日の日課を理解(csvData.get毎日の日課を理解());
        data.set生年月日をいう(csvData.get生年月日をいう());
        data.set短期記憶(csvData.get短期記憶());
        data.set自分の名前をいう(csvData.get自分の名前をいう());
        data.set今の季節を理解(csvData.get今の季節を理解());
        data.set場所の理解(csvData.get場所の理解());
        data.set徘徊(csvData.get徘徊());
        data.set外出して戻れない(csvData.get外出して戻れない());
        data.set被害的(csvData.get被害的());
        data.set作話(csvData.get作話());
        data.set感情が不安定(csvData.get感情が不安定());
        data.set昼夜逆転(csvData.get昼夜逆転());
        data.set同じ話をする(csvData.get同じ話をする());
        data.set大声を出す(csvData.get大声を出す());
        data.set介護に抵抗(csvData.get介護に抵抗());
        data.set落ち着きなし(csvData.get落ち着きなし());
        data.set一人で出たがる(csvData.get一人で出たがる());
        data.set収集癖(csvData.get収集癖());
        data.set物や衣類を壊す(csvData.get物や衣類を壊す());
        data.setひどい物忘れ(csvData.getひどい物忘れ());
        data.set独り言_独り笑い(csvData.get独り言_独り笑い());
        data.set自分勝手に行動する(csvData.get自分勝手に行動する());
        data.set話がまとまらない(csvData.get話がまとまらない());
        data.set薬の内服(csvData.get薬の内服());
        data.set金銭の管理(csvData.get金銭の管理());
        data.set日常の意思決定(csvData.get日常の意思決定());
        data.set集団への不適応(csvData.get集団への不適応());
        data.set買い物(csvData.get買い物());
        data.set簡単な調理(csvData.get簡単な調理());
        data.set過去14日間に受けた治療_点滴の管理(csvData.get過去14日間に受けた治療_点滴の管理());
        data.set過去14日間に受けた治療_中心静脈栄養(csvData.get過去14日間に受けた治療_中心静脈栄養());
        data.set過去14日間に受けた治療_透折(csvData.get過去14日間に受けた治療_透折());
        data.set過去14日間に受けた治療_ストーマの処理(csvData.get過去14日間に受けた治療_ストーマの処理());
        data.set過去14日間に受けた治療_酸素療法(csvData.get過去14日間に受けた治療_酸素療法());
        data.set過去14日間に受けた治療_レスピレーター(csvData.get過去14日間に受けた治療_レスピレーター());
        data.set過去14日間に受けた治療_気管切開の処理(csvData.get過去14日間に受けた治療_気管切開の処理());
        data.set過去14日間に受けた治療_疼痛(csvData.get過去14日間に受けた治療_疼痛());
        data.set過去14日間に受けた治療_経管栄養(csvData.get過去14日間に受けた治療_経管栄養());
        data.set過去14日間に受けた治療_モニター測定(csvData.get過去14日間に受けた治療_モニター測定());
        data.set過去14日間に受けた治療_じょくそうの処置(csvData.get過去14日間に受けた治療_じょくそうの処置());
        data.set過去14日間に受けた治療_カテーテル(csvData.get過去14日間に受けた治療_カテーテル());
        data.set障害高齢者の日常生活自立度_寝たきり度(csvData.get障害高齢者の日常生活自立度_寝たきり度());
        data.set認知症高齢者の日常生活自立度(csvData.get認知症高齢者の日常生活自立度());
        data.set番号(csvData.get番号());
        return data;
    }
}
