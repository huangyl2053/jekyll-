/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.ninteichosadataoutput;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.processprm.ninteichosadataoutput.NinteiChosaDataOutputProcessParamter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.ninteichosadataoutput.NinteiChosaDataOutputBatchRelateEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.ninteichosadataoutput.NinteiChosaDataOutputEucCsvEntity;
import jp.co.ndensan.reams.db.dbz.definition.core.ninteichosahyou.NinteichosaKomokuMapping02A;
import jp.co.ndensan.reams.db.dbz.definition.core.ninteichosahyou.NinteichosaKomokuMapping06A;
import jp.co.ndensan.reams.db.dbz.definition.core.ninteichosahyou.NinteichosaKomokuMapping09A;
import jp.co.ndensan.reams.db.dbz.definition.core.ninteichosahyou.NinteichosaKomokuMapping09B;
import jp.co.ndensan.reams.db.dbz.definition.core.ninteichosahyou.NinteichosaKomokuMapping99A;
import jp.co.ndensan.reams.db.dbz.definition.core.seibetsu.Seibetsu;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.GenponMaskKubun;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.KoroshoIfShikibetsuCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ChosaJisshiBashoCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.NinchishoNichijoSeikatsuJiritsudoCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.NinteiChousaIraiKubunCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ServiceKubunCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ShogaiNichijoSeikatsuJiritsudoCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.TokkijikoTextImageKubun;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.NinteiShinseiShinseijiKubunCode;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogType;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogger;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.ExpandedInformation;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.PersonalData;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.editor.DecimalFormatter;

/**
 * 認定調査データ出力（モバイル）CSVEntity設定のビジネスです。
 *
 * @reamsid_L DBE-1860-011 duanzhanli
 */
public class NinteiChosaDataOutputResult {

    /**
     * EucCsvEntityの設定メッソドです。
     *
     * @param entity entity
     * @return NinteiChosaDataOutputEucCsvEntity
     */
    public NinteiChosaDataOutputEucCsvEntity setEucCsvEntity(NinteiChosaDataOutputBatchRelateEntity entity) {
        NinteiChosaDataOutputEucCsvEntity eucCsvEntity = new NinteiChosaDataOutputEucCsvEntity();
        eucCsvEntity.set申請書管理番号(entity.get申請書管理番号());
        eucCsvEntity.set厚労省IF識別コード(entity.get厚労省IF識別コード());
        eucCsvEntity.set厚労省認定ソフトのバージョン(KoroshoIfShikibetsuCode.toValue(entity.get厚労省IF識別コード()).get名称());
        eucCsvEntity.set証記載保険者番号(entity.get証記載保険者番号());
        eucCsvEntity.set被保険者番号(entity.get被保険者番号());
        eucCsvEntity.set認定申請年月日(setDateFormat(entity.get認定申請年月日()));
        eucCsvEntity.set認定申請区分_申請時_コード(entity.get認定申請区分_申請時_コード());
        eucCsvEntity.set認定申請区分申請時(NinteiShinseiShinseijiKubunCode.toValue(entity.get認定申請区分_申請時_コード()).get名称());
        eucCsvEntity.set被保険者氏名(entity.get被保険者氏名());
        eucCsvEntity.set被保険者氏名カナ(entity.get被保険者氏名カナ());
        eucCsvEntity.set生年月日(setDateFormat(entity.get生年月日()));
        eucCsvEntity.set年齢(entity.get年齢());
        eucCsvEntity.set性別(Seibetsu.toValue(entity.get性別()).get名称());
        eucCsvEntity.set郵便番号(setYobuinNoFormat(entity.get郵便番号()));
        eucCsvEntity.set住所(entity.get住所());
        eucCsvEntity.set電話番号(entity.get電話番号());
        eucCsvEntity.set保険者名(entity.get市町村名称());
        eucCsvEntity.set認定調査依頼完了年月日(setDateFormat(entity.get認定調査依頼完了年月日()));
        eucCsvEntity.set認定調査依頼履歴番号(entity.get認定調査依頼履歴番号());
        eucCsvEntity.set認定調査委託先コード(entity.get認定調査委託先コード());
        eucCsvEntity.set調査委託先(entity.get事業者名称());
        eucCsvEntity.set認定調査員コード(entity.get認定調査員コード());
        eucCsvEntity.set調査員氏名(entity.get調査員氏名());
        eucCsvEntity.setイメージ区分コード(entity.getイメージ区分());
        eucCsvEntity.setイメージ区分(TokkijikoTextImageKubun.toValue(entity.getイメージ区分()).get名称());
        eucCsvEntity.set認定調査依頼区分コード(entity.get認定調査依頼区分コード());
        eucCsvEntity.set認定調査依頼区分(NinteiChousaIraiKubunCode.toValue(entity.get認定調査依頼区分コード()).get名称());
        eucCsvEntity.set認定調査回数(entity.get認定調査回数());
        eucCsvEntity.set認定調査実施年月日(setDateFormat(entity.get認定調査実施年月日()));
        eucCsvEntity.set認定調査受領年月日(setDateFormat(entity.get認定調査受領年月日()));
        eucCsvEntity.set認定調査区分コード(entity.get認定調査区分コード());
        eucCsvEntity.set認定調査区分(NinteiChousaIraiKubunCode.toValue(entity.get認定調査区分コード()).get名称());
        eucCsvEntity.set認定調査実施場所コード(entity.get認定調査実施場所コード());
        eucCsvEntity.set認定調査実施場所(ChosaJisshiBashoCode.toValue(entity.get認定調査実施場所コード()).get名称());
        eucCsvEntity.set認定調査実施場所名称(entity.get認定調査実施場所名称());
        eucCsvEntity.setサービス区分コード(entity.getサービス区分コード());
        eucCsvEntity.setサービス区分(ServiceKubunCode.toValue(entity.getサービス区分コード()).get名称());
        eucCsvEntity.set利用施設名(entity.get利用施設名());
        eucCsvEntity.set利用施設住所(entity.get利用施設住所());
        eucCsvEntity.set利用施設電話番号(entity.get利用施設電話番号());
        eucCsvEntity.set利用施設郵便番号(setYobuinNoFormat(entity.get利用施設郵便番号()));
        eucCsvEntity.set特記(entity.get特記());
        eucCsvEntity.set認定調査特記事項受付年月日(setDateFormat(entity.get認定調査特記事項受付年月日()));
        eucCsvEntity.set認定調査特記事項受領年月日(setDateFormat(entity.get認定調査特記事項受領年月日()));
        eucCsvEntity.set住宅改修(entity.get住宅改修());
        eucCsvEntity.set市町村特別給付サービス種類名(entity.get市町村特別給付サービス種類名());
        eucCsvEntity.set在宅サービス種類名(entity.get在宅サービス種類名());
        eucCsvEntity.set主訴(entity.get主訴());
        eucCsvEntity.set家族状況(entity.get家族状況());
        eucCsvEntity.set居住環境(entity.get居住環境());
        eucCsvEntity.set機器_器械(entity.get機器_器械());
        eucCsvEntity.set認定調査特記事項番号(entity.get認定調査特記事項番号());
        eucCsvEntity.set認定調査特記事項連番(entity.get認定調査特記事項連番());
        eucCsvEntity.set原本マスク区分コード(entity.get原本マスク区分());
        eucCsvEntity.set原本マスク区分(GenponMaskKubun.toValue(entity.get原本マスク区分()).get名称());
        eucCsvEntity.set特記事項(entity.get特記事項());
        eucCsvEntity.setサービスの状況連番(entity.get状況連番());
        eucCsvEntity.setサービスの状況(entity.get状況());
        eucCsvEntity.setサービスの状況フラグ連番(entity.get状況フラグ連番());
        eucCsvEntity.setサービスの状況フラグ(entity.get状況フラグ());
        eucCsvEntity.set記入項目連番(entity.get記入項目連番());
        eucCsvEntity.setサービスの状況記入(entity.get状況記入());
        eucCsvEntity.set施設利用連番(entity.get施設利用連番());
        eucCsvEntity.set施設利用フラグ(entity.get施設利用フラグ());
        eucCsvEntity.set認知症日常生活自立度コード(entity.get認知症日常生活自立度コード());
        eucCsvEntity.set認知症日常生活自立度(NinchishoNichijoSeikatsuJiritsudoCode.toValue(entity.get認知症日常生活自立度コード()).get名称());
        eucCsvEntity.set障害日常生活自立度コード(entity.get障害日常生活自立度コード());
        eucCsvEntity.set障害日常生活自立度(ShogaiNichijoSeikatsuJiritsudoCode.toValue(entity.get障害日常生活自立度コード()).get名称());
        eucCsvEntity.set調査項目連番(entity.get調査項目連番());
        eucCsvEntity.set調査項目文言(set調査項目文言(entity.get厚労省IF識別コード(), entity.get調査項目連番()));
        eucCsvEntity.set内容(entity.get調査項目());
        return eucCsvEntity;
    }

    private RString set調査項目文言(RString 厚労省IF識別コード, RString 連番) {
        RString 調査項目文言 = RString.EMPTY;
        if (KoroshoIfShikibetsuCode.認定ｿﾌﾄ99.getコード().equals(厚労省IF識別コード)) {
            調査項目文言 = NinteichosaKomokuMapping99A.toValue(連番).get名称();
        }
        if (KoroshoIfShikibetsuCode.認定ｿﾌﾄ2002.getコード().equals(厚労省IF識別コード)) {
            調査項目文言 = NinteichosaKomokuMapping02A.toValue(連番).get名称();
        }
        if (KoroshoIfShikibetsuCode.認定ｿﾌﾄ2006_新要介護認定適用区分が未適用.getコード().equals(厚労省IF識別コード)) {
            調査項目文言 = NinteichosaKomokuMapping06A.toValue(連番).get名称();
        }
        if (KoroshoIfShikibetsuCode.認定ｿﾌﾄ2009.getコード().equals(厚労省IF識別コード)) {
            調査項目文言 = NinteichosaKomokuMapping09A.toValue(連番).get名称();
        }
        if (KoroshoIfShikibetsuCode.認定ｿﾌﾄ2009_SP3.getコード().equals(厚労省IF識別コード)) {
            調査項目文言 = NinteichosaKomokuMapping09B.toValue(連番).get名称();
        }
        return 調査項目文言;

    }

    private RString setYobuinNoFormat(RString yobuinNo) {
        RString formatYobuinNo = RString.EMPTY;
        if (!RString.isNullOrEmpty(yobuinNo)) {
            formatYobuinNo = new YubinNo(yobuinNo).getEditedYubinNo();
        }
        return formatYobuinNo;
    }

    private RString setDateFormat(RString date) {
        RString formatDate = RString.EMPTY;
        if (!RString.isNullOrEmpty(date)) {
            formatDate = new FlexibleDate(date).wareki().toDateString();
        }
        return formatDate;
    }

    /**
     * 出力件数を取得するメッソドです。
     *
     * @param 出力件数 出力件数
     * @return RString
     */
    public RString get出力件数(Decimal 出力件数) {
        RStringBuilder builder = new RStringBuilder();
        builder.append(DecimalFormatter.toコンマ区切りRString(出力件数, 0));
        return builder.toRString();
    }

    /**
     * 出力条件を作成するメッソドです。
     *
     * @param processParamter processParamter
     * @return List<RString> 出力条件List
     */
    public List<RString> get出力条件(NinteiChosaDataOutputProcessParamter processParamter) {
        RStringBuilder jokenBuilder = new RStringBuilder();
        List<RString> 出力条件List = new ArrayList<>();
        jokenBuilder.append(new RString("【認定調査委託先コード】"));
        jokenBuilder.append(processParamter.getNinteichosaItakusakiCode());
        出力条件List.add(jokenBuilder.toRString());
        jokenBuilder = new RStringBuilder();
        jokenBuilder.append(new RString("【認定調査員コード】"));
        jokenBuilder.append(processParamter.getNinteiChosainCode());
        jokenBuilder = new RStringBuilder();
        jokenBuilder.append(new RString("【市町村コード】"));
        jokenBuilder.append(processParamter.getShichosonCode());
        出力条件List.add(jokenBuilder.toRString());
        jokenBuilder = new RStringBuilder();
        jokenBuilder.append(new RString("【申請書管理番号リスト】"));
        出力条件List.add(jokenBuilder.toRString());
        jokenBuilder = new RStringBuilder();
        jokenBuilder.append(new RString("("));
        List<RString> shinseishoKanriNoList = processParamter.getShinseishoKanriNoList();
        for (RString shinseishoKanriNo : shinseishoKanriNoList) {
            jokenBuilder.append(shinseishoKanriNo);
            jokenBuilder.append(new RString(","));
        }
        jokenBuilder.append(new RString(")"));
        出力条件List.add(jokenBuilder.toRString());
        return 出力条件List;
    }

    /**
     * アクセスログを出力するメッソドです。
     *
     * @param 申請書管理番号 申請書管理番号
     */
    public void getアクセスログ(RString 申請書管理番号) {
        AccessLogger.log(AccessLogType.照会, toPersonalData(申請書管理番号));
    }

    private PersonalData toPersonalData(RString 申請書管理番号) {
        ExpandedInformation expandedInfo = new ExpandedInformation(new Code("0001"), new RString("申請書管理番号"), 申請書管理番号);
        return PersonalData.of(ShikibetsuCode.EMPTY, expandedInfo);
    }
}
