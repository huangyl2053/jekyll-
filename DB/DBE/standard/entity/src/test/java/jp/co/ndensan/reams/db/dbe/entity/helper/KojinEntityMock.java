//TODO n3317　塚田萌　使ってないようなのでコメントアウト。確認取れたら削除

///*
// * To change this template, choose Tools | Templates
// * and open the template in the editor.
// */
//package jp.co.ndensan.reams.db.dbe.entity.helper;
//
//import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.AgeArrivalDay;
//import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.KannaiKangai;
//import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.UnknownDate;
//import jp.co.ndensan.reams.ur.urz.definition.shikibetsutaisho.enumeratedtype.JukiIdoJiyu;
//import jp.co.ndensan.reams.ur.urz.definition.shikibetsutaisho.enumeratedtype.JuminJotai;
//import jp.co.ndensan.reams.ur.urz.definition.shikibetsutaisho.enumeratedtype.JuminShubetsu;
//import jp.co.ndensan.reams.ur.urz.definition.shikibetsutaisho.enumeratedtype.StatusOfMidToLongTermResidence;
//import jp.co.ndensan.reams.ur.urz.definition.shikibetsutaisho.enumeratedtype.StatusOfResidence;
//import jp.co.ndensan.reams.ur.urz.definition.shikibetsutaisho.enumeratedtype.Tsuzukigara;
//import jp.co.ndensan.reams.ur.urz.entity.basic.KojinEntity;
//import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
//import jp.co.ndensan.reams.uz.uza.lang.RDate;
//import jp.co.ndensan.reams.uz.uza.lang.RString;
//import static org.mockito.Mockito.*;
//
///**
// * KojinEntityを生成するためのMockクラスです
// *
// * @author N8187 久保田 英男
// */
//public final class KojinEntityMock {
//
//    private KojinEntityMock() {
//    }
//
//    public static KojinEntity getSpiedInstance() {
//        KojinEntity defaultData = new KojinEntity();
//        defaultData.setワークスペース_名称(new RString("ワークスペース_名称"));
//        defaultData.setワークスペース_半角カナ名称(new RString("ワークスペース_半角ｶﾅ名称"));
//        defaultData.setワークスペース住所_住所コード(new RString("1000000000"));
//        defaultData.setワークスペース住所_郵便番号(new RString("3801000"));
//        defaultData.setワークスペース住所_町域(new RString("ワークスペース住所_町域"));
//        defaultData.setワークスペース住所_番地(new RString("ワークスペース住所_番地"));
//        defaultData.setワークスペース住所_方書(new RString("ワークスペース住所_方書"));
//        defaultData.setワークスペース住所_行政区(new RString("ワークスペース住所_行政区"));
//        defaultData.setワークスペース住所_棟部屋(new RString("ワークスペース住所_棟部屋"));
//        defaultData.setワークスペース_電話番号(new RString("08012345678"));
//        defaultData.setワークスペース_電話番号備考(new RString("ワーカー_電話番号備考"));
//        defaultData.setワーカー_入社年月日(new RDate("20000101"));
//        defaultData.setワーカー_退社年月日(new RDate("20000102"));
//        defaultData.set識別対象_識別コード(new RString("2234567890"));
//        defaultData.set識別対象_個人番号(new RString("2000000001"));
//        defaultData.set識別対象住所_住所コード(new RString("2000000002"));
//        defaultData.set識別対象住所_郵便番号(new RString("3802000"));
//        defaultData.set識別対象住所_町域(new RString("識別対象住所_町域"));
//        defaultData.set識別対象住所_番地(new RString("識別対象住所_番地"));
//        defaultData.set識別対象住所_方書(new RString("識別対象住所_方書"));
//        defaultData.set識別対象住所_行政区(new RString("識別対象住所_行政区"));
//        defaultData.set識別対象住所_棟部屋(new RString("識別対象住所_棟部屋"));
//        defaultData.set識別対象_名称(new RString("識別対象_名称"));
//        defaultData.set識別対象_半角カナ名称(new RString("識別対象_半角ｶﾅ名称"));
//        defaultData.set識別対象送付先住所_住所コード(new RString("2000000003"));
//        defaultData.set識別対象送付先住所_郵便番号(new RString("3802001"));
//        defaultData.set識別対象送付先住所_町域(new RString("識別対象送付先住所_町域"));
//        defaultData.set識別対象送付先住所_番地(new RString("識別対象送付先住所_番地"));
//        defaultData.set識別対象送付先住所_方書(new RString("識別対象送付先住所_方書"));
//        defaultData.set識別対象送付先住所_行政区(new RString("識別対象送付先住所_行政区"));
//        defaultData.set識別対象送付先住所_棟部屋(new RString("識別対象送付先住所_棟部屋"));
//        defaultData.set識別対象送付先_名称(new RString("識別対象送付先_名称"));
//        defaultData.set識別対象送付先_半角カナ名称(new RString("識別対象送付先_半角ｶﾅ名称"));
//        defaultData.set識別対象_直近の異動事由(JukiIdoJiyu.転入);
//        defaultData.set個人_旧姓(new RString("個人_旧姓"));
//        defaultData.set個人_生年月日(new RString("20000201"));
//        defaultData.set個人_年齢到達日(AgeArrivalDay.当日);
//        defaultData.set個人_生年月日不明情報(UnknownDate.不明なし);
//        defaultData.set個人_世帯コード(new RString("3000000000"));
//        defaultData.set個人_続柄1(Tsuzukigara.世帯主);
//        defaultData.set個人_続柄2(Tsuzukigara.長男);
//        defaultData.set個人_続柄3(Tsuzukigara.二男);
//        defaultData.set個人_続柄4(Tsuzukigara.三男);
//        defaultData.set個人_住民種別(JuminShubetsu.日本人住民);
//        defaultData.set個人_住民状態(JuminJotai.住民);
//        defaultData.set住基個人_住民となった事由(JukiIdoJiyu.転入);
//        defaultData.set住基個人_住民となった年月日(new RDate("20000301"));
//        defaultData.set住基個人_住民でなくなった事由(JukiIdoJiyu.転居);
//        defaultData.set住基個人_住民でなくなった年月日(new RDate("20000302"));
//        defaultData.set住基個人_住所を定めた事由(JukiIdoJiyu.転入);
//        defaultData.set住基個人_住所を定めた年月日(new RDate("20000303"));
//        defaultData.set日本人_本籍地(new RString("日本人_本籍地"));
//        defaultData.set日本人_筆頭者(new RString("日本人_筆頭者"));
//        defaultData.set日本人_帰化年月日(new RDate("20000401"));
//        defaultData.set外国人_通称名(new RString("外国人_通称名"));
//        defaultData.set外国人_併記名(new RString("外国人_併記名"));
//        defaultData.set外国人_アルファベット氏名(new RString("外国人_アルファベット氏名"));
//        defaultData.set外国人_在留資格(StatusOfResidence.公用);
//        defaultData.set外国人_在留期間(new RString("2009100"));
//        defaultData.set外国人_住基法第30条45規定区分(StatusOfMidToLongTermResidence.中長期在留者);
//        defaultData.set外国人_在留期間等の満了の日(new RDate("20000501"));
//        defaultData.set外国人_国籍地域_コード(new RString("4000000000"));
//        defaultData.set外国人_国籍地域_名称(new RString("外国人_国籍地域_名称"));
//        defaultData.set住民_再転入者(false);
//        defaultData.set住民_最後に転出した時の転出年月日(new RDate("20000601"));
//        defaultData.set住民_転入前住所_住所コード(new RString("5000000000"));
//        defaultData.set住民_転入前住所_郵便番号(new RString("3803001"));
//        defaultData.set住民_転入前住所_町域(new RString("住民_転入前住所_町域"));
//        defaultData.set住民_転入前住所_番地(new RString("住民_転入前住所_番地"));
//        defaultData.set住民_転入前住所_方書(new RString("住民_転入前住所_方書"));
//        defaultData.set住民_転入前住所_行政区(new RString("住民_転入前住所_行政区"));
//        defaultData.set住民_転入前住所_棟部屋(new RString("住民_転入前住所_棟部屋"));
//        defaultData.set死亡者_死亡年月日(new RDate("20000701"));
//        defaultData.set死亡者_死亡年月日不明の文字列(new RString("不明なし文字列"));
//        defaultData.set死亡者_死亡年月日不明情報(UnknownDate.不明なし);
//        defaultData.set消除者_職権消除年月日(new RDate("20000801"));
//        defaultData.set消除者_職権消除事由(JukiIdoJiyu.転居);
//        defaultData.set転出者_転出先住所_住所コード(new RString("6000000000"));
//        defaultData.set転出者_転出先住所_郵便番号(new RString("3804001"));
//        defaultData.set転出者_転出先住所_町域(new RString("転出者_転出先住所_町域"));
//        defaultData.set転出者_転出先住所_番地(new RString("転出者_転出先住所_番地"));
//        defaultData.set転出者_転出先住所_方書(new RString("転出者_転出先住所_方書"));
//        defaultData.set転出者_転出先住所_行政区(new RString("転出者_転出先住所_行政区"));
//        defaultData.set転出者_転出先住所_棟部屋(new RString("転出者_転出先住所_棟部屋"));
//        defaultData.set転出者_転出年月日(new RDate("20000901"));
//        defaultData.set転出者_転出予定住所_住所コード(new RString("6000000001"));
//        defaultData.set転出者_転出予定住所_郵便番号(new RString("3804002"));
//        defaultData.set転出者_転出予定住所_町域(new RString("転出者_転出予定住所_町域"));
//        defaultData.set転出者_転出予定住所_番地(new RString("転出者_転出予定住所_番地"));
//        defaultData.set転出者_転出予定住所_方書(new RString("転出者_転出予定住所_方書"));
//        defaultData.set転出者_転出予定住所_行政区(new RString("転出者_転出予定住所_行政区"));
//        defaultData.set転出者_転出予定住所_棟部屋(new RString("転出者_転出予定住所_棟部屋"));
//        defaultData.set転出者_転出予定年月日(new RDate("20000902"));
//        defaultData.set転出者_転出確定住所_住所コード(new RString("6000000002"));
//        defaultData.set転出者_転出確定住所_郵便番号(new RString("3804003"));
//        defaultData.set転出者_転出確定住所_町域(new RString("転出者_転出確定住所_町域"));
//        defaultData.set転出者_転出確定住所_番地(new RString("転出者_転出確定住所_番地"));
//        defaultData.set転出者_転出確定住所_方書(new RString("転出者_転出確定住所_方書"));
//        defaultData.set転出者_転出確定住所_行政区(new RString("転出者_転出確定住所_行政区"));
//        defaultData.set転出者_転出確定住所_棟部屋(new RString("転出者_転出確定住所_棟部屋"));
//        defaultData.set転出者_転出確定年月日(new RDate("20000903"));
//        defaultData.set管内管外区分(KannaiKangai.管内);
//        defaultData.setワークスペース_管内管外区分(KannaiKangai.管内);
//        defaultData.set転出者_転出先住所_管内管外区分(KannaiKangai.管内);
//        defaultData.set転出者_転出予定住所_管内管外区分(KannaiKangai.管内);
//        defaultData.set転出者_転出確定住所_管内管外区分(KannaiKangai.管内);
//        defaultData.set住民_転入前住所_管内管外区分(KannaiKangai.管内);
//        defaultData.set識別対象送付先住所_管内管外区分(KannaiKangai.管内);
//        defaultData.set識別対象送付先_業務(GyomuCode.UZフレームワーク);
//        defaultData.set識別対象送付先_有効開始年月日(new RDate("20000903"));
//        defaultData.set識別対象送付先_有効終了年月日(new RDate("20000903"));
//
//        return spy(defaultData);
//    }
//}
