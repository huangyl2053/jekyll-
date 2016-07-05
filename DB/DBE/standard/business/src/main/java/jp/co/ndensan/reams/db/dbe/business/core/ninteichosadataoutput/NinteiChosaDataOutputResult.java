/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.ninteichosadataoutput;

import jp.co.ndensan.reams.db.dbe.entity.db.relate.ninteichosadataoutput.NinteiChosaDataOutputBatchRelateEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.ninteichosadataoutput.NinteiChosaDataOutputEucCsvEntity;
import jp.co.ndensan.reams.db.dbz.definition.core.ninteichosahyou.NinteichosaKomokuMapping09B;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.GenponMaskKubun;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.KoroshoIfShikibetsuCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ChosaJisshiBashoCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.NinchishoNichijoSeikatsuJiritsudoCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.NinteiChousaIraiKubunCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ServiceKubunCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ShogaiNichijoSeikatsuJiritsudoCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.TokkijikoTextImageKubun;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.NinteiShinseiShinseijiKubunCode;

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
        eucCsvEntity.set認定申請年月日(entity.get認定申請年月日());
        eucCsvEntity.set認定申請区分_申請時_コード(entity.get認定申請区分_申請時_コード());
        eucCsvEntity.set認定申請区分申請時(NinteiShinseiShinseijiKubunCode.toValue(entity.get認定申請区分_申請時_コード()).get名称());
        eucCsvEntity.set被保険者氏名(entity.get被保険者氏名());
        eucCsvEntity.set被保険者氏名カナ(entity.get被保険者氏名カナ());
        eucCsvEntity.set生年月日(entity.get生年月日());
        eucCsvEntity.set年齢(entity.get年齢());
        eucCsvEntity.set性別(entity.get性別());
        eucCsvEntity.set郵便番号(entity.get郵便番号());
        eucCsvEntity.set住所(entity.get住所());
        eucCsvEntity.set電話番号(entity.get電話番号());
        eucCsvEntity.set保険者名(entity.get市町村名称());
        eucCsvEntity.set認定調査依頼完了年月日(entity.get認定調査依頼完了年月日());
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
        eucCsvEntity.set認定調査実施年月日(entity.get認定調査実施年月日());
        eucCsvEntity.set認定調査受領年月日(entity.get認定調査受領年月日());
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
        eucCsvEntity.set利用施設郵便番号(entity.get利用施設郵便番号());
        eucCsvEntity.set特記(entity.get特記());
        eucCsvEntity.set認定調査特記事項受付年月日(entity.get認定調査特記事項受付年月日());
        eucCsvEntity.set認定調査特記事項受領年月日(entity.get認定調査特記事項受領年月日());
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
        eucCsvEntity.set調査項目文言(NinteichosaKomokuMapping09B.toValue(entity.get調査項目連番()).get名称());
        eucCsvEntity.set内容(entity.get調査項目());
        return eucCsvEntity;
    }
}
