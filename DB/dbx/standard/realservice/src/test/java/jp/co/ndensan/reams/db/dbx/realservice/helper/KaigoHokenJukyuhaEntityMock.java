/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.realservice.helper;

import jp.co.ndensan.reams.db.dbx.definition.enumeratedtype.NinchishoKoreishaNichijoSeikatsuJiritsudo;
import jp.co.ndensan.reams.db.dbx.definition.enumeratedtype.NinteiShinseiKubunHorei;
import jp.co.ndensan.reams.db.dbx.definition.enumeratedtype.NinteiShinseiKubunShinsei;
import jp.co.ndensan.reams.db.dbx.definition.enumeratedtype.NinteiShinseiYukoKubun;
import jp.co.ndensan.reams.db.dbx.definition.enumeratedtype.ShogaiKoreiNichijoSeikatsuJiritsudo;
import jp.co.ndensan.reams.db.dbx.definition.enumeratedtype.TorisageKubun;
import jp.co.ndensan.reams.db.dbx.definition.enumeratedtype.YoKaigoJotaiKubun;
import jp.co.ndensan.reams.db.dbx.entity.basic.KaigohokenJukyushaEntity;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.mockito.Mockito.*;

/**
 * 介護保険受給者エンティティのモッククラスです。
 *
 * @author N2806 太田 智之
 */
public class KaigoHokenJukyuhaEntityMock {

    public static KaigohokenJukyushaEntity getSpiedInstance() {
        KaigohokenJukyushaEntity entity = new KaigohokenJukyushaEntity();

        entity.setB介護被保険者番号(RString.EMPTY);
        entity.setC申請番号(RString.EMPTY);
        entity.set一時判定_要介護状態区分(YoKaigoJotaiKubun.要介護1.getCode());
        entity.set主治医医師識別コード(RString.EMPTY);
        entity.set主治医氏名(RString.EMPTY);
        entity.set事業者名称(RString.EMPTY);
        entity.set作成依頼年月日(RDate.MAX);
        entity.set依頼年月日(RDate.MAX);
        entity.set判定年月日(RDate.MAX);
        entity.set医療機関コード(new RString("1234567890"));
        entity.set医療機関名称(RString.EMPTY);
        entity.set取下げ区分(TorisageKubun.認定申請有効);
        entity.set受領年月日(RDate.MAX);
        entity.set合議体番号(0);
        entity.set喪失年月日(RDate.MAX);
        entity.set回答年月日(RDate.MAX);
        entity.set地方自治体コード(new RString("201014"));
        entity.set完了年月日(RDate.MAX);
        entity.set実施年月日(RDate.MAX);
        entity.set審査会意見(RString.EMPTY);
        entity.set有効終了年月日(RDate.MAX);
        entity.set有効開始年月日(RDate.MAX);
        entity.set法令申請区分(NinteiShinseiKubunHorei.新規申請);
        entity.set特定疾病(RString.EMPTY);
        entity.set申請年月日(RDate.MAX);
        entity.set申請時申請区分(NinteiShinseiKubunShinsei.新規申請);
        entity.set申請有効区分(NinteiShinseiYukoKubun.申請中);
        entity.set異動年月日(RDate.MAX);
        entity.set要介護状態区分(YoKaigoJotaiKubun.要介護1.getCode());
        entity.set認定年月日(RDate.MAX);
        entity.set認定申請理由(RString.EMPTY);
        entity.set認定調査員コード(RString.EMPTY);
        entity.set認定調査員氏名(RString.EMPTY);
        entity.set認知症加算_要介護状態区分(YoKaigoJotaiKubun.要介護1.getCode());
        entity.set認知症高齢者生活自立度(NinchishoKoreishaNichijoSeikatsuJiritsudo.自立);
        entity.set調査委託先コード(RString.EMPTY);
        entity.set識別コード(RString.EMPTY);
        entity.set資料作成年月日(RDate.MAX);
        entity.set開催予定年月日(RDate.MAX);
        entity.set障害高齢者生活自立度(ShogaiKoreiNichijoSeikatsuJiritsudo.自立);

        return spy(entity);
    }
}
